package blog.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import blog.data.enumeration.EnumSessionVariables;

public class SessionUtil {

	public static Boolean isLogged(HttpSession session, HttpServletResponse response) throws IOException, HttpClientErrorException{
		if(session.getAttribute(EnumSessionVariables.user.toString()) == null){
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "not logged");
		}
		return true;
	}
	
}
