package blog.service;

import blog.data.model.Post;

public interface DashboardService {

	public void insertPost(Post post);
	
	public Post getPost(String id);
	
}
