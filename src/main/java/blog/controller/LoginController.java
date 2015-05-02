package blog.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;

import blog.data.enumeration.EnumSessionVariables;
import blog.data.model.UrlModel;
import blog.data.model.User;
import blog.service.CredentialService;
import blog.ui.model.CommonUi;
import blog.util.SessionUtil;

@Controller
public class LoginController {

	@Autowired
	private CredentialService credentialService;
	
	@RequestMapping(value = "/loginEncryptedByMyself", method = RequestMethod.GET)
	public ModelAndView login(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws HttpClientErrorException, IOException {
		if (SessionUtil.isLogged(session, response)){
			UrlModel url = new UrlModel(request);
			response.setHeader("Location", url.getFull()+"/dashboard/postList");
		}
		CommonUi commonUi = new CommonUi();		
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
