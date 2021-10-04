package com.mission_everyday.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManagerService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	public final static String FILE_UPLOAD_PATH = "/home/ec2-user/upload_images";
	
	public String saveFile(int userId, MultipartFile file) throws IOException {
		
	
		String directoryName = userId + "_" + System.currentTimeMillis() + "/";
		String filePath = FILE_UPLOAD_PATH + "/" + directoryName;
		
		File directory = new File(filePath);
		if (directory.mkdir() == false) { 
			logger.error("[���Ͼ��ε�] ���丮 ���� ����" + userId + "," + filePath);
			return null;
		}; 
		
		byte[] bytes = file.getBytes(); // file -> byte
		Path path = Paths.get(filePath + file.getOriginalFilename()); 
		// originalFileName = > input
		Files.write(path, bytes); 

		
		return "/images/" + directoryName + file.getOriginalFilename();
	}
	

	public void deleteFile(String imgPath) throws IOException {
		
	
		Path path = Paths.get(FILE_UPLOAD_PATH + imgPath.replace("/images/", ""));
		if(Files.exists(path)){ 
			Files.delete(path);
		}
		
		path = path.getParent();
		if(Files.exists(path)) {
			Files.delete(path);
			
		}
	}
}
