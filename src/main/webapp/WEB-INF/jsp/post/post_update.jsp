<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div class="d-flex justify-content-center">
	<div>
		<div class="post-box form-control ml-5 mt-5">

			<!-- 텍스트 박스 -->
			<textarea name="content" cols="68" rows="4" placeholder="내용을 입력해주세요.">
			${post.content}
			</textarea>
			<div class="d-flex justify-content-between mt-3">
				<!--  이미지 버튼 -->
				<div class="ml-2">
					<input type="file" name="image" id="file"
						accept=".jpg, .jpeg, .png, .gif" class="d-none">
					<input
						type="text" name="originalImage" value="${post.imgPath}"
						class="d-none">
					<a href="#" id="fileUploadBtn"><img
						src="https://cdn4.iconfinder.com/data/icons/ionicons/512/icon-image-512.png"
						width="35"></a>
				</div>

				<!-- 업로드 버튼 -->
				<div class="mr-2">
					<a href="/mission/mission_club/${post.missionId}"><button
							type="button" id="updatePost"
							class="btn updatePost form-control bg-info"
							style="color: white; font-size: 12px" data-post-id="${post.id}">업로드</button></a>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
	
$(document).ready(function(){	
	
	// 파일 업로드
	$('#fileUploadBtn').on('click',function(e){		
		e.preventDefault();
		$('#file').click();
	});
			
	// 수정하기
	$('.updatePost').on('click', function(e) {
		e.preventDefault();
		
		let postId = $(this).data('post-id');
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
	
		formData.append("id", postId);
		formData.append("content", content);
		formData.append("file", $('input[name=image]')[0].files[0]);

		$.ajax({
			type : 'PUT'
			,url : "/post/update"
			,data: formData
			
			// 파일 업로드 시 필수 파라미터 
			, processData: false // 기본은 true(json, String)로 넘어갔으나 이번에는 formData로 넘어가므로 false
			, contentType: false
			, enctype: 'multipart/form-data'
			
			, success: function(data){
				if(data.result == 'success'){
					alert("수정이 완료되었습니다.");
					location.reload();
				} else {
					alert("오류가 발생했습니다.")
				}
			}
			, error: function(request,status,error){
			alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
			}			
		});

		
	});
});
</script>