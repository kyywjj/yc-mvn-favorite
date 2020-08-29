package com.yc.S3Kyyblog.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.S3Kyyblog.bean.Comment;
import com.yc.S3Kyyblog.dao.CommentMapper;
@Service
public class CommentBiz {
	
	@Resource
	private CommentMapper cMapper;
	public Comment creat(Comment comm) {
		cMapper.insert(comm);
		return comm;
	}

}
