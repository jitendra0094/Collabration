package com.niit.collabration.CollabrationBackend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "Blog")
public class Blog {

	@Id
	private int blogid;
	
	private String blogname, blogcontent,status;
	
	private int userid,likes;
	
	private Date createdate;

	public int getBlogid() {
		return blogid;
	}

	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}

	public String getBlogname() {
		return blogname;
	}

	public void setBlogname(String blogname) {
		this.blogname = blogname;
	}

	public String getBlogcontent() {
		return blogcontent;
	}

	public void setBlogcontent(String blogcontent) {
		this.blogcontent = blogcontent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public Date getDate() {
		return createdate;
	}

	public void setDate(Date date) {
		this.createdate = date;
	}

	public void setUserid(String string) {

		
	}
	
}
