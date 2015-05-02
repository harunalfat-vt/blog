package blog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import blog.ui.model.CommonUi;

@ControllerAdvice
public class ErrorController {

	@ExceptionHandler(Exception.class)
	public ModelAndView genericErrorHandling(Exception e, HttpServletRequest request, HttpServletResponse response){
		CommonUi ui =  new CommonUi();
		ui.setCurrentUrl(request);
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		return new ModelAndView("static/500",ui);
	}
	
}
