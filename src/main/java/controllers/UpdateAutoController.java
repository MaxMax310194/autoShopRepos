package controllers;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import daoImpl.DaoImplAuto;
import model.Auto;
import model.RegAuto;
import model.User;

@Controller
public class UpdateAutoController {

	@Autowired
	SessionFactory sf;
	
	public void updateImages(Auto updateAuto,File file) {
		try {
			//Path pahtImage = Paths.get("C:/Users/markes/maxmax/AutoShop/src/main/webapp/images/"+file.getName());//путь куда мы копируем файл
			Path pahtImage = Paths.get("D:/MaximWorkspace/AutoShop/src/main/webapp/images/"+file.getName());
			Path path = Paths.get(updateAuto.getImage());
			Files.copy(path, pahtImage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/updateAuto",method = RequestMethod.POST)
	public ModelAndView updateAuto(@SessionAttribute("updateAuto")Auto updateAuto,@ModelAttribute("regAuto")RegAuto regAuto,@SessionAttribute("userSession")User userSession,
			@RequestParam Map<String, String>params) {
		
		ModelAndView modelAndView = new ModelAndView("master");
		DaoImplAuto daoImplAuto = new DaoImplAuto(sf);
		File file = new File(regAuto.getImage());
		updateAuto.setImage(regAuto.getImage());
		
		updateImages(updateAuto, file);
		updateAuto.setNameAuto(regAuto.getNameAuto());
		updateAuto.setInfo(regAuto.getInfo());
		updateAuto.setPrice(regAuto.getPrice());
		daoImplAuto.updateAuto(updateAuto);
		List<Auto>autos = daoImplAuto.getAllAuto();
		modelAndView.addObject("autos",autos);
		modelAndView.addObject("userSession",userSession);
		
		return modelAndView;
	}
	
}
