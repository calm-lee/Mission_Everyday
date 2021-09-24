<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 

<div class="missionPage d-flex flex-wrap mt-5">

	<div id="missionBar" class="text-center ml-4">
		
			<!-- 미션 소개 -->
			<img src="${mission.missionImage}" width="260px" class="missionImage" data-mission-image="${mission.missionImage}">
			<div class="missionName m-2" style="font-size: 18px" data-mission-name="${mission.missionName}"><b>${mission.missionName}</b></div>
			<div class="m-2" style="font-size: 12px; color:#6f706f">${mission.missionIntroduction}</div>
			<div class="m-2" style="font-size: 12px">참가자 수 ${memberCount}명</div>		
			
			<!-- 가입 및 탈퇴버튼 -->		
			<c:choose>
			<c:when test="${result.check eq 'no-member'}"> <!--  가입하지 않은 상태일 때 -->
						<!-- 미션 가입하기 버튼 -->
						<div class="d-flex justify-content-center">	
						<button class="joinBtn col-6 bg-primary form-control text-white" data-mission-id="${mission.id}" data-member-userId="${member.userId}" data-category-id="${mission.categoryId}">미션 참여하기</button></div>						
			</c:when>		
			<c:otherwise> <!--  가입된 상태일 때 -->
						<!-- 미션 탈퇴하기 버튼 -->
						<div class="d-flex justify-content-center">
						<button class="joinOutBtn col-6 bg-danger form-control text-white" data-mission-id="${mission.id}" data-member-userId="${member.userId}">미션 탈퇴하기</button></div>	
			</c:otherwise>
			</c:choose>
			
	</div>	
	
<!-- 타임라인 -->
	<div id="missionTimeline" class="ml-5">

		<div class="d-flex justify-content-center">
		
		<!-- 포스트박스 -->
		
		<!--  가입하지 않은 상태일 때 노출 안함 -->
		<c:if test="${result.check eq 'no-member'}">
			
			<div class="post-box d-none">
				
				<!-- 텍스트 박스 -->
				<textarea name="content" cols="50" rows="4"
					placeholder="내용을 입력해주세요."></textarea>
				
					<!--  이미지 버튼 -->
					<div class="d-flex justify-content-between mt-4">
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
							class="btn uploadBtn form-control bg-info" style="color:white; font-size:12px">
							업로드
						</button>
					</div>
				</div>
			</div>
		</c:if>
		
		<!--  미션 가입한 상태일 때 노출함 -->
		<c:if test="${result.check eq 'member'}">
			<div class="post-box">
			
				<!-- 텍스트 박스 -->
				<textarea name="content" cols="50" rows="4"
					placeholder="내용을 입력해주세요."></textarea>
				<div class="d-flex justify-content-between mt-4">
					<!--  이미지 버튼 -->
					<div class="ml-2">${missionStartDate}
						<input type="file" name="image" id="file"
							accept=".jpg, .jpeg, .png, .gif" class="d-none"> <a
							href="#" id="fileUploadBtn"><img
							src="https://cdn4.iconfinder.com/data/icons/ionicons/512/icon-image-512.png"
							width="35"></a>
					</div>
	
					<!-- 업로드 버튼 -->
					<div class="mr-2">
					
					<!-- 미션 생성/종료날짜 Date -> String 변환 -->
					<fmt:formatDate  var="missionStartDate" value="${mission.missionStartDate}" pattern="yyyy-MM-dd"/>
					<fmt:formatDate  var="missionFinishDate" value="${mission.missionFinishDate}" pattern="yyyy-MM-dd"/>
																					
						<button type="button" id="uploadBtn"
							class="btn uploadBtn form-control bg-info" 											
							style="color:white; font-size:12px" data-mission-id="${mission.id}" data-mission-name="${mission.missionName}" data-mission-startDate="${missionStartDate}" data-mission-finishDate="${missionFinishDate}" data-mission-period="${mission.missionPeriod}">
							업로드
						</button>
						
					<input class="missionStartDate d-none" value="${missionStartDate}">
					<input class="missionFinishDate d-none" value="${missionFinishDate}">
					</div>
				</div>
			</div>
		</c:if>	
		</div>
		
	<!-- 피드 -->	
	<div class="d-flex justify-content-center mt-5">
	<div>
	
	<c:forEach var="content" items="${contentList}" varStatus="status"> <!-- contentList 반복문으로 노출 -->
		<c:if test="${content.post.missionId eq mission.id}">
	
		<div class="feed-box form-control mt-3">
		
	<!-- 미션 아이디가 현재 접속한 미션과 같을 때만 피드 노출 -->
	
		
		<!-- 글쓴이 아이디, 수정/삭제 버튼 -->
			
			<div class="feed-header d-flex justify-content-between mt-2">
				<b>${content.post.userName}</b>
				
			<!-- userName이 post의 userName과 일치할 때만 노출 -->
				<c:if test="${content.post.userName eq userName}">
		 			<div id="moreDetailBtn" class="d-flex mt-1">
						<a href="#" class="btn updatePost mr-2" data-toggle="modal" data-target="#updateModal" style="padding: 1px; font-size: 12px; color:#524e4e;" data-post-id="${content.post.id}">수정</a>
						<hr>
						<a href="#" class="btn deletePost  mr-2" style="padding: 1px; font-size: 12px; color:#524e4e" data-post-id="${content.post.id}">삭제</a>
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
			<div class="like-feed d-flex mt-1 align-items-center">
			
			<!-- filledLike이 false이면 빈하트가 보이게 -->
			<c:if test="${content.filledLike eq false}">
				<a href="#" class="btn likeBtn" data-post-id="${content.post.id}"  data-user-id="${userId}">
				<img src="https://www.iconninja.com/files/214/518/441/heart-icon.png" width="20" height="20"></a>
			</c:if>	
			
			<!-- filledLike이 true이면 채운하트가 보이게 -->
			<c:if test="${content.filledLike eq true}">
				<a href="#" class="btn likeBtn" data-post-id="${content.post.id}"  data-user-id="${userId}"><img src="https://www.iconninja.com/files/527/809/128/heart-icon.png" width="20" height="20"></a>		
			</c:if>
			좋아요 ${content.likeCount}개
			</div>
			
		<!-- 글 영역 -->	
			<div class="post-feed mt-2">
				<span class="font-weight-bold">${content.post.userName}</span>
				<span>
					${content.post.content}
				</span>
			</div>
			
		<!-- 댓글 영역 -->			
			<div class="comment-feed mt-4 border-bottom">
				<div style="font-size:14px; color: #808080" class="mb-1">댓글</div>
				
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
			<div class="comment-create d-flex mt-2">
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

<c:forEach var="content" items="${contentList}">
	<div class="modal" id="updateModal" tabindex="-1" role="dialog">				
	<div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header text-center">
	        <h5 class="modal-title">글 수정</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <textarea name="contentUdate">${post.content}</textarea>
	        					<div class="d-flex justify-content-between mt-4">
					<div class="ml-2">
						<input type="file" name="image" id="file"
							accept=".jpg, .jpeg, .png, .gif" class="d-none"> <a
							href="#" id="fileUploadBtn"><img
							src="https://cdn4.iconfinder.com/data/icons/ionicons/512/icon-image-512.png"
							width="35"></a>
					</div>
	      </div>
	      
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary">Save changes</button>
	      </div>
	    </div>
	  </div>
	</div>
</div>
</c:forEach>

<script>

$(document).ready(function(){
	
	//미션 가입
	
	$('.joinBtn').on('click',function(e){
		e.preventDefault; // submit 기본동작 중단

		let categoryId = $(this).data('category-id');
		let missionId = $(this).data('mission-id');
		let missionName = $('.missionName').data('mission-name');
		let missionImage = $('.missionImage').data('mission-image');
		
		$.ajax({
			url: "/mission/join"
			, type: 'POST'
			, data: {"categoryId":categoryId, "missionId":missionId, "missionName":missionName, "missionImage":missionImage}
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
		
		alert(missionStartDate);
		
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
			, type: 'POST'
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
			type:'POST',
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
		alert(postId);
		
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
			type:'POST',
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