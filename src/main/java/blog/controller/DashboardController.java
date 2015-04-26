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
import blog.data.model.Post;
import blog.service.DashboardService;
import blog.ui.model.CommonUi;

@Controller
public class DashboardController {
	
	@Autowired
	private DashboardService dashboardService;
	
	@RequestMapping(value="/dashboard", method = RequestMethod.GET)
	public ModelAndView index(ModelMap requestMap){		
		CommonUi ui = new CommonUi(requestMap);
		return new ModelAndView("dashboard/dashboard", ui);
	}
	
	@RequestMapping(value="/newPost", method = RequestMethod.POST)
	public ModelAndView index(HttpSession session, @ModelAttribute("data") Post post){
		post.setUser((String) session.getAttribute(EnumSessionVariables.user.toString()));
		dashboardService.insertPost(post);		
		CommonUi ui = new CommonUi();
		ui.addAttribute("post", post);
		return new ModelAndView("post", ui);
	}
	
}
