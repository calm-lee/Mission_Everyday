<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
	<div class="bar d-flex justify-content-between">
		<div class="mt-2 ml-5">
			<a href="/mission/main"><span class="logo">Mission! Everyday</span></a>
		</div>
		<div class="justify-content-end align-items-center mt-4 mr-5">
			
			<!-- 로그인이 된 경우 -->
			<c:if test="${not empty userName}">
			<div class="d-flex align-items-center">
				<div class="mr-3" style="color:#727273; font-size:14px"><b>${userName}</b>님! 오늘도 함께해요!</div>
				<div class="mr-3" style="color:#727273; font-size:14px"><a href="/my/mission"><img src="https://cdn-icons-png.flaticon.com/512/3260/3260867.png" width="20px"><span style="font-size:14px; color:#727273" class="ml-1">마이페이지</span></a></div>
				<div><a href="/user/sign_out"><button class="logInOutBtn" style="color:#727273; font-size:12px">로그아웃</button></a></div>
			</div>
			</c:if>
			
			<!-- 로그인 안 된 경우 -->
			<c:if test="${empty userName}">
			<div class="mt-2 mr-3">
				<a href="/user/sign_in"><button class="logInOutBtn" style="color:#727273; font-size:14px">로그인</button></a>
			</div>
			</c:if>
				
		</div>
	</div>
</header>