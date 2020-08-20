package com.yc.ycSpringBoot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloAction {
	@GetMapping("hello")
	public String Hello() {
		return "hello world!";
	}
}
