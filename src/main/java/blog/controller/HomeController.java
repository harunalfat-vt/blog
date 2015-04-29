package blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import blog.data.model.Post;
import blog.service.DashboardService;
import blog.ui.model.CommonUi;

@Controller
public class HomeController {
    
	@Autowired
	private DashboardService dashboardService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView index(@RequestParam(value="page",required=false) Integer page, ModelMap requestMap){
		CommonUi ui = new CommonUi(requestMap);
		List<Post> postList = dashboardService.getPostList(1, 10);
		ui.addAttribute("postList",postList);
		return new ModelAndView("index",ui);
	}
	
	@RequestMapping(value="/about", method = RequestMethod.GET)
	public ModelAndView about(ModelMap requestMap){
		Post about = dashboardService.getAboutContent();
		CommonUi ui = new CommonUi(requestMap);
		ui.addAttribute("about", about);
		return new ModelAndView("about",ui);
	}
	
	@RequestMapping(value="/post/{title}", method = RequestMethod.GET)
	public ModelAndView post(@PathVariable String title){
		
		Post post = dashboardService.getPost(title);
		CommonUi ui = new CommonUi();
		ui.addAttribute("post", post);
		return new ModelAndView("post",ui);
	}
	
	@RequestMapping(value="/contact", method = RequestMethod.GET)
	public ModelAndView contact(ModelMap requestMap){
		
		CommonUi commonUi = new CommonUi(requestMap);
		ModelAndView mav = new ModelAndView("contact", commonUi);
		
		return mav;
	}
	
	
	
}
