package blog.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;

import blog.data.enumeration.EnumSessionVariables;
import blog.data.model.PageAttribute;
import blog.data.model.Post;
import blog.service.DashboardService;
import blog.ui.model.CommonUi;
import blog.util.SessionUtil;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	
	@Autowired
	private DashboardService dashboardService;
	
	private static int pageLimit = 0;
	
	public void setPageLimit(int pageLimit) {
		DashboardController.pageLimit = pageLimit;
	}
	
	@RequestMapping(value="/post", method = RequestMethod.GET)
	public ModelAndView index(@RequestParam(value="postId",required=false) String postId, HttpSession session, HttpServletResponse response) throws IOException{
		try{
			SessionUtil.isLogged(session, response);
		} catch(HttpClientErrorException e){
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "not logged");
		}
		CommonUi ui = new CommonUi();
		if (postId != null){
			Post post = dashboardService.getPost(postId);
			ui.addAttribute("post",post);
			ui.addAttribute("status","update");
		} else{
			ui.addAttribute("status","add");
		}
		return new ModelAndView("dashboard/dashboard",ui);
	}
	
	@RequestMapping(value="/newPost", method = RequestMethod.POST)
	public ModelAndView newPost(HttpSession session, HttpServletResponse response, @ModelAttribute("data") Post post) throws IOException{
		try{
			SessionUtil.isLogged(session, response);
		} catch(HttpClientErrorException e){
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "not logged");
		}
		post.setUser((String) session.getAttribute(EnumSessionVariables.user.toString()));
		dashboardService.insertPost(post);
		return new ModelAndView("redirect:postList");
	}
	
	@RequestMapping(value="/updatePost", method = RequestMethod.POST)
	public ModelAndView updatePost(HttpSession session, HttpServletResponse response, @ModelAttribute("data") Post post) throws IOException{
		try{
			SessionUtil.isLogged(session, response);
		} catch(HttpClientErrorException e){
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "not logged");
		}
		post.setUser((String) session.getAttribute(EnumSessionVariables.user.toString()));
		dashboardService.updatePost(post);
		return new ModelAndView("redirect:postList");
	}
	
	@RequestMapping(value="/postList", method = RequestMethod.GET)
	public ModelAndView getPostList(@RequestParam(value="page",required=false) Integer page, HttpSession session, HttpServletResponse response) throws IOException{
		try{
			SessionUtil.isLogged(session, response);
		} catch(HttpClientErrorException e){
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "not logged");
		}
		if (page == null) page = 1;
		List<Post> postList = dashboardService.getPostList(page, pageLimit);
		int total = postList.size();
		CommonUi ui = new CommonUi();
		ui.setPageAttribute(new PageAttribute(page, total, pageLimit));
		ui.addAttribute("postList", postList);
		return new ModelAndView("dashboard/dashboard-post-list",ui);
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session, HttpServletResponse response) throws IOException{
		try{
			SessionUtil.isLogged(session, response);
		} catch(HttpClientErrorException e){
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "not logged");
		}
		session.invalidate();
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/updateAbout", method = RequestMethod.GET)
	public ModelAndView updateAboutGet(HttpSession session, HttpServletResponse response) throws IOException{
		try{
			SessionUtil.isLogged(session, response);
		} catch(HttpClientErrorException e){
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "not logged");
		}
		Post about = dashboardService.getAboutContent();
		CommonUi ui = new CommonUi();
		ui.addAttribute("about",about);
		return new ModelAndView("dashboard/dashboard-about",ui);
	}
	
	@RequestMapping(value="/updateAbout", method = RequestMethod.POST)
	public ModelAndView updateAboutPost(HttpSession session, HttpServletResponse response, @ModelAttribute("data") Post post) throws IOException{
		try{
			SessionUtil.isLogged(session, response);
		} catch(HttpClientErrorException e){
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "not logged");
		}		
		post.setUser((String) session.getAttribute(EnumSessionVariables.user.toString()));
		dashboardService.updateAbout(post);
		return new ModelAndView("redirect:postList");
	}
	
}
