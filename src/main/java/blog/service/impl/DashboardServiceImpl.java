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

import blog.data.enumeration.EnumCollectionType;
import blog.data.model.Post;
import blog.mongo.initiator.MongoOperationsInitiator;
import blog.service.DashboardService;

public class DashboardServiceImpl implements DashboardService{

	private MongoOperations mongoOperations = MongoOperationsInitiator.initMongoOperations();
	
	@Override
	public Post getPost(String id) {
		Query query = new Query(Criteria.where("id").is(id.toLowerCase()));	
		Post post = mongoOperations.findOne(query, Post.class, EnumCollectionType.post.toString());
		SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");
		if (post != null){
			if (post.getDtupdated() == null){
				post.setDateStr(formatter.format(post.getDtcreated()));
				post.setStatus("new");
			} else{
				post.setDateStr(formatter.format(post.getDtupdated()));
				post.setStatus("edited");
			}
		}		
		return post;
	}
	
	@Override
	public void insertPost(Post post) {
		post.setId(post.getTitle().toLowerCase());
		post.setDtcreated(new Date());
		mongoOperations.insert(post, EnumCollectionType.post.toString());
	}	
	
	@Override
	public void updatePost(Post post) {
		post.setId(post.getTitle().toLowerCase());
		post.setDtupdated(new Date());
		Query query = new Query(Criteria.where("id").is(post.getId()));
		Update update = new Update();
		update.set("subTitle", post.getSubTitle());
		update.set("content", post.getContent());
		update.set("dtupdated", post.getDtupdated());
		update.set("user", post.getUser());
		mongoOperations.updateFirst(query, update, EnumCollectionType.post.toString());
	}	
	
	@Override
	public Post getAboutContent() {
		Post about = mongoOperations.findOne(new Query(), Post.class, EnumCollectionType.about.toString());
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
		update.set("dtupdated", new Date());
		update.set("user",post.getUser());
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
		if (!postList.isEmpty())
			for (Post post : postList) {
				SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");
				if (post.getDtupdated() == null){			
					post.setDateStr(formatter.format(post.getDtcreated()));
				}	else{
					post.setDateStr(formatter.format(post.getDtupdated()));
				}
			}
		return postList;
	}

}
