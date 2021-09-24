<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<div class="myPage d-flex flex-wrap mt-5">
	
	<div id="myPageBar" class="ml-5">
		<nav class="side-menu">
		 <h4 class="mb-2" style="color: #727273;"><b>MY PAGE</b></h4>
		 <hr align="left" style="width:50%">
		 <ul class="nav flex-column">
		 	<li class="nav-item mt-2"><a href="/my/mission" class="menu-text">My 참여 중인 미션</a></li>
		 	<li class="nav-item mt-4"><a href="/my/post" class="menu-text">My 인증 포스트</a></li>
		 	<li class="nav-item mt-4"><a href="/my/status" class="menu-text">My 인증 성공 현황</a></li>
		 </ul>
		</nav>
	</div>


	<div id="myPageView" class="container">
		
		<div class="my-header">
			<h2 class="ml-2" style="color:#524e4e"><b>My 참여 중인 미션</b></h2>
			<hr>
		</div>
		
		<div class="contents d-flex justify-content-center">
			<div class="myMissions d-flex flex-wrap text-center mr-3">
				<c:forEach var="myMission" items="${myMissionList}">
						<div class="m-4">
						<a href="/mission/${myMission.categoryId}/${myMission.missionId}">
						<img src="${myMission.missionImage}" width="160px">
							<div class="mt-1" style="font-size:16px">
							${myMission.missionName}
							</div>
						<div class="mt-1" style="font-size:12px; color:#524e4e">
						<fmt:formatDate value="${myMission.createdAt}" var="pattern1" pattern="yyyy년 MM월 dd일" />
						가입일: ${pattern1}</div>	
						</a>
						</div>			
				</c:forEach>
			</div>
		</div>	
	</div>
	
</div>