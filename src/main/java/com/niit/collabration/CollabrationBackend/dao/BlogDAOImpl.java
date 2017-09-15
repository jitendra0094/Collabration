package com.niit.collabration.CollabrationBackend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collabration.CollabrationBackend.model.Blog;

@Repository("BlogDAOImpl")
public class BlogDAOImpl implements BlogDAO {
	

	@Autowired
	SessionFactory sessionFactory;

	public BlogDAOImpl (SessionFactory sessionFactory)
	{
		this.sessionFactory= sessionFactory;
	}

	@Transactional
	public boolean createBlog(Blog blog) {
		
		  try
		    {
		  	 sessionFactory.getCurrentSession().save(blog);	
		  	 System.out.println("Insert the table");
		  	 return true;
		  	  }
		  	  catch(Exception e) 
		  	  {
		  		 System.out.println("Exception Arised:"+e); 
		  		  return false; 
		  	  }
		   		
	}
	@Transactional
	public Blog getBlogs(int blogId) {
		
	     sessionFactory.getCurrentSession().get(Blog.class, blogId);
		return null;
		
	}
	
	
	@Transactional
	public List<Blog> getBlog() {
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from blog where Status='A'");
		List<Blog> listBlog =query.list();
		session.close();
		return null;
	}
	
	
	@Transactional
	public boolean approveBlog(Blog blog) {
		try
		{
			blog.setStatus("A");
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
		}
		 catch(Exception e)
		{
			 System.out.println("Exception Arised:"+e);
		}
		
		return false;
	}
	
	
	@Transactional  
	public boolean editBlog(int blogId) {
		

		try {
			
			sessionFactory.getCurrentSession().update(getBlog());
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	
	@Transactional
	public boolean deleteBlog(int blogId) {
		try
		{
		   Session session = sessionFactory.openSession();
		   Blog blog = (Blog)session.get(Blog.class,blogId);
		   session.delete(blog);
		   session.flush();
		   session.close();
		   return true;
		}
		catch(Exception e){
			System.out.println("Exception Arised:"+e);
		}
		return false;
	}

}
