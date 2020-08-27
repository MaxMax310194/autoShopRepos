package controllers;

import javax.validation.Valid;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import daoImpl.DaoImplUser;
import model.LoginUser;
import model.RegUser;
import model.User;

@Controller
public class RegistrationController {

	@Autowired
	SessionFactory sf;
	
	@RequestMapping(value = "/jumpReg",method = RequestMethod.GET)
	public  ModelAndView jumpReg() {
		
		return new ModelAndView("registration","regUser",new RegUser());
	}
	
	@RequestMapping(value = "/regUser",method = RequestMethod.POST)
	public ModelAndView regUser(@Valid @ModelAttribute("regUser")RegUser regUser,BindingResult br) {
		
		ModelAndView modelAndView = new ModelAndView("login","loginUser",new LoginUser());
		DaoImplUser daoImplUser = new DaoImplUser(sf);
		User user = daoImplUser.getUserByName(regUser.getName());//??????
		if (user!=null) {
			br.rejectValue("name", "error.RegistrationVoter", "An account already exists for this name");
			return new ModelAndView("registration","regUser" , regUser);
		}if (br.hasErrors()) {
			return new ModelAndView("registration","regUser", new RegUser());
		} else {
			user = new User(regUser.getName(), regUser.getPassword(), regUser.getEmail(), regUser.getAge(), regUser.getExperience(), 
					"user" );
		}
		daoImplUser.addUser(user);
		return modelAndView;
	}
}
