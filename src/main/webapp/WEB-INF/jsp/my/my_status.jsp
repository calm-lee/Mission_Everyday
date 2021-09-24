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
				<div class="statusBox">
				
				<c:forEach var="myMission" items="${myMissionList}">
					<!-- 미션 이미지 -->
					<a href="/mission/${myMission.categoryId}/${myMission.missionId}">
					<img src="${myMission.missionImage}" width="160px">
					${myMission.missionName}
					</a>
					
					<!-- 인증 text -->
					<div>
					인증 성공: ㅇㅇ개 / 인증 실패: ㅇㅇ개 / 남은 인증: ㅇㅇ개
					</div>
					
					<!-- 인증 체크박스 -->
					<div class="mb-3">
					월${myPostList.id}
						<div>
						<img src="https://cdn-icons-png.flaticon.com/512/1168/1168610.png" width="30px">
						<img src="https://cdn-icons-png.flaticon.com/512/1828/1828666.png" width="25px">
						<img src="https://cdn-icons-png.flaticon.com/512/136/136831.png"  width="30px">
						</div>
						
					</div>

					
					</c:forEach>																		
				</div>
	
			</div>
		</div>
		
		</div>
</div>

</div>	

<script>