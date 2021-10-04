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

	// ���� �̹����� ����� ��ǻ�� ���
	// public final static String FILE_UPLOAD_PATH = "D:\\\\Spring Project\\\\MissionEveryday-project\\\\mission_everyday\\\\MissionEveryday\\\\src\\\\main\\\\resources\\\\static\\\\images"; //�����(����Ұ�)�� �빮�ڷ� ǥ���Ѵ�.
	public final static String FILE_UPLOAD_PATH = "/home/ec2-user/upload_images/";
	
	// �̹����� ���� -> �̹����� URL path ����
	public String saveFile(int userId, MultipartFile file) throws IOException {
		
		// ������ ��ǻ�Ϳ� ����
		// 1. ���� ���丮 ��� ����(��ġ�� �ʰ�)  ��: marobiana_20210819173033/sun.png (���̵�_���ε峯¥�ð�/���ϸ�.Ȯ����)
		String directoryName = userId + "_" + System.currentTimeMillis() + "/";
		String filePath = FILE_UPLOAD_PATH + "/" + directoryName;
		
		File directory = new File(filePath);
		if (directory.mkdir() == false) { // mkdir(): ������ ���ε��� filePath ��ο� ���� ������ �Ѵ�.
			// ���丮 ���� ����
			logger.error("[���Ͼ��ε�] ���丮 ���� ����" + userId + "," + filePath);
			return null;
		}; 
		
		// ���� ���ε� => byte ������ ���ε�
		byte[] bytes = file.getBytes(); // file -> byte ������ ��ȯ
		Path path = Paths.get(filePath + file.getOriginalFilename()); // ��� �ø��� path ����
		// originalFileName = > input���� �ø� ���ϸ�
		Files.write(path, bytes); // path�� byte ������ ��ȯ

		
		// �̹��� URL�� ����� ����
		// �̹��� URL path�� �����Ѵ�. (WebMvcConfig���� ������ �̹��� path)
		//   ��) http://localhost/images/4_1630492273619.jpg
		return "/images/" + directoryName + file.getOriginalFilename();
	}
	
	
	// ���� �����ϴ� �޼ҵ�
	public void deleteFile(String imgPath) throws IOException {
		
	
		Path path = Paths.get(FILE_UPLOAD_PATH + imgPath.replace("/images/", ""));
		if(Files.exists(path)){ // �����ϴ��� ���θ� boolean���� �˷���
			Files.delete(path);
		}
		
		// ���丮 ����
		path = path.getParent();
		if(Files.exists(path)) {
			Files.delete(path);
			
		}
	}
}
