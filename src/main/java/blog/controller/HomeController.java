package blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import blog.data.model.Post;
import blog.service.DashboardService;
import blog.ui.model.CommonUi;

@Controller
public class HomeController {
    
	@Autowired
	private DashboardService dashboardService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView index(ModelMap requestMap){
		
		CommonUi commonUi = new CommonUi(requestMap);
		ModelAndView mav = new ModelAndView("index", commonUi);
		
		return mav;
	}
	
	@RequestMapping(value="/about", method = RequestMethod.GET)
	public ModelAndView about(ModelMap requestMap){
		
		CommonUi commonUi = new CommonUi(requestMap);
		ModelAndView mav = new ModelAndView("about", commonUi);
		
		return mav;
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
