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

	// 실제 이미지가 저장될 컴퓨터 경로
	public final static String FILE_UPLOAD_PATH = "D:\\\\Spring Project\\\\MissionEveryday-project\\\\mission_everyday\\\\MissionEveryday\\\\src\\\\main\\\\resources\\\\static\\\\images"; //상수값(변경불가)은 대문자로 표시한다.

	// 이미지를 저장 -> 이미지의 URL path 리턴
	public String saveFile(int userId, MultipartFile file) throws IOException {
		
		// 파일을 컴퓨터에 저장
		// 1. 파일 디렉토리 경로 만듦(겹치지 않게)  예: marobiana_20210819173033/sun.png (아이디_업로드날짜시각/파일명.확장자)
		String directoryName = userId + "_" + System.currentTimeMillis() + "/";
		String filePath = FILE_UPLOAD_PATH + "/" + directoryName;
		
		File directory = new File(filePath);
		if (directory.mkdir() == false) { // mkdir(): 파일을 업로드할 filePath 경로에 폴더 생성을 한다.
			// 디렉토리 생성 실패
			logger.error("[파일업로드] 디렉토리 생성 실패" + userId + "," + filePath);
			return null;
		}; 
		
		// 파일 업로드 => byte 단위로 업로드
		byte[] bytes = file.getBytes(); // file -> byte 단위로 변환
		Path path = Paths.get(filePath + file.getOriginalFilename()); // 어디에 올릴지 path 지정
		// originalFileName = > input에서 올린 파일명
		Files.write(path, bytes); // path를 byte 단위로 변환

		
		// 이미지 URL을 만들어 리턴
		// 이미지 URL path를 리턴한다. (WebMvcConfig에서 매핑한 이미지 path)
		//   예) http://localhost/images/4_1630492273619.jpg
		return "/images/" + directoryName + file.getOriginalFilename();
	}
	
	
	// 파일 삭제하는 메소드
	public void deleteFile(String imgPath) throws IOException {
		
	
		Path path = Paths.get(FILE_UPLOAD_PATH + imgPath.replace("/images/", ""));
		if(Files.exists(path)){ // 존재하는지 여부를 boolean으로 알려줌
			Files.delete(path);
		}
		
		// 디렉토리 삭제
		path = path.getParent();
		if(Files.exists(path)) {
			Files.delete(path);
			
		}
	}
}