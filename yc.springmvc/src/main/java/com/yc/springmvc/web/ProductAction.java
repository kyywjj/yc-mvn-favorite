package com.yc.springmvc.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.yc.damai.po.DmCart;
import com.yc.damai.po.DmUser;

@RestController
public class ProductAction {
	/*
	 * path == value 互为同义词
	 * method  定义响应的请求的类型 ,例如：GET POST DELETE... 
	 * params  定义对参数的限定 
	 * 		       例如：a=100(限定请求里面必须有a=100的参数)
	 * headers 限定请求头域= null, consumes = null, produces = null
	 * 
	 */
	@RequestMapping(path="product.do",params = "op=query")
	public String query() {
		return "query!!";
	}
	@RequestMapping(path="product.do",params = "op=add")
	public String add() {
		return "add!!";
	}
	@RequestMapping(path="product.do",params = "op=mod" , method = RequestMethod.POST)
	public String mod() {
		return "mod!!";
	}
	@GetMapping(path="product.do",params = "op=select")
	public String select() {
		return "select!!";
	}
	
	@GetMapping(path="product.do",params = "op=mgr", headers = {"Host=localhost","Cookie"})
	public String mgr() {
		return "mgr!!";
	}
	@GetMapping("login.do")
	public String login(String user, String pwd) {
		return user + ":" +pwd;
	}
	@GetMapping("reg.do")
	public String login(DmUser user, DmCart dc) {
		return user.toString() +"<br>"+dc;
	}
	
	@GetMapping("pay.do")
	public String pay(
			@RequestParam(
					name = "userid",
					required=true)
			String uid, Double money) {
		return uid+":"+money;
	}
	
	@GetMapping("findUser.do")
	public DmUser findUser() {
		DmUser du = new DmUser();
		du.setId(100);
		du.setCname("lii");
		du.setPassword("123");
		return du;
	}
		
	
}
