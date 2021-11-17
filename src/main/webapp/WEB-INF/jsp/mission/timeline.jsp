<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 

<div class="missionPage d-flex flex-wrap mt-4">

	<div id="missionBar" class="text-center ml-5 form-control">
		
			
		
			<!-- 미션 소개 -->
			<img src="${mission.missionImage}" width="180px" class="missionImage mt-3" data-mission-image="${mission.missionImage}">
			<div class="missionName m-2" style="font-size: 18px" data-mission-name="${mission.missionName}"><b>${mission.missionName}</b></div>
			
						<!-- 미션 생성/종료날짜 Date -> String 변환 -->
			<fmt:formatDate  var="missionStartDate" value="${mission.missionStartDate}" pattern="yyyy-MM-dd"/>
			<fmt:formatDate  var="missionFinishDate" value="${mission.missionFinishDate}" pattern="yyyy-MM-dd"/>
			
			<div class="m-2" style="font-size: 12px">${missionStartDate} (월) ~ ${missionFinishDate} (일) <span style="border-radius: 2px; background-color:#989c9a; color:white">&nbsp;${mission.missionPeriod}일&nbsp;</span></div>	
			<div class="m-2" style="font-size: 12px; color:#6f706f">${mission.missionIntroduction}</div>
			<div class="m-2" style="font-size: 12px">참가자 수 ${memberCount}명</div>		
			
			<!-- 가입 및 탈퇴버튼 : 종료되지 않은 미션일 시 보임-->
			<c:if test="${checkMissionAvailable eq 'open'}">		
				<c:choose>
				<c:when test="${result.check eq 'no-member'}"> <!--  가입하지 않은 상태일 때 -->
							<!-- 미션 가입하기 버튼 -->
							<div class="d-flex justify-content-center">	
							<button class="joinBtn mt-2" data-mission-id="${mission.id}" data-member-userId="${member.userId}" data-category-id="${mission.categoryId}" data-mission-period="${mission.missionPeriod}">미션 참여하기</button></div>						
				</c:when>		
				<c:otherwise> <!--  가입된 상태일 때 -->
							<!-- 미션 탈퇴하기 버튼 -->
							<div class="d-flex justify-content-center">
							<button class="joinOutBtn mt-2" data-mission-id="${mission.id}" data-member-userId="${member.userId}">미션 탈퇴하기</button></div>	
				</c:otherwise>
				</c:choose>
			</c:if>
			
			
			<c:if test="${checkMissionAvailable eq 'closed'}">
				<div class="closedMission mt-2">종료된 미션입니다.</div>
			</c:if>		
			<input type="text" value="${missionStartDate}" class="missionStartDate d-none">
			<input type="text" value="${missionFinishDate}" class="missionFinishDate d-none">			
			
	</div>	
	
<!-- 타임라인 -->
	<div id="missionTimeline" class="ml-5">

		<div class="d-flex justify-content-center">
		
		<!-- 포스트박스 -->

		<!--  미션 가입한 상태일 때 노출함 -->
		<c:if test="${result.check eq 'member'}">
			<div class="post-box form-control ml-5">
			
				<!-- 텍스트 박스 -->
				<textarea name="content" cols="68" rows="4"
					placeholder="내용을 입력해주세요."></textarea>
				<div class="d-flex justify-content-between mt-3">
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
							class="btn uploadBtn form-control bg-info" 											
							style="color:white; font-size:12px" data-mission-id="${mission.id}" data-mission-name="${mission.missionName}" data-mission-startdate="${missionStartDate}" data-mission-finishdate="${missionFinishDate}" data-mission-period="${mission.missionPeriod}">
							업로드
						</button>
						
					</div>
				</div>
			</div>
		</c:if>	
	
		<!-- 아무도 가입하지 않은 경우 (웰컴 이미지) -->
		<c:if test="${memberCount eq 0}">
			<div class="ml-5 mt-4">
				<div class="d-flex justify-content-center">
				<img src="https://cdn-icons-png.flaticon.com/512/5331/5331946.png" width="200" alt="welcome">
				</div>
				<div class="text-center mt-3">가입해서 첫 포스트를 남겨보세요.</div>
			</div>
		</c:if>
		
		</div>
		
	<!-- 피드 -->	
	<div class="d-flex justify-content-center mt-2 ml-5">

	</div>
	
	<c:forEach var="content" items="${contentList}" varStatus="status"> <!-- contentList 반복문으로 노출 -->
	
		<!-- 미션 아이디가 현재 접속한 미션과 같을 때만 피드 노출 -->
		<c:if test="${content.post.missionId eq mission.id}">	
		
		<div class="feed-box form-control mt-3">	
		
		<!-- 글쓴이 아이디, 수정/삭제 버튼 -->			
			<div class="feed-header d-flex justify-content-between mt-3 ml-3">
			
			<div>
				<b>${content.post.userName}</b>
				<br><fmt:formatDate var="postCreatedAt" value="${content.post.createdAt}" pattern="yyyy년 MM월 dd일 HH:mm"/>
				<span style="font-size: 11px; color:#808080">${postCreatedAt}</span>
			</div>
				
			<!-- userName이 post의 userName과 일치할 때만 노출 -->
				<c:if test="${content.post.userName eq userName}">
		 			<div class="d-flex mt-1 algin-items-center">
						<a href="/post/update_view?id=${content.post.id}" class="btn mr-2" style="padding: 1px; font-size: 12px; color:#524e4e;" data-post-id="${content.post.id}">수정</a>
						<hr>
						<a href="#" class="btn deletePost mr-2" style="padding: 1px; font-size: 12px; color:#524e4e" data-post-id="${content.post.id}">삭제</a>
					</div>
				</c:if>
			</div>

			
		<!-- 피드 이미지 -->
			<c:if test="${not empty content.post.imgPath}">
			<div class="d-flex justify-content-center mt-3">
				<img src="${content.post.imgPath}" width="350">
			</div>
			</c:if>
			 
		<!-- 좋아요 영역 -->
			<div class="like-feed d-flex mt-3 ml-3 align-items-center">
			
			<!-- filledLike이 false이면 빈하트가 보이게 -->
			<c:if test="${content.filledLike eq false}">
				<a href="#" class="btn likeBtn" style="padding: 0px 4px;" data-post-id="${content.post.id}"  data-user-id="${userId}">
				<img src="https://www.iconninja.com/files/214/518/441/heart-icon.png" width="20" height="20"></a>
			</c:if>	
			
			<!-- filledLike이 true이면 채운하트가 보이게 -->
			<c:if test="${content.filledLike eq true}">
				<a href="#" class="btn likeBtn" style="padding: 0px 4px;" data-post-id="${content.post.id}"  data-user-id="${userId}"><img src="https://www.iconninja.com/files/527/809/128/heart-icon.png" width="20" height="20"></a>		
			</c:if>
			<span style="font-size: 16px">좋아요 ${content.likeCount}개</span>
			</div>
			
		<!-- 글 영역 -->	
			<div class="post-feed mt-3 ml-3">
				<span class="font-weight-bold">${content.post.userName}</span>
				<span>
					${content.post.content}
				</span>
			</div>
			
		<!-- 댓글 영역 -->			
			<div class="comment-feed mt-3 border-bottom">
				<div style="font-size:14px; color: #808080" class="ml-1 mb-2">댓글</div>
				
			</div>
			
			<!-- 댓글 목록 -->
		<c:forEach var="comment" items="${content.commentList}">
	
			<div class="comment-list mt-2 clearfix">
				<div class="commentBlock">
		            <span class="font-weight-bold">${comment.userName}</span>	
					<span>${comment.content}</span>
				
				<!-- 댓글 삭제 버튼 -->
					<a href="#" class="commentDelBtn float-right mr-3" data-comment-id="${comment.id}">
					<img src="https://www.iconninja.com/files/603/22/506/x-icon.png" width="10px" height="10px">
					</a>
				</div>
			</div>
		</c:forEach>	
		
		<!-- 댓글 쓰기 영역 -->	
		<c:if test="${not empty content.post.userName}">
			<div class="comment-create d-flex mt-2 mb-2">
				<input type="text" placeholder="댓글을 입력해주세요." id="commentTxt${content.post.id}" class="form-control">
				<button type="button" class="btn commentBtn ml-1" data-mission-id="${content.post.missionId}" data-post-id="${content.post.id}">게시</button>
			</div>
		</c:if>
		</div>
		</c:if>

		</c:forEach>
		</div>
		</div>
	</div>
</div>
<script>

$(document).ready(function(){
	
	//미션 가입
	
	$('.joinBtn').on('click',function(e){
		e.preventDefault; // submit 기본동작 중단

		let categoryId = $(this).data('category-id');
		let missionId = $(this).data('mission-id');
		let missionName = $('.missionName').data('mission-name');
		let missionStartDate = $('.missionStartDate').val();
		let missionFinishDate = $('.missionFinishDate').val();
		let missionPeriod = $(this).data('mission-period');
		let missionImage = $('.missionImage').data('mission-image');
		
		$.ajax({
			url: "/mission/join"
			, type: 'POST'
			, data: {"categoryId":categoryId, "missionId":missionId, "missionName":missionName, "missionStartDate": missionStartDate, "missionFinishDate": missionFinishDate, "missionPeriod": missionPeriod, "missionImage":missionImage}
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
				} 
			}
			, error: function(e){
				alert("미션 탈퇴에 실패했습니다. 관리자에게 문의해주십시오." + e);
			}
		});	
	});			
	
	// 파일 업로드
	$('#fileUploadBtn').on('click',function(e){		
		e.preventDefault();
		$('#file').click();
	});
	
	// 글 업로드
	$('.uploadBtn').on('click', function(e){
		e.preventDefault();

		let missionId = $(this).data('mission-id');
		let missionName = $(this).data('mission-name');
		let missionStartDate = $('.missionStartDate').val();
		let missionFinishDate = $('.missionFinishDate').val();
		let missionPeriod = $(this).data('mission-period');
		let content = $('textarea[name=content]').val();
		let imgPath = $('input[name=image]').val();
		
		// 확장자 체크
		if(imgPath != ''){
			var ext = imgPath.split('.').pop().toLowerCase();
			if($.inArray(ext, ['jpg', 'jpeg', 'png', 'gif']) == -1){ //확장자가 배열에 없을 경우 (-1로 반환)
				alert("jpg, jpeg, png, gif 파일만 업로드할 수 있습니다.");
				let imgPath = $('input[name=image]').val().empty(); // input에 있는 내용 초기화
				return;
			}
		}
		
		// formData에 content, file 추가
		let formData = new FormData();
		
		formData.append("missionId", missionId);
		formData.append("missionName", missionName);
		formData.append("missionStartDate", missionStartDate);
		formData.append("missionFinishDate", missionFinishDate);
		formData.append("missionPeriod", missionPeriod);
		formData.append("content", content);
		formData.append("file", $('input[name=image]')[0].files[0]);

		
		$.ajax({
			url: "/post/create"
			, method: "post"
			, data: formData
			
			// 파일 업로드 시 필수 파라미터 
			, processData: false // 기본은 true(json, String)로 넘어갔으나 이번에는 formData로 넘어가므로 false
			, contentType: false
			, enctype: 'multipart/form-data'
			
			, success: function(data){
				if(data.result == 'success'){
					alert("오늘의 미션 성공!");
					location.reload();
				}
			}
			, error: function(request,status,error){
			alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
		}
			
		});
	
	});
	
	// 댓글 업로드
	$('.commentBtn').on('click', function(e){
		e.preventDefault();
		
		let missionId = $(this).data('mission-id'); 
		let postId = $(this).data('post-id'); 
		let commentContent = $('#commentTxt' + postId).val();
		
		if(commentContent == ''){
			return;
		}
		
		$.ajax({
			url: "/comment/create"
			, type: 'POST'
			, data: {"missionId":missionId, "postId":postId, "content":commentContent}
			, success: function(data){
				if(data.result == "success"){
					location.reload();
				} else { 
					alert("댓글 작성에 실패했습니다.");
				}
			}
			, error: function(e){
				alert("댓글 작성에 실패했습니다. 관리자에게 문의해주십시오." + e);
			}
		});	
	});
	
	// 댓글 삭제
	$('.commentDelBtn').on('click',function(e){
		
		let id = $(this).data('comment-id'); 
		
		$.ajax({
			url: "/comment/delete"
			, type: 'DELETE'
			, data: {"id":id}
			, success: function(data){
				if(data.result == "success"){
					location.reload();
				} else { 
					alert("댓글 삭제에 실패했습니다.");
				}
			}
			, error: function(e){
				alert("댓글 삭제에 실패했습니다. 관리자에게 문의해주십시오." + e);
			}
		});			
	});
	
	// 좋아요
	$('.likeBtn').on('click', function(e){
		
		e.preventDefault();
		
		let postId = $(this).data('post-id');
		
		$.ajax({
			type:'GET',
			url:'/post/like_status',
			data: {"postId": postId},
			success: function(data) {
				if (data.result == 'success') {
					location.reload(); // 새로고침
				} else {
					alert("로그인해주세요.");
				}
			},
			error: function(jqXHR, textStatus, errorThrown) {
				var errorMsg = jqXHR.responseJSON.status;
				alert(errorMsg + ":" + textStatus);
			}
		});
	});
	
	// 수정하기
	$('.updatePost').on('click', function(e){
		e.preventDefault();
		
		let postId = $(this).data('post-id');
		$('#updateModal').data('post-id', postId);
		
  		$.ajax({
			type:'POST',
			url: "/mission/1/1",
			data: {"postId": postId},
			success: function(data) {
			},
			error: function(jqXHR, textStatus, errorThrown) {
				var errorMsg = jqXHR.responseJSON.status;
				alert(errorMsg + ":" + textStatus);
			}
		});  

	});
	
	
	// 삭제하기
	$('.deletePost').on('click', function(e){
		e.preventDefault();
		
		let postId = $(this).data('post-id');
		
  		$.ajax({
			type:'DELETE',
			url:'/post/delete',
			data: {"id": postId},
			success: function(data) {
				if (data.result == 'success') {
					alert("삭제가 완료되었습니다.");
					location.reload(); // 새로고침
				}
			},
			error: function(jqXHR, textStatus, errorThrown) {
				var errorMsg = jqXHR.responseJSON.status;
				alert(errorMsg + ":" + textStatus);
			}
		});  
	});
	
}); 
</script>