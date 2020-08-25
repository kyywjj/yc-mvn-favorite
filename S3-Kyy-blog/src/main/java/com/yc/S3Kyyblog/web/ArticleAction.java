package com.yc.S3Kyyblog.web;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.yc.S3Kyyblog.bean.Article;

import com.yc.S3Kyyblog.util.Utils;
import com.yc.S3Kyyblog.biz.*;
@RestController
public class ArticleAction {
	
	@Resource
	private ArticleBiz abiz;
	@GetMapping("toAddArticle")
	public String toAddArticle(ModelAndView mav) {
		mav.setViewName("addArticle");
		return "mav";
	}
	
	@PostMapping("AddArticle.do")
	public ModelAndView addArticle(@Valid Article a,Errors errors,ModelAndView mav) {
		if (errors.hasFieldErrors()) {
			mav.addObject("errors", Utils.asMap(errors));
			mav.addObject("article",a);
			mav.setViewName("addArticle");
		}else {
			mav.setViewName("article");//未完待续，展示新添加的文章
		}
		return mav;
		
	}

}
