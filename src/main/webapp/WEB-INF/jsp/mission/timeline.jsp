<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<div class="missionPage d-flex flex-wrap mt-5">
	<div>
		<div id="missionBar" class="text-center ml-4">
		
			<!-- 미션 소개 -->
			<img src="${mission.missionImage}" width="260px">
			<div class="missionName m-2" style="font-size: 18px" data-mission-name="${mission.missionName}"><b>${mission.missionName}</b></div>
			<div class="m-2" style="font-size: 12px; color:#6f706f">${mission.missionIntroduction}</div>
			<div class="m-2" style="font-size: 12px">참가자 수 ${memberCount}명</div>		
			
			<!-- 가입 및 탈퇴버튼 -->		
			<c:choose>
			<c:when test="${result eq 'no-member'}"> <!--  가입하지 않은 상태일 때 -->
						<!-- 미션 가입하기 버튼 -->
						<div class="d-flex justify-content-center">	
						<button class="joinBtn col-6 bg-primary form-control text-white" data-mission-id="${mission.id}" data-member-userId="${member.userId}">미션 참여하기</button></div>						
			</c:when>		
			<c:otherwise> <!--  가입된 상태일 때 -->
						<!-- 미션 탈퇴하기 버튼 -->
						<div class="d-flex justify-content-center">
						<button class="joinOutBtn col-6 bg-danger form-control text-white" data-mission-id="${mission.id}" data-member-userId="${member.userId}">미션 탈퇴하기</button></div>	
			</c:otherwise>
			</c:choose>
			
		</div>
	</div>			
	
<!-- 타임라인 -->
	<div class="d-flex justify-content-center">
	<div id="missionTimeline" class="ml-5">
	<div class="d-flex justify-content-center">
	
	<!-- 포스트박스 -->
		<div class="post-box">
			<textarea name="content" cols="50" rows="4"
				placeholder="내용을 입력해주세요."></textarea>

			<div class="d-flex justify-content-between mt-4">
				<!--  이미지 버튼 -->
				<div class="ml-2">
					<input type="file" name="image" id="file"
						accept=".jpg, .jpeg, .png, .gif" class="d-none"> <a
						href="#" id="fileUploadBtn"><img
						src="https://cdn4.iconfinder.com/data/icons/ionicons/512/icon-image-512.png"
						width="35"></a>
				</div>

				<!-- 업로드 버튼 -->
				<div class="mr-2">
					<button type="button" id="uploadBtn"
						class="btn form-control bg-info" style="color:white; font-size:12px">
						업로드
					</button>
				</div>
			</div>
		</div>
	</div>
	</div>
	</div>
</div>

<script>
$(document).ready(function(){
	
	//미션 가입
	
	$('.joinBtn').on('click',function(e){
		e.preventDefault; // submit 기본동작 중단

		let missionId = $(this).data('mission-id');
		let missionName = $('.missionName').data('mission-name');
		
		$.ajax({
			url: "/mission/join"
			, type: 'POST'
			, data: {"missionId":missionId,"missionName":missionName}
			, success: function(data){
				if(data.result == "success"){
					alert("미션 가입이 완료됐습니다.");
					location.reload();
				} else { 
					alert("미션 가입에 실패했습니다.");
				}
			}
			, error: function(e){
				alert("미션 가입에 실패했습니다. 관리자에게 문의해주십시오." + e);
			}
		});	
	});		
	
	// 미션 탈퇴
	$('.joinOutBtn').on('click',function(e){
		e.preventDefault; // submit 기본동작 중단

		let missionId = $(this).data('mission-id');
		
		$.ajax({
			url: "/mission/out"
			, type: 'POST'
			, data: {"missionId":missionId}
			, success: function(data){
				if(data.result == "success"){
					alert("미션 탈퇴가 완료되었습니다.");
					location.reload();
				} else { 
					alert("미션 탈퇴에 실패했습니다.");
				}
			}
			, error: function(e){
				alert("미션 탈퇴에 실패했습니다. 관리자에게 문의해주십시오." + e);
			}
		});	
	});			
}); 
</script>