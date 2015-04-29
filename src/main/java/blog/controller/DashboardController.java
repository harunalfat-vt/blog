package blog.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import blog.data.enumeration.EnumSessionVariables;
import blog.data.model.Post;
import blog.service.DashboardService;
import blog.ui.model.CommonUi;
import blog.util.SessionUtil;

@Controller
public class DashboardController {
	
	@Autowired
	private DashboardService dashboardService;
	
	@RequestMapping(value="/dashboard", method = RequestMethod.GET)
	public ModelAndView index(HttpSession session, HttpServletResponse response, ModelMap requestMap) throws IOException{
		SessionUtil.isLogged(session, response);
		CommonUi ui = new CommonUi(requestMap);
		return new ModelAndView("dashboard/dashboard", ui);
	}
	
	@RequestMapping(value="/newPost", method = RequestMethod.POST)
	public ModelAndView index(HttpSession session, HttpServletResponse response, @ModelAttribute("data") Post post) throws IOException{
		SessionUtil.isLogged(session, response);
		post.setUser((String) session.getAttribute(EnumSessionVariables.user.toString()));
		dashboardService.insertPost(post);
		return new ModelAndView("redirect:post/"+post.getId());
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session, HttpServletResponse response) throws IOException{
		SessionUtil.isLogged(session, response);
		session.invalidate();
		return new ModelAndView("redirect:loginEncryptedByMyself");
	}
	
	@RequestMapping(value="/updateAbout", method = RequestMethod.GET)
	public ModelAndView updateAboutGet(HttpSession session, HttpServletResponse response) throws IOException{
		SessionUtil.isLogged(session, response);
		Post about = dashboardService.getAboutContent();
		CommonUi ui = new CommonUi();
		ui.addAttribute("about",about);
		return new ModelAndView("dashboard/dashboard-about",ui);
	}
	
	@RequestMapping(value="/updateAbout", method = RequestMethod.POST)
	public ModelAndView updateAboutPost(HttpSession session, HttpServletResponse response, @ModelAttribute("data") Post post) throws IOException{
		SessionUtil.isLogged(session, response);
		post.setUser((String) session.getAttribute(EnumSessionVariables.user.toString()));
		dashboardService.updateAbout(post);
		return new ModelAndView("redirect:about");
	}
	
}
