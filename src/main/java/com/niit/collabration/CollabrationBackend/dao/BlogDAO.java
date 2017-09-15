package com.niit.collabration.CollabrationBackend.dao;

import java.util.List;

import com.niit.collabration.CollabrationBackend.model.Blog;

public interface BlogDAO {
	
	public boolean createBlog(Blog blog);
	public Blog getBlogs(int blogId);
	public List<Blog> getBlog();
	public boolean approveBlog(Blog blog);
	public boolean editBlog(int blogId);
	public boolean deleteBlog(int blogId);

}
