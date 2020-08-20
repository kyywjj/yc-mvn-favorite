package com.yc.springmvc.web;


import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.damai.po.DmUser;
import com.yc.damai.po.Result1;

@RestController
@RequestMapping("demo")
public class ValidAction {
	@RequestMapping("reg.do")
	public Result1 reg(@Valid DmUser du,Errors errors) {
		/*
		 *  errors.hasErrors() 判断是否有错误
		 *  errors.hashFieldErrors() 判断是否有字段错误
		 *  
		 *  错误分成： 对象级错误， 字段级错误， 全局错误
		 */
		if (errors.hasErrors()) {
			return new Result1(0, "验证错误！", errors.getAllErrors());
		}else {
			return new Result1(1, "注册成功！");
		}
		
		
		/**
		 * 在被效验的对象前加@Valid注解
		 */
	
	}
}
