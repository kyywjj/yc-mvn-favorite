package com.yc.S3Kyyblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.yc.S3Kyyblog.dao")
public class S3KyyBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(S3KyyBlogApplication.class, args);
	}

}
