package controllers;

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

import daoImpl.DaoImplUser;
import model.User;

@Controller
public class DelUserController {

	@Autowired
	SessionFactory sf;
	
	@RequestMapping(value ="/delUser",method = RequestMethod.POST)
	public ModelAndView delUser(@RequestParam Map<String, String>params,@SessionAttribute("userSession")User userSession) {
		
		ModelAndView modelAndView = null;
		DaoImplUser daoImplUser = new DaoImplUser(sf);
		List<User>users = daoImplUser.getAllUser();
		
		for (int i = 0; i < users.size(); i++) {
			if (params.get("d"+users.get(i).getIdUser())!=null) {
				daoImplUser.delUser(users.get(i));
				break;
			}
		}
		users = daoImplUser.getAllUser();
		modelAndView = new ModelAndView("admin");
		modelAndView.addObject("users",users);
		modelAndView.addObject("userSession",userSession);
		
		
		return modelAndView;
	}
	
}
