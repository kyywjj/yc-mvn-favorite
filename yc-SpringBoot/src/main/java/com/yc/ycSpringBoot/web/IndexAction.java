package com.yc.ycSpringBoot.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yc.damai.bean.DmProduct;
import com.yc.ycSpringBoot.dao.ProductMapper;

@Controller
//默认情况下，所有的方法的返回值都是被解析成视图
//template下的视图
public class IndexAction {
	@Resource
	ProductMapper pm ;
	@GetMapping("index.do")
	public String  index(Model m) {
		//查询热销商品
		List<DmProduct>list=pm.selectHot();
		List<DmProduct>list1=pm.selectNew();
		//推送给页面
		m.addAttribute("list",list);
		m.addAttribute("list1",list1);
		return "index";
		//springmvc==>会将返回的视图名 前+template + 视图名 +后缀
	}
	
	@GetMapping("detail.do")
	public String  detail(Model m, int id) {
		//查询
		DmProduct dp=pm.selectById(id);
		//推送给页面
		m.addAttribute("dp",dp);
		return "detail";
		//springmvc==>会将返回的视图名 前+template + 视图名 +后缀
	}

}
