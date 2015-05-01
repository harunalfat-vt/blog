package blog.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import blog.data.enumeration.EnumCollectionType;
import blog.data.model.User;
import blog.mongo.initiator.MongoOperationsInitiator;
import blog.service.CredentialService;

public class CredentialServiceImpl implements CredentialService{

	private MongoOperations mongoOperations = MongoOperationsInitiator.initMongoOperations();
	
	@Override
	public Boolean validateLogin(String username, String password) {
		Query query = new Query();
		User user = new User();
		try {
			query = new Query(Criteria.where("username").is(username).and("password").is(getHashedPassword(password)));
			user = mongoOperations.findOne(query, User.class, EnumCollectionType.user.toString());
		} catch (NoSuchAlgorithmException e) {
			user = null;
			e.printStackTrace();
		}		
		return (user != null);
	}

	private String getHashedPassword(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(password.getBytes());
		byte byteData[] = md.digest();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < byteData.length; i++){
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}

}
