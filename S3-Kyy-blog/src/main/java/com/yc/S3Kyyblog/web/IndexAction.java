package com.yc.S3Kyyblog.web;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yc.S3Kyyblog.dao.ArticleMapper;

@Controller
//默认情况下，所有的方法的返回值都是被解析成视图
//template下的视图
public class IndexAction {
	
	@Resource
	private ArticleMapper amapper;
	@GetMapping("/")
	public String  index(Model m) {
		m.addAttribute("alist",amapper.selectByNew());
		return "index";
		//springmvc==>会将返回的视图名 前+template + 视图名 +后缀
	}
	
	

}
