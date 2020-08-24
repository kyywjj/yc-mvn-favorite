package com.yc.S3Kyyblog.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yc.S3Kyyblog.bean.Result;
import com.yc.S3Kyyblog.bean.User;
import com.yc.S3Kyyblog.biz.BizException;
import com.yc.S3Kyyblog.biz.UserBiz;

@Controller
public class UserAction {
	
	@Resource
	private UserBiz uBiz;
	/*
	 * 注册：表单提交==》页面跳转
	 * Errors
	 */
	@PostMapping("reg.do")
	public String register(@Valid User user,Errors errors,Model m) {
		if (errors.hasErrors()) {
			m.addAttribute("errors", asMap(errors));
			return "reg";
		}
		try {
			uBiz.register(user);
		} catch (BizException e) {
			e.printStackTrace();
			errors.rejectValue("account", "account",e.getMessage());
			m.addAttribute("errors",asMap(errors));
			return "reg";
		}
		return "index";
	}
	
	@GetMapping("toreg")
	public String toreg() {
		return "reg";
	}
	
	/**
	 * 登录Ajax提交==》Vue
	 */
	public Result  login(User user, HttpSession session) {
		try {
			User dbUser =  uBiz.login(user);
			session.setAttribute("loginedUser",dbUser);
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(e.getMessage());
		}
		return new Result(1, "登录成功");
	}
	
	/**
	 * 将所有的字段验证写入到一个map
	 */
	private Map<String, String> asMap(Errors errors){
		if (errors.hasErrors()) {
			Map<String, String>ret =new HashMap<String,String>();
			for(FieldError fe: errors.getFieldErrors()) {
				ret.put(fe.getField(),fe.getDefaultMessage());
			}
			return ret;
		}else {
			return null;
		}
	}

}
