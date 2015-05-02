package blog.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import blog.data.model.Post;
import blog.data.model.UrlModel;
import blog.service.DashboardService;
import blog.ui.model.CommonUi;

@Controller
public class HomeController {
    
	@Autowired
	private DashboardService dashboardService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request){
		CommonUi ui = new CommonUi();
		List<Post> postList = dashboardService.getPostList(1, 10);
		ui.addAttribute("postList",postList);
		ui.setCurrentUrl(request);
		return new ModelAndView("index",ui);
	}
	
	@RequestMapping(value="/about", method = RequestMethod.GET)
	public ModelAndView about(HttpServletRequest request){
		Post about = dashboardService.getAboutContent();
		CommonUi ui = new CommonUi();
		ui.addAttribute("about", about);
		ui.setCurrentUrl(request);
		return new ModelAndView("about",ui);
	}
	
	@RequestMapping(value="/post", method = RequestMethod.GET)
	public ModelAndView post(@RequestParam("postId") String id, HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		Post post = dashboardService.getPost(id);
		if (post == null) response.sendError(404, new UrlModel(request).getSiteOnly());
		CommonUi ui = new CommonUi();
		ui.addAttribute("post", post);
		ui.setCurrentUrl(request);
		return new ModelAndView("post",ui);
	}
	
	@RequestMapping(value="/contact", method = RequestMethod.GET)
	public ModelAndView contact(HttpServletRequest request){		
		CommonUi commonUi = new CommonUi();
		ModelAndView mav = new ModelAndView("contact", commonUi);
		
		return mav;
	}
	
	
	
}
