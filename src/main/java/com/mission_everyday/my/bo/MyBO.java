package com.mission_everyday.my.bo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mission_everyday.comment.BO.CommentBO;
import com.mission_everyday.content.Model.Content;
import com.mission_everyday.my.dao.MyDAO;
import com.mission_everyday.my.model.MyMission;
import com.mission_everyday.my.model.MyStatus;
import com.mission_everyday.post.BO.LikeBO;
import com.mission_everyday.post.BO.PostBO;
import com.mission_everyday.post.Model.Post;

@Service
public class MyBO {

	@Autowired
	private MyDAO myDAO;

	@Autowired
	private PostBO postBO;

	@Autowired
	private CommentBO commentBO;

	@Autowired
	private LikeBO likeBO;

	@Autowired
	private MyBO myBO;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 가입한 미션 목록 가져오기
	public List<MyMission> getMyMissionListByUserId(int userId) {
		return myDAO.selectMyMissionListByUserId(userId);
	}

	public MyMission getMyMissionByUserIdAndMissionId(int userId, int missionId) {
		return myDAO.selectMyMissionByUserIdAndMissionId(userId, missionId);
	}

	// 내가 쓴 글 조회하기
	public List<Content> getContentListByUserId(int userId) {

		List<Content> myContentList = new ArrayList<>();
		List<Post> myPostList = postBO.getPostListByUserId(userId);

		for (Post post : myPostList) {

			Content content = new Content();

			// 1. content에 현재 포스트 넣기
			content.setPost(post);

			// 2. content에 현재 commentList 넣기
			content.setCommentList(commentBO.getCommentList(post.getId()));

			// 3. content에 현재 좋아요 상태 넣기
			content.setFilledLike(likeBO.existedLike(userId, post.getId()));

			// 4. content에 현재 좋아요 개수 넣기
			content.setLikeCount(likeBO.getLikeCountByPostId(post.getId()));

			myContentList.add(content);
		}

		return myContentList;
	}

	// 내 미션 수행 상태 소환
	public List<MyStatus> getMyMissionStatus(int userId, int missionId) throws ParseException {

		// 내 미션 수행 상태 리스트
		List<MyStatus> myStatusList = new ArrayList<>();

		// 내가 가입한 미션의 스케줄 소환
		MyMission myMission = myBO.getMyMissionByUserIdAndMissionId(userId, missionId);

		Date missionStartDate = myMission.getMissionStartDate();// 시작일
		Date missionFinishDate = myMission.getMissionFinishDate();// 종료일
		int missionPeriod = myMission.getMissionPeriod();// 일수

		// 미션체크용 캘린더 생성
		Calendar missionStartCal = new GregorianCalendar();
		Calendar missionFinishCal = new GregorianCalendar();

		// Date->Calendar 변환
		missionStartCal.setTime(missionStartDate);
		missionFinishCal.setTime(missionFinishDate);

		// 오늘 날짜
		Calendar today = Calendar.getInstance();

		// format 통일하기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today_sdf = sdf.format(today.getTime()); // Calendar -> String
		Date todayDate = sdf.parse(today_sdf); // String -> Date
		today.setTime(todayDate); // Date -> Calendar

		List<Post> myPostList = postBO.getPostListByUserIdAndMissionId(userId, missionId);

		
		// 미션일수만큼 반복문 돌려서 myStatusList 채우기
		for (int i = 1; i <= missionPeriod; i++) {

			MyStatus myStatus = new MyStatus();
			
			// myStatus에 현재 상태 넣기
			for (Post myPost : myPostList) {
				
				// 포스트날짜
				Date postDate = myPost.getCreatedAt();
				
				// format 통일하기
				String postDate_sdf = sdf.format(postDate); // Date -> String
				postDate = sdf.parse(postDate_sdf); // String -> Date
				
				// O, X, blank 넣기				
				if (missionStartDate.compareTo(postDate) == 0) { // post업로드일이 업로드해야되는 일자와 일치하는 경우
						myStatus.setStatus("O"); // O 표시	
				} else if (missionStartDate.compareTo(todayDate) == -1) { // 업로드해야되는 일자가 오늘보다 과거일 때
						myStatus.setStatus("X"); // X 표시
				} else if (missionStartDate.compareTo(todayDate) == 1) { // 업로드해야되는 일자가 오늘보다 미래일 때
						myStatus.setStatus("blank"); // 빈칸 표시
				}

				
				myStatusList.add(myStatus);
			
				missionStartCal.setTime(missionStartDate); // Date->Calendar 변환
				missionStartCal.add(missionStartCal.DATE, 1); // missionStart일자가 1일씩 늘어남	
				missionStartDate = missionStartCal.getTime();// Calendar->Date 변환
			}
		}		
		return myStatusList; // 미션 수행상태 리스트 반환
	}
	
	// 미션 성공횟수 구하기
	public int getSuccessCountByUserIdAndMissionId(int userId, int missionId) throws ParseException {
		
		List<MyStatus> myStatusList = myBO.getMyMissionStatus(userId, missionId);
		int successCount = 0;
		
		for(MyStatus myStatus : myStatusList) {
			if(myStatus.getStatus() == "O") {
				successCount++;
			}
		}		
		return successCount;
	}
	
	// 미션 실패횟수 구하기
	public int getFailCount(int userId, int missionId) throws ParseException {
		
		List<MyStatus> myStatusList = myBO.getMyMissionStatus(userId, missionId);
		int failCount = 0;
		
		for(MyStatus myStatus : myStatusList) {
			if(myStatus.getStatus() == "X") {
				failCount++;
			}
		}		
		return failCount;
	}
	
	// 미션 빈칸 개수 구하기
	public int getBlankCount(int userId, int missionId) throws ParseException {
		
		List<MyStatus> myStatusList = myBO.getMyMissionStatus(userId, missionId);
		int blankCount = 0;
		
		for(MyStatus myStatus : myStatusList) {
			if(myStatus.getStatus() == "blank") {
				blankCount++;
			}
		}		
		return blankCount;
	}
}
