package blog.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import blog.data.enumeration.EnumCollectionType;
import blog.data.model.Post;
import blog.mongo.initiator.MongoOperationsInitiator;
import blog.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService{

	private MongoOperations mongoOperations = MongoOperationsInitiator.initMongoOperations();
	
	@Override
	public void insertPost(Post post) {
		post.setId(post.getTitle());
		SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");
		post.setDate(formatter.format(new Date()));
		mongoOperations.insert(post, EnumCollectionType.post.toString());
	}

	@Override
	public Post getPost(String id) {
		Query query = new Query(Criteria.where("id").is(id));
		Post post = mongoOperations.findOne(query, Post.class, EnumCollectionType.post.toString());
		return post;
	}

}
