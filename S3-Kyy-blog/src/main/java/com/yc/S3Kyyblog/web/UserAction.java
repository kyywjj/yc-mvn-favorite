package com.yc.S3Kyyblog.web;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.S3Kyyblog.bean.Result;
import com.yc.S3Kyyblog.bean.User;
import com.yc.S3Kyyblog.biz.BizException;
import com.yc.S3Kyyblog.biz.UserBiz;
import com.yc.S3Kyyblog.util.Utils;


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
			m.addAttribute("errors", Utils.asMap(errors));
			m.addAttribute("user", user);
			return "reg";
		}
		try {
			uBiz.register(user);
		} catch (BizException e) {
			e.printStackTrace();
			errors.rejectValue("account", "account",e.getMessage());
			m.addAttribute("errors",Utils.asMap(errors));
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
	@RequestMapping("login.do")
	@ResponseBody
	public Result  login(User user, Errors errors,HttpSession session) {
		
		try {
			if (errors.hasFieldErrors("account")||errors.hasFieldErrors("pwd")) {
				Result res = new Result(0,"验证错误！", Utils.asMap(errors));
				return res;
			}
			User dbUser =  uBiz.login(user);
			session.setAttribute("loginedUser",dbUser);
			return new Result(1,"登录成功！",dbUser);
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(e.getMessage());
		}
	}
	

}
