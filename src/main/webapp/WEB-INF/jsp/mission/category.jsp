<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="d-flex justify-content-center mt-5">

<div id="category-box" class="container" style="background-color: white">
		
		<div class="category-header mt-3">
		<h2 class="ml-2" style="color:#524e4e"><b>미션 카테고리</b></h2>
		<hr>
		</div>
		
		<div class="contents d-flex justify-content-center">
			<div class="categories d-flex flex-wrap text-center">
										
				<div class="excercise m-4">
				<a href="/mission/category/1" data-category-id=1>
				<img src="https://cdn-icons-png.flaticon.com/512/3043/3043196.png" width="180px">
					<div class="m-3">
					운동
					</div></a>
				</div>
				
				<div class="study m-4">
				<a href="/mission/category/2" data-category-id=2>
				<img src="https://cdn-icons-png.flaticon.com/512/3094/3094216.png" width="180px">
					<div class="m-3">
					공부
					</div></a>
				</div>
				
				<div class="language m-4">
				<a href="/mission/category/3" data-category-id=3>
				<img src="https://cdn-icons-png.flaticon.com/512/1372/1372756.png" width="180px">
					<div class="m-3">
					외국어
					</div></a>
				</div>
				
				<div class="diet m-4">
				<a href="/mission/category/4" data-category-id=4>
				<img src="https://cdn-icons-png.flaticon.com/512/3867/3867909.png" width="180px">
					<div class="m-3">
					다이어트
					</div></a>
				</div>
				
				<div class="hobby m-4">
				<a href="/mission/mission_detail/5" data-category-id=5>
				<img src="https://cdn-icons-png.flaticon.com/512/4207/4207225.png" width="180px">
					<div class="m-3">
					취미
					</div></a>
				</div>
				
				<div class="finance m-4">
				<a href="/mission/mission_detail/6" data-category-id=6>
				<img src="https://cdn-icons-png.flaticon.com/512/4256/4256900.png" width="180px">
					<div class="m-3">
					재테크
					</div></a>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
/* $(document).ready(function)({
	
	$('.imgBtn').on('click',function(e){
		let categoryId = $(this).data('category-id');
		
		$.ajax({
			type:'GET',
			data: {"categoryId": categoryId},
			success: function(data){
				if(result == success){
					alert("운동");
				} else {
					alert("오류발생");
				}
			}
			error: function(jqXHR, textStatus, errorThrown) {
				var errorMsg = jqXHR.responseJSON.status;
				alert(errorMsg + ":" + textStatus);
			}
		});
		
	});
	
}); */
</script>