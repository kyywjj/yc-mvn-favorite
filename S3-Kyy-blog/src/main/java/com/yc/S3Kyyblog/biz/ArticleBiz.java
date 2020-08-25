package com.yc.S3Kyyblog.biz;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.S3Kyyblog.bean.Article;
import com.yc.S3Kyyblog.dao.ArticleMapper;

@Service
public class ArticleBiz {
	@Resource
	private ArticleMapper aMapper;
	public int create(Article art) {
		return aMapper.insert(art);
	}
	
	
}
