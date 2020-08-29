package com.yc.S3Kyyblog.dao;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.yc.S3Kyyblog.bean.Comment;
import com.yc.S3Kyyblog.bean.Result;
import com.yc.S3Kyyblog.bean.User;
import com.yc.S3Kyyblog.biz.CommentBiz;

@RestController
public class CommentAction {
	@Resource
	private CommentMapper cMapper;
	@Resource 
	private CommentBiz cBiz;
	
	@PostMapping("comment")
	public Result comment(Comment comm, @SessionAttribute User loginedUser) {
		comm.setCreateby(loginedUser.getId());
		cBiz.creat(comm);
		return new Result(1,"回复成功",comm);
	}
}
