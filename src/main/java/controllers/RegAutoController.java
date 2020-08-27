package controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import daoImpl.DaoImplAuto;
import model.Auto;
import model.RegAuto;

@Controller
public class RegAutoController {

	@Autowired
	SessionFactory sf;
	//добавление новой машини
	public void addAuto(RegAuto regAuto,File file) {
		DaoImplAuto daoImplAuto = new DaoImplAuto(sf);
		daoImplAuto.addAuto(new Auto(file.getName(), regAuto.getNameAuto(), regAuto.getInfo(), regAuto.getPrice()));
		// file.getName() для изображения названия в базе данных
	}
	
	//добавить картинку в базу данных 
	public void addImages(RegAuto regAuto,File file) {
		try {
		//Path pahtImage = Paths.get("C:/Users/markes/maxmax/AutoShop/src/main/webapp/images/"+file.getName());//путь куда мы копируем файл
		Path pahtImage = Paths.get("D:/MaximWorkspace/AutoShop/src/main/webapp/images/"+file.getName());
		Path path = Paths.get(regAuto.getImage());//????
		Files.copy(path, pahtImage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value ="/jumpRegAuto",method = RequestMethod.POST)
	public ModelAndView regAuto() {
		ModelAndView modelAndView = new ModelAndView("regAuto","regAuto",new RegAuto());
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/addAuto",method = RequestMethod.POST)
	public ModelAndView addAuto(@Valid @ModelAttribute("regAuto")RegAuto regAuto,BindingResult br,@RequestParam Map<String, String>params) {
		
		ModelAndView modelAndView = null;
		DaoImplAuto daoImplAuto = new DaoImplAuto(sf);
		if (br.hasErrors()) {
			return new ModelAndView("regAuto","regAuto",new RegAuto());
		}else {
			
			File file = new File(regAuto.getImage());// создать файл для будущего изображения
			addAuto(regAuto, file);
			addImages(regAuto, file);//добавление картини в базу
		}
		
		
		
		List<Auto>autos = daoImplAuto.getAllAuto();
		modelAndView = new ModelAndView("master");
		modelAndView.addObject("autos",autos);
		return modelAndView;
	}
	
}
