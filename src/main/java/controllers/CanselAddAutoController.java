package controllers;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import daoImpl.DaoImplAuto;
import model.Auto;

@Controller
public class CanselAddAutoController {
	
	@Autowired
	SessionFactory sf;
	
	@RequestMapping(value = "/canselAddAuto",method = RequestMethod.POST)
	public ModelAndView canselAddAuto() {
		
		ModelAndView modelAndView = new ModelAndView("master");
		DaoImplAuto daoImplAuto = new DaoImplAuto(sf);
		List<Auto>autos = daoImplAuto.getAllAuto();
		modelAndView.addObject("autos",autos);
		
		return modelAndView;
	}

}
