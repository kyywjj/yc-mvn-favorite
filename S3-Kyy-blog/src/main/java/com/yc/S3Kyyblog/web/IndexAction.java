package com.yc.S3Kyyblog.web;



import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.yc.S3Kyyblog.dao.ArticleMapper;
import com.yc.S3Kyyblog.dao.CategoryMapper;

@Controller
//默认情况下，所有的方法的返回值都是被解析成视图
//template下的视图
public class IndexAction {
	
	@Resource
	private ArticleMapper amapper;
	@Resource
	private CategoryMapper cmapper;
	@GetMapping("/")
	public String  index(Model m,Model m1,Model m2,@RequestParam(defaultValue = "1") int page) {
		//在执行查询前，设置分页参数
		//注意： 必须是在查询方法执行前， 调用分页参数设置
		PageHelper.startPage(page, 5);
		m.addAttribute("alist",amapper.selectByNew());
		m1.addAttribute("list",cmapper.selectAll());
		m2.addAttribute("hot", amapper.selectByReadCnt());
		return "index";
		//springmvc==>会将返回的视图名 前+template + 视图名 +后缀
	}
	@GetMapping("article")
	public String article(int id, Model m ) {
		m.addAttribute("article",amapper.selectById(id));
		
		return "article";
	}
	
	
//	@GetMapping("category")
//	public  String category(Model m) {
//		m.addAttribute("list",cmapper.selectAll());
//		return "category";
//	}
	
	

}
