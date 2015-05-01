package blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import blog.data.enumeration.EnumSessionVariables;
import blog.data.model.User;
import blog.service.CredentialService;
import blog.ui.model.CommonUi;

@Controller
public class LoginController {

	@Autowired
	private CredentialService credentialService;
	
	@RequestMapping(value = "/loginEncryptedByMyself", method = RequestMethod.GET)
	public ModelAndView login(ModelMap requestMap) {
		CommonUi commonUi = new CommonUi(requestMap);		
		return new ModelAndView("login", commonUi);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPost(HttpSession session, @ModelAttribute("credential") User user)  {
		if (credentialService.validateLogin(user.getUsername(),user.getPassword())) {
			session.setAttribute(EnumSessionVariables.user.toString(), user.getUsername());
			return new ModelAndView("redirect:dashboard/postList");
		} else{
			return new ModelAndView("login", new CommonUi());
		}
	}

}
