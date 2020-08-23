package com.yc.ycblog.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


//默认情况下，所有的方法的返回值都是被解析成视图
//template下的视图
@Controller
public class IndexAction {
	@GetMapping("/index.do")
	public String  index() {
		return "index";
		//springmvc==>会将返回的视图名 前+template + 视图名 +后缀
	}
	
	

}
