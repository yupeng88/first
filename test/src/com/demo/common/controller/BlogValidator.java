package com.demo.common.controller;


import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * BlogValidator.
 */
public class BlogValidator extends Validator {
	
	protected void validate(Controller controller) {
		System.out.println(">>>>>>>>>开始验证了");
		controller.getFile();
		validateRequiredString("blog.name", "nameMsg", "请输入姓名!");
		validateRequiredString("blog.native", "nativeMsg", "请输入民族!");
		validateRequiredString("blog.birth", "birthMsg", "请输入出生日期!");
		validateRequiredString("blog.address", "addressMsg", "请输入地址!");
		validateRequiredString("blog.school", "schoolMsg", "请输入学校!");
		validateRequiredString("blog.leave", "leaveMsg", "请输入毕业时间!");
		
	}
	

	protected void handleError(Controller controller) {
		System.out.println("《《《《《《《《验证不通过》》》》》》》");
		controller.keepModel(Blog.class);		
		String actionKey = getActionKey();
		if (actionKey.equals("/blog/save")){		
			controller.render("add.html");
		}else if (actionKey.equals("/blog/update"))
			controller.render("edit.html");
		
		System.out.println(actionKey);
	}
}
