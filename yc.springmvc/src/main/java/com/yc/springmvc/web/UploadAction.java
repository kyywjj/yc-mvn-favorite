package com.yc.springmvc.web;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadAction {
	@PostMapping(path = "upload",produces = "text/html;charset=UTF-8")
	public String upload(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		String diskpath="D:/Screen/apache-tomcat-8.5.54/webapps/photo/images";
		String filename=file.getOriginalFilename();
		file.transferTo(new File(diskpath+filename));
		System.out.println("success:" + "photo/" + filename);
		return "success:" + "photo/" + filename;
	}

}
