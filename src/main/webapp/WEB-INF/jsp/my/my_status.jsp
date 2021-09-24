<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<div class="myPage d-flex flex-wrap mt-5">
	
	<div id="myPageBar">
		<nav class="side-menu">
		 <h4 class="mb-2" style="color: #727273"><b>MY PAGE</b></h4>
		 <hr>
		 <ul class="nav flex-column">
		 	<li class="nav-item mt-2"><a href="/my/mission" class="menu-text">My 참여 중인 미션</a></li>
		 	<li class="nav-item mt-4"><a href="/my/post" class="menu-text">My 인증 포스트</a></li>
		 	<li class="nav-item mt-4"><a href="/my/status" class="menu-text">My 인증 성공 현황</a></li>
		 </ul>
		</nav>
	</div>


	<!-- 페이지 뷰 -->
	<div id="myPageView" class="container">
		
		<!-- 헤더 -->
		<div class="my-header">
			<h2 class="ml-2" style="color:#524e4e"><b>My 인증 포스트</b></h2>
			<hr>
		</div>
		
		<!-- My 인증 현황 -->
		<div class="contents d-flex justify-content-center">
			<div>
			
				<!-- My mission별로 정리 -->
				<c:forEach var="myMission" items="${myMissionList}">
				 <div class="statusBox d-flex mt-4">
				
					<!-- 미션 이미지&이름 -->
					<div class="missionInfo">
						<img src="${myMission.missionImage}" width="160px">
						<div class="mt-1 text-center" style="font-size:14px">
						${myMission.missionName}
						</div>
					</div>
					
					
					<!-- 인증현황 정리 -->
					<div class="statusInfo ml-4 mt-3">
					
						<!-- 인증현황 text -->
						<div class="info-text" style="font-size:12px">
						인증 성공: i개 / 인증 실패: i개 / 남은 인증: i개
						</div>					
													
						<!-- 인증 체크박스 -->
						<div class="statusCheckBox mt-3">
						<!-- myContentList로 post 현황 불러오기 -->						
						<c:forEach var="myContent" items="${myContentList}">
							<c:forEach var="i" begin="0" end="${myContent.post.missionPeriod}">
							 <c:if test="${myContent.post.missionId eq myMission.missionId}">																											
							  <img src="https://cdn-icons-png.flaticon.com/512/1168/1168610.png" alt="success" width="30px">
<!--  						  <img src="https://cdn-icons-png.flaticon.com/512/1828/1828666.png" alt="fail" width="25px">
							  <img src="https://cdn-icons-png.flaticon.com/512/136/136831.png"  alt="left" width="30px">	 -->												
							 </c:if>
							</c:forEach>
						</c:forEach>
						</div>
						
					</div>		
														
				 </div>
				</c:forEach>
				
			</div>
		</div>
		
	</div>
</div>
