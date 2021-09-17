<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="myPage d-flex flex-wrap mt-5">
	
	<div id="myPageBar" class="ml-5">
		<nav class="side-menu">
		 <h2 class="mb-4" style="color: #727273">My Page</h2>
		 <hr align="left" style="width: 50%;">
		 <ul class="nav flex-column">
		 	<li class="nav-item mt-2"><a href="#" class="menu-text">참여 중인 미션</a></li>
		 	<li class="nav-item mt-4"><a href="#" class="menu-text">My 인증 포스트</a></li>
		 	<li class="nav-item mt-4"><a href="#" class="menu-text">인증 성공 현황</a></li>
		 </ul>
		</nav>
	</div>


	<div id="myPageView" class="container">
		
		<div class="my-header">
			<h2 class="ml-2" style="color:#524e4e"><b>참여 중인 미션</b></h2>
			<hr>
		</div>
		
		<div class="contents d-flex justify-content-center">
			<div class="myMissions d-flex flex-wrap text-center mr-3">
				<c:forEach var="myMission" items="${myMissionList}">
						<div class="m-4">
						<a href="/mission/${myMission.categoryId}/${myMission.missionId}">
						<img src="${myMission.missionImage}" width="180px">
							<div class="m-3">
							${myMission.missionName}
							</div>
							</a>
						</div>
						<div>가입일: ${myMission.createdAt}</div>				
				</c:forEach>
			</div>
		</div>	
		
	</div>
	
</div>