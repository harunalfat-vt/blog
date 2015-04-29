package blog.service;

import java.util.List;

import blog.data.model.Post;

public interface DashboardService {

	public Post getPost(String id);
	
	public void insertPost(Post post);
	
	public Post getAboutContent();
	
	public void updateAbout(Post post);
	
	public List<Post> getPostList(int page, int limit);
	
}
