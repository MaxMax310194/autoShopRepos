package controllers;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import daoImpl.DaoImplAuto;
import daoImpl.DaoImplUser;
import model.Auto;
import model.LoginUser;
import model.User;

@Controller
@SessionAttributes(value ="userSession")
public class LoginController {

	
	@Autowired
	SessionFactory sf;
	
	public User checkUser(LoginUser  loginUser) {
		DaoImplUser daoImplUser = new DaoImplUser(sf);
		User user = daoImplUser.getUserByNameAndPassword(loginUser.getName(), loginUser.getPassword());
		if (user!=null) {
			return user;
		} else {
			return null;
		}
	
	}
	
	@RequestMapping(value = "/jumpLogin",method = RequestMethod.GET)
	public ModelAndView jumpLogin() {
		
		return new ModelAndView("login","loginUser", new LoginUser());
	}
	
	@RequestMapping(value = "/enterLogin",method = RequestMethod.POST)
	public ModelAndView name(@Valid @ModelAttribute("loginUser")LoginUser loginUser,BindingResult br) {
		ModelAndView modelAndView = null;
		DaoImplUser daoImplUser = new DaoImplUser(sf);
		DaoImplAuto daoImplAuto = new DaoImplAuto(sf);
		List<Auto>autos;
		
		if (br.hasErrors()) {
			return new ModelAndView("login","loginUser", new LoginUser());
		}else {
			User user = checkUser(loginUser);
			if (user!=null) {
				modelAndView = new ModelAndView("user");
				modelAndView.addObject("user",user);
			}else {
				modelAndView = new ModelAndView("login");
			}
			if (user == null) {
				br.rejectValue("password", "error.LoginUser", "An incorrect login or password");
			}
			if (br.hasErrors()) {
				return new ModelAndView("login","loginUser", new LoginUser());
			}
			if (user!=null) {
				
				switch (user.getRole()) {
				case "admin":
					modelAndView = new ModelAndView("admin");
					List<User>users = daoImplUser.getAllUser();
					modelAndView.addObject("users",users);
					break;
					
				case "master":
					modelAndView = new ModelAndView("master");
					autos = daoImplAuto.getAllAuto();
					modelAndView.addObject("autos",autos);
					break;

				default:
					modelAndView = new ModelAndView("user");
					autos = daoImplAuto.getAllAuto();
					modelAndView.addObject("autos",autos);
					break;
				}
				modelAndView.addObject("userSession",user);
			}
			return modelAndView;
			
			}
		
	}
}
