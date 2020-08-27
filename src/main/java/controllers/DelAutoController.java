package controllers;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import daoImpl.DaoImplAuto;
import model.Auto;
import model.User;

@Controller
public class DelAutoController {

	@Autowired
	SessionFactory sf;
	
	@RequestMapping(value = "/delAuto",method = RequestMethod.POST)
	public ModelAndView delAuto(@RequestParam Map<String, String>params,@SessionAttribute("userSession")User userSession) {
		ModelAndView modelAndView = new ModelAndView("master");
		DaoImplAuto daoImplAuto = new DaoImplAuto(sf);
		List<Auto>autos = daoImplAuto.getAllAuto();
		
		for (int i = 0; i < autos.size(); i++) {
			if (params.get("d"+autos.get(i).getIdAuto())!=null) {
				String path ="C:/Users/markes/maxmax/AutoShop/src/main/webapp/images/"+autos.get(i).getImage();
				File file = new File(path);
				file.delete();
				daoImplAuto.delAuto(autos.get(i));
			}
		}
		autos = daoImplAuto.getAllAuto();
		modelAndView.addObject("autos",autos);
		modelAndView.addObject("userSession",userSession);
		return modelAndView;
	}
}
