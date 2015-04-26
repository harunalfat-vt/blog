package blog.service.impl;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.stereotype.Service;

import blog.data.model.User;
import blog.mongo.initiator.MongoOperationsInitiator;
import blog.service.CredentialService;

@Service
public class CredentialServiceImpl implements CredentialService{

	private MongoOperations mongoOperations = MongoOperationsInitiator.initMongoOperations();
	
	@Override
	public Boolean validateLogin(String username, String password) {
		BasicQuery query = new BasicQuery("{username : '"+username+"', password : '"+password+"'}");
		User user = mongoOperations.findOne(query, User.class);
		return (user != null);
	}

}
