package blog.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import blog.data.enumeration.EnumCollectionType;
import blog.data.model.Post;
import blog.mongo.initiator.MongoOperationsInitiator;
import blog.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService{

	private MongoOperations mongoOperations = MongoOperationsInitiator.initMongoOperations();
	
	@Override
	public Post getPost(String id) {
		Query query = new Query(Criteria.where("id").is(id));	
		Post post = mongoOperations.findOne(query, Post.class, EnumCollectionType.post.toString());
		if (post.getDtcreated() != null){
			SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");
			post.setDateStr(formatter.format(post.getDtcreated()));
		}
		return post;
	}
	
	@Override
	public void insertPost(Post post) {
		post.setId(post.getTitle());
		//SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");
		post.setDtcreated(new Date());
		mongoOperations.insert(post, EnumCollectionType.post.toString());
	}	
	
	@Override
	public Post getAboutContent() {
		Query query = new Query();	
		Post about = mongoOperations.findOne(query, Post.class, EnumCollectionType.about.toString());
		return about;
	}
	
	@Override
	public void updateAbout(Post post) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is("about"));
		Update update = new Update();
		update.set("title", post.getTitle());
		update.set("subTitle", post.getSubTitle());
		update.set("content", post.getContent());
		update.set("dtcreated", new Date());
		update.set("user",post.getUser());
		update.set("id", "about");
		mongoOperations.upsert(query, update, EnumCollectionType.about.toString());
		
	}

	@Override
	public List<Post> getPostList(int page, int size) {
		Query query = new Query();
		query.fields().exclude("content");
		Pageable pageRequest = new PageRequest(page-1, size);
		query.with(pageRequest);
		query.with(new Sort(Sort.Direction.DESC,"dtcreated"));
		List<Post> postList = mongoOperations.find(query, Post.class);
		for (Post post : postList) {
			if (post.getDtcreated() != null){
				SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");
				post.setDateStr(formatter.format(post.getDtcreated()));
			}				
		}
		return mongoOperations.find(query, Post.class);
	}

}
