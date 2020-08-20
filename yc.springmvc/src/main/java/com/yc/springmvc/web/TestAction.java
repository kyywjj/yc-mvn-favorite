package com.yc.springmvc.web;


import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.yc.damai.po.DmUser;

@RestController
@RequestMapping("user")


// @SessionAttributes(names = "loginedUser",types = Date.class)
public class TestAction {
	@RequestMapping("?/add")
	//user/a/add user/b/add
	public String add() {
		return "add";
	}
	
	@RequestMapping("*/del")
	//user/a/del   user/abc/del
	public String del() {
		return "del";
	}
	
	@RequestMapping("**/mod")
	// user/a/mod user/a/b/mod  user/a/b/c/mod
	public String mod() {
		return "mod";
	}
	
	@RequestMapping("**/head")
	public String head(@RequestHeader() String accept,
			@RequestHeader(value = "Connection", required = true) String conn) {
		return accept+"<br>"+conn;
	}
	/**
	 * document.cookie="user=zhangsan" 浏览器添加cookie
	 * @param user
	 * @param age
	 * @return
	 */
	@RequestMapping("**/cookie")
	public String cookie(@CookieValue String user, @CookieValue int age,
			@RequestHeader String cookie) {
		return user +"<br>"+age+"<br>"+cookie;
		
	}
	/**
	 * 请求对象，响应，会话
	 */
	@RequestMapping("**/servlet")
	public String servlet(HttpServletRequest request,
			HttpServletResponse reponse,
			HttpSession session,
			InputStream in,
			OutputStream out) {
		return "" +request +"<br>" + session +
				"<br>" + in +"<br>" + out;
	}
	
	
	
	@RequestMapping("{user}/{pwd}/login")
	public String login(
			@PathVariable("user")
			String user,
			@PathVariable("pwd")
			String pwd) {
		
		return user + "<br>"+ pwd;
	}
	
	/**
	 * 会话对象的注入
	 * SpringMVC 数据模型（Map） Model 请求过程中用于临时保存数据的对象
	 * @SessionAttributes 指定对象设置到会话中 ， 加在类上
	 * @RestController 与 @SessionAttributes 有冲突
	 * 要在@RestController 标注的类中给会话添加属性，要通过注入会话对象的方法
	 * @SessionAttribute 从会话中获取一个指定的对象
	 * 
	 * @param user
	 * @param pwd
	 * @param model
	 * @return
	 */
	@RequestMapping("{user}/{pwd}/login.do")
	public String logindo(
			@PathVariable("user")
			String user,
			@PathVariable("pwd")
			String pwd,
			Model model,//该方法中没有用到Model
			HttpSession session) {
		DmUser du = new DmUser();
		du.setEname(user);
		du.setPassword(pwd);
		
		session.setAttribute("loginedUser", du);
		session.setAttribute("now", new Date());
		//model.addAttribute("age", 100);
		return du.toString();
	}
	
	@RequestMapping("testLogin")
	public String testLogin(
			@SessionAttribute("loginedUser")DmUser du,
			@SessionAttribute("now") Date date,
			@SessionAttribute(value = "age",required = false) Integer age) {
		return du + "<br>" +date + "<br>" + age;
		
	}
}
