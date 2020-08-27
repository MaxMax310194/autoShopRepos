package controllers;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import model.RegUser;
import model.User;

@Controller
public class GoToUpdateUserController {

	@Autowired
	SessionFactory sf;
	
	
	@RequestMapping(value = "/goToUpdateUser",method = RequestMethod.POST)
	public ModelAndView updateUser(@SessionAttribute("userSession")User userSession,@ModelAttribute("regUser")RegUser regUser ) {
		ModelAndView modelAndView = new ModelAndView("updateUser");
		modelAndView.addObject("regUser",new RegUser(userSession.getName(), userSession.getPassword(), userSession.getEmail(), userSession.getAge(),
				userSession.getExperience()));
		
		return modelAndView;
	}
	
}
