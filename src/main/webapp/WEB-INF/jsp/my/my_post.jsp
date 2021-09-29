<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 

<div class="myPage d-flex flex-wrap mt-5">
	
	<div id="myPageBar" class="ml-2 form-control" style="background-color: white">
		<nav class="side-menu">
		 <h4 class="mt-2" style="color: #727273"><b>MY PAGE</b></h4>
		 <hr align="left" style="width:50%">
		 <ul class="nav flex-column">
		 	<li class="nav-item mt-2"><a href="/my/mission" class="menu-text">My 참여 중인 미션</a></li>
		 	<li class="nav-item mt-4"><a href="/my/post" class="menu-text">My 인증 포스트</a></li>
		 	<li class="nav-item mt-4"><a href="/my/status" class="menu-text">My 인증 성공 현황</a></li>
		 </ul>
		</nav>
	</div>


	<!-- 페이지 뷰 -->
	<div id="myPage" class="ml-5">
		
		<!-- 헤더 -->
		<div class="my-header form-control">
			<h2 class="ml-2 mt-1" style="color:#524e4e"><b>My 인증 포스트</b></h2>
			<hr>
		</div>
		
		<!-- 내가 쓴 글 타임라인 -->
		<div class="contents d-flex justify-content-center">
			<div>
			
			<c:forEach var="myContent" items="${myContentList}" varStatus="status">
			
				<!-- 미션 아이디가 현재 접속한 미션과 같을 때만 피드 노출 -->
				
				<c:if test="${myContent.post.userId eq userId}">
			
				<div class="feed-box form-control mt-3">
				
				<!-- 미션클럽 정보 -->
				<div class="text-right" style="font-size:12px">
					<span class="mr-2" style="color:#524e4e;">from <a href="/mission/mission_club/${myContent.post.missionId}"><span style="color:#524e4e; font-weight:bold;">${myContent.post.missionName}</span></a></span>
					<hr style="margin-top:0.5rem">
				</div>
				
				<!-- 글쓴이 아이디, 수정/삭제 버튼 -->
					
					<div class="feed-header d-flex justify-content-between mt-2">
					<div class="ml-3">
						<b>${myContent.post.userName}</b><br>
						<fmt:formatDate var="postCreatedAt" value="${myContent.post.createdAt}" pattern="yyyy년 MM월 dd일 HH:mm"/>
					 	<span class="mt-1" style="font-size: 11px; color:#808080">${postCreatedAt}</span>
					</div>	
					<!-- userName이 post의 userName과 일치할 때만 노출 -->
						<c:if test="${myContent.post.userName eq userName}">
				 			<div class="d-flex mt-1">
								<a href="/post/update_view?id=${myContent.post.id}" class="btn mr-2" style="padding: 1px; font-size: 12px; color:#524e4e;" data-post-id="${myContent.post.id}">수정</a>
								<a href="#" class="btn deletePost mr-2" style="padding: 1px; font-size: 12px; color:#524e4e" data-post-id="${myContent.post.id}">삭제</a>
							</div>
						</c:if>
					</div>
		
					
				<!-- 피드 이미지 -->
					<c:if test="${not empty myContent.post.imgPath}">
					<div class="d-flex justify-content-center mt-3">
						<img src="${myContent.post.imgPath}" width="350">
					</div>
					</c:if>
					 
				<!-- 좋아요 영역 -->
					<div class="like-feed d-flex mt-1 align-items-center">
					
					<!-- filledLike이 false이면 빈하트가 보이게 -->
					<c:if test="${myContent.filledLike eq false}">
						<a href="#" class="btn likeBtn" data-post-id="${myContent.post.id}"  data-user-id="${userId}">
						<img src="https://www.iconninja.com/files/214/518/441/heart-icon.png" width="20" height="20"></a>
					</c:if>	
					
					<!-- filledLike이 true이면 채운하트가 보이게 -->
					<c:if test="${myContent.filledLike eq true}">
						<a href="#" class="btn likeBtn" data-post-id="${myContent.post.id}"  data-user-id="${userId}"><img src="https://www.iconninja.com/files/527/809/128/heart-icon.png" width="20" height="20"></a>		
					</c:if>
					좋아요 ${myContent.likeCount}개
					</div>
					
				<!-- 글 영역 -->	
					<div class="post-feed mt-2">
						<span class="font-weight-bold">${myContent.post.userName}</span>
						<span>
							${myContent.post.content}
						</span>
					</div>
					
				<!-- 댓글 영역 -->			
					<div class="comment-feed mt-4 border-bottom">
						<div style="font-size:14px; color: #808080" class="mb-1">댓글</div>
						
					</div>
					
					<!-- 댓글 목록 -->
				<c:forEach var="comment" items="${myContent.commentList}">
			
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
				<c:if test="${not empty myContent.post.userName}">
					<div class="comment-create d-flex mt-2">
						<input type="text" placeholder="댓글을 입력해주세요." id="commentTxt${myContent.post.id}" class="form-control">
						<button type="button" class="btn commentBtn ml-1" data-mission-id="${myContent.post.missionId}" data-post-id="${myContent.post.id}">게시</button>
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