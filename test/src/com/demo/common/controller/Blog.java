package com.demo.common.controller;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

@SuppressWarnings("serial")
public class Blog extends Model<Blog> {
	public static final Blog me = new Blog();

	public Page<Blog> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *",
				"from student order by id asc");
	}
}
