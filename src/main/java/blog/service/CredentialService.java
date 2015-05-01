package blog.service;

import java.security.NoSuchAlgorithmException;


public interface CredentialService {
	
	public Boolean validateLogin(String username, String password);
	
}
