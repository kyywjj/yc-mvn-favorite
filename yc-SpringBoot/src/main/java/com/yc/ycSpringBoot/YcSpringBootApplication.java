package com.yc.ycSpringBoot;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@SpringBootApplication
@MapperScan("com.yc.ycSpringBoot.dao")
//开启定时任务
@EnableScheduling
public class YcSpringBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(YcSpringBootApplication.class, args);
	}

	@Bean //约定大于配置
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}
}
