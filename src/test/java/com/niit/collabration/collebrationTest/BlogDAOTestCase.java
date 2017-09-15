package com.niit.collabration.collebrationTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collabration.CollabrationBackend.dao.BlogDAO;
import com.niit.collabration.CollabrationBackend.model.Blog;

public class BlogDAOTestCase {


	private static BlogDAO blogDao;
	private Blog blog;
	
		@BeforeClass
		public static void initialize()
		{
			AnnotationConfigApplicationContext annotationConfigAppContext= new AnnotationConfigApplicationContext();
			annotationConfigAppContext.scan("com.niit.collaborate");
			annotationConfigAppContext.refresh();
			
	     blogDao=(BlogDAO)annotationConfigAppContext.getBean("blogDao");
			
		}
		@Test
		public void CreateBlogTest()
		{
			Blog blog = new Blog();
			
			blog.setBlogid(1001);
			blog.setBlogname("Selenium");
			blog.setBlogcontent("Selenium is testing Tolls");
			blog.setUserid("jit123@gmail.com");
			blog.setDate(new java.util.Date());
			blog.setStatus("NA");
			blog.setLikes(0);
			
			assertTrue("This will succeed.", blogDao.createBlog(blog));
		}
		

		@Ignore
		@Test
		public void editBlogTest(int blogId)
		{  
			
			Blog blog = new Blog();
			
			blog = blogDao.getBlogs(1001);
			blog.setBlogname("Selenium");
			blog.setBlogcontent("Selenium is testing Tolls");
			blog.setUserid("jit123@gmail.com");
			blog.setDate(new java.util.Date());
			blog.setStatus("NA");
			blog.setLikes(0);
			
						
		    assertEquals("This will succeed",true, blogDao.editBlog(blogId));
		}

		
		@Ignore
		@Test
		public void approveBlogTest()
		{
			Blog blog = new Blog();
			
			blog.setBlogid(1001);
			blog.setBlogname("Selenium");
			blog.setBlogcontent("Selenium is testing Tolls");
			blog.setUserid("jit123@gmail.com");
			blog.setDate(new java.util.Date());
			blog.setStatus("NA");
			blog.setLikes(0);
			
			assertEquals("Successful","A",((Blog) blogDao).getStatus());
		}
		
		@Ignore
		@Test
		public void getBlogTest(){
			blog = new Blog();
			blog = blogDao.getBlogs(10);
			assertEquals("Successful",10,blog.getBlogid());
		}
		
		@Ignore
		@Test
		public void getAllapproveBlogListTest()
		{
				
					List<Blog> listBlog= blogDao.getBlog();
					assertTrue("No Approved Blogs", listBlog.size()>0);
				}
		
        @Ignore
		@Test
		public void DeleteBlogTest()
		{
					
		    blog = new Blog();
		    blog = blogDao.getBlogs(10);
			
	     	assertEquals("Successful",10,blog.getBlogid());
	
				}   
        
        /*@Test
        	public void test() {
        		fail("Not yet implemented");
		
}
*/
}
