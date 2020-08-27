package controllers;

import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import daoImpl.DaoImplAuto;
import model.Auto;
import model.RegAuto;

@Controller
@SessionAttributes(value = {"updateAuto"})
public class GoTOUpdateAutoController {

	@Autowired
	SessionFactory sf;
	
	@RequestMapping(value = "/goToUpdateAuto",method = RequestMethod.POST)
	public ModelAndView goToUpdateAuto(@RequestParam Map<String, String>params) {
		ModelAndView modelAndView = new ModelAndView("updateAuto");
		DaoImplAuto daoImplAuto = new DaoImplAuto(sf);
		List<Auto>autos = daoImplAuto.getAllAuto();
		
		for (int i = 0; i < autos.size(); i++) {
			if (params.get("u"+autos.get(i).getIdAuto())!=null) {
				modelAndView.addObject("regAuto", new RegAuto(autos.get(i).getImage(), autos.get(i).getNameAuto(), autos.get(i).getInfo(), autos.get(i).getPrice()));
			}
			modelAndView.addObject("updateAuto",autos.get(i));
		}
		
		return modelAndView;
	}
	
}
