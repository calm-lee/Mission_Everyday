<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="d-flex justify-content-center mt-5">

<div id="mission-box" class="container" style="background-color: white">	
	<div class="category-header mt-3">
		<h2 class="ml-5" style="color:#524e4e"><b>${mission.categoryName}</b></h2>
			<hr>
	</div>
	
	<div class="contents d-flex justify-content-center">
	<div class="categories d-flex flex-wrap text-center mr-3">
		<c:forEach var="mission" items="${missionList}">
				<div class="m-4">
				<a href="/mission/mission_club/${mission.id}">
				<img src="${mission.missionImage}" width="180px" height="120px">
					<div class="m-3">
					${mission.missionName}
					</div></a>
				</div>				
		</c:forEach>
	</div>
	</div>
	</div>
</div>