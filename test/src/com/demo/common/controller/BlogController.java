package com.demo.common.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;

/**
 * BlogController
 * 所有 sql 与业务逻辑写在 Model 或 Service 中，不要写在 Controller 中，养成好习惯，有利于大型项目的开发与维护
 */
@Before(BlogInterceptor.class)
public class BlogController extends Controller {
	public void index() {
		//List<Blog> list = Blog.me.find("SELECT * FROM student");
		//分页
		setAttr("studentList", Blog.me.paginate(getParaToInt(0, 1), 5));
		//System.out.println(getParaToInt(0));
        //setAttr("studentList", list);
		render("blog.html");
	}
	
	public void add() {
		render("add.html");
	}
	
	public void sa(){
		
	}

	@Before(BlogValidator.class)
	public void save() {		
		UploadFile file=getFile(getPara("img"));		
		getModel(Blog.class).save();
		redirect("/blog");
	}
	
	public void edit() {
		setAttr("blog",Blog.me.findById(getParaToInt()));		
	}
	
	@Before(BlogValidator.class)
	public void update() {
		getModel(Blog.class).update();
		redirect("/blog");//类似于重定向
	}
	
	public void delete() {
		Blog.me.deleteById(getParaToInt());
		redirect("/blog");
	}
}


