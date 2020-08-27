package controllers;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import daoImpl.DaoImplUser;
import model.RegUser;
import model.User;

@Controller
public class UpdateUserController {

	@Autowired
	SessionFactory sf;
	
	@RequestMapping(value = "/updateUser",method = RequestMethod.POST)
	public ModelAndView name(@SessionAttribute("userSession")User userSession,@ModelAttribute("regUser")RegUser regUser) {
		
		ModelAndView modelAndView = new ModelAndView("user");
		DaoImplUser daoImplUser = new DaoImplUser(sf);
		userSession.setName(regUser.getName());
		if (regUser.getPassword().equals("")) {
			userSession.getPassword();
		}else {
			userSession.setPassword(regUser.getPassword());
		}
		userSession.setEmail(regUser.getEmail());
		userSession.setAge(regUser.getAge());
		userSession.setExperience(regUser.getExperience());
		daoImplUser.updateUser(userSession);
		modelAndView.addObject("userSession",userSession);
		
		return modelAndView;
	}
}
