<div id="top"></div>

<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/othneildrew/Best-README-Template">
    <img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FchOohz%2FbtrgUo5g8Qn%2F6ndFt6zK3jKZbdachkdfDk%2Fimg.png" alt="Logo">
  </a>
</div>

## 미션! 에브리데이 소개

<b>1. 프로젝트 개발 목적</b><br>
작심 3일로 끝나기 쉬운 자기계발에 동기를 부여하고자 개발한 1인 프로젝트입니다.<br>

<b>2. 개발 기간</b><br>
2021.09.02 - 2021.10.02 (1개월)<br>

<b>3. 수행 역할 (1인 프로젝트)</b><br>
* 기획서, 프로젝트 일정표 작성
* DB, URL, API 설계
* 프로젝트 개발환경 구축 (Spring Boot, Tomcat)
* 프론트엔드 
* 백엔드
* 트러블슈팅
* 동작 테스트
* AWS 배포

<b>4. 미션!에브리데이 주요 기능</b>
* 운동, 공부, 외국어, 재테크, 취미, 다이어트 등 다양한 카테고리의 미션 가입
* 인증 포스트 올리기 (사진 첨부 필수)
* 좋아요, 댓글달기 가능
* 마이페이지에서 내 인증현황 확인 가능

<b>5. 사용 기술 스택</b>
* Java, JavaScript, Ajax, HTML, CSS, jQuery, BootStrap
* Spring 4.11, Apache Tomcat 9.0, Mybatis, MySQL
* Git, AWS

## 구현기능

### 1. 회원가입
> ID, PW, 이메일 기입 후 가입 가능합니다. (아이디 중복확인 필수)

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbkxyBv%2FbtrlqM72Nx5%2FVW01uLogBqIkSdd1pEJG01%2Fimg.png" alt="user" width="800
">


<br/>
<br/>

### 2. 카테고리 & 미션 페이지
> 운동, 공부, 외국어, 다이어트, 취미, 재테크 등 다양한 카테고리의 미션들을 확인할 수 있습니다.

<br/>
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fb1Bfbs%2FbtrlEJXWYqO%2FJoKKJDV51qZsOKiyeALOK0%2Fimg.png" width="800
" alt="category_mission">  

<br/>

### 3. 미션클럽 페이지
> 미션에 가입해 포스트를 올리고, 좋아요&댓글달기가 가능합니다.

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FmKz9u%2FbtrlFa8N4cc%2FvRqKQO57nNPaUny7xcOrXk%2Fimg.png" width="800" alt="post">

### 4-1. 마이 페이지 - 내가 참여한 미션 확인하기
> 내가 참여 중인 미션과 가입일을 확인할 수 있습니다.

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FTTDos%2FbtrlEnAPxLn%2FXPraNPvfLpKgKOq2bK2AZ1%2Fimg.png" width="800" alt="myMission">


<br/>
<br/>

### 4-2. 마이 페이지 - 내가 인증한 포스트 확인하기
> 내가 올린 포스트를 한눈에 확인할 수 있습니다.

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbK64OM%2FbtrlEIEJU0g%2FUkhu7u1V6kt0gBT4WjPHf0%2Fimg.png" width="800" alt="myPost">

<br/>

### 4-3. 마이 페이지 - 내 인증현황 확인하기
> 미션별로 내 인증현황을 확인할 수 있습니다. (성공/실패/남은 일수)

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FkGkJj%2FbtrlFJ4eLW5%2F2ia4CgjpmdOOjnknhDGm2k%2Fimg.png" width="800" alt="myPostStatus">

<br/>

## 프로젝트 설계 과정
### 1. 기획서
> [카카오 오븐](https://ovenapp.io/)을 통해 [기획서](https://ovenapp.io/project/u1vPXyC6FPiBUZFJYClPuW5lQGtSjUf9#1HJPw)를 설계했습니다.

### 2. DB 설계
> 사용 용도에 맞게 다음과 같이 DB를 설계했습니다.

* user : 로그인, 회원가입, 마이페이지에 사용
* category : 카테고리, 미션 페이지에 사용
* mission : 상세 미션 페이지에 사용
* mission_user : 미션에 가입한 유저의 수를 조회하는 데 사용
* post : 포스트 생성, 수정, 삭제에 사용
* comment : 댓글 생성, 삭제에 사용
* like : 글마다 눌러지는 좋아요 생성, 해제에 사용 
 
</br>
 <b>DB 필드 ERD 구조</b></br>
 https://dbdiagram.io/d/618e835a02cf5d186b53668f
 <img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2F1w9n8%2FbtrlgTF3MpW%2F2gej8xxZKW8o9efSlIDjN1%2Fimg.png" alt="DB_ERD">

<br/>
<br/>
<br/>
<br/>
<br/>

### 3. URL 설계
> <b>정적 화면 설계</b>

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbOAGi1%2FbtrlDdMrw2l%2FRTSFtZV9nyteUFx2w7Fx80%2Fimg.png" alt="url_structure">

<br/>

> <b>동적 API 설계</b>
 
<b>1. User</b>
* 회원가입: /user/sign_up_for_submit (POST)
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fdersp9%2Fbtrk7EjA1rF%2FutoytQ21EpjNfBmjKW7jWK%2Fimg.png" alt="sign_up">   

* 로그인: /user/sign_in_check (POST)
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FrOZnD%2FbtrlbKXTLaL%2F1iI6r3MTaRNDzHkEJM8UQK%2Fimg.png" alt="sign_in">   

* 로그아웃: /user/sign_out
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbgHT99%2FbtrlnTtMcAo%2FRgU30nkpkZgdKRoTP8wO71%2Fimg.png" alt="sign_in">   

* 아이디 중복체크: /user/is_duplicated_id (GET)
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FchQRZB%2FbtrlsiMlHm9%2Fj4W8A9OBg7kChTEKWpUSi0%2Fimg.png" alt="duplicate_check">

<br/>
<b>2. Mission</b>  
 
* 미션 가입하기: /mission/join (POST)
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FSQIUx%2FbtrlqLutFWZ%2FLO0jEVoJJRle7kX9dgBLk1%2Fimg.png" alt="mission_join">   

* 미션 탈퇴하기: /mission/out (DELETE)
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbPfebi%2FbtrliMaThUV%2FUSgIZkA0mj9Mp8JmbhCUdk%2Fimg.png" alt="mission_out">   

<br/>
<b>3. Post   </b>  

*  글 올리기: /post/create (POST)
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbPfebi%2FbtrliMaThUV%2FUSgIZkA0mj9Mp8JmbhCUdk%2Fimg.png" alt="mission_out">   

*  글 수정하기:  /post/update (PUT)
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcEryRQ%2FbtrlhDrGSgu%2F2u0BXgXIBQov6NGta2sul0%2Fimg.png" alt="post_update">   

* 글 삭제하기: /post/delete (DELETE)
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fb3YgsG%2FbtrlqNy49QT%2Fhi5jLKS1vPC3IXFf02mCx1%2Fimg.png" alt="post_delete">   

* 좋아요 반영: /post/like_stauts (GET)
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbtmYvw%2FbtrlnS9wzgP%2FKICR4e68JSgnTDLr6k6Emk%2Fimg.png" alt="like">   

<br/>
<b>4. Comment</b>  

* 댓글 올리기: /comment/create (POST)
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FMCkRc%2FbtrlqBFpP5k%2FhpWh5ddp5MAcJu8milrqD1%2Fimg.png" alt="comment_create">  

* 댓글 삭제하기: /comment/delete (DELETE)
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbJybYo%2FbtrlpclPLPC%2FpO90HN8WgkK8zbkTm8lpVK%2Fimg.png" alt="comment_delete">

<br/>
<br/>
<br/>

### 4. 환경 구축
>Spring Boot로 프로그램을 설계하고 Apache Tomcat을 통해 웹 서버로 연결했습니다.

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcxA4wo%2FbtrlpVKUCiy%2FVupLCCxdXvdOKZukq0GHDK%2Fimg.png" alt="setting">

>MVC pattern을 통해 Model<->View(JSP)<->Controller가 상호작용하도록 처리했습니다.

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FMjNpH%2FbtrloyCFNcm%2Fh5KqEvlMxqErWJN7uebOZk%2Fimg.png" alt="mvc">

* JSP를 통해 View 화면 구축
* JavaScript를 통해 동적 화면 구축
* AJAX를 통해 Request 전달
* Controller -> Service (BO) -> Repositry (DAO) -> XML Mapper(MyBatis) -> DB(MySQL) 순으로 Request 처리, View로 Response 전달

<br/>

### 5. 배포
>AWS 배포 구조

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbzOWyb%2Fbtrloej8vta%2F5A2ByFkEx9i1nYXHWZBVCK%2Fimg.png" alt="release">  

* AWS 세팅

* PUTTY로 tomcat manager 설정 조정 (CLI)

* STS에서 war export
  - build.gradle의 plugins 항목에 id `war` 추가
  - Applicaton.java에서 SpringBootServletInitializer extends
  - 프로젝트 export

### 6. 트러블  슈팅
[개인 블로그](https://calm-lee.tistory.com/category/%EA%B0%9C%EB%B0%9C%20%EC%97%AC%EC%A0%95/Error) 및 [Git Issue 페이지](https://github.com/calm-lee/Mission_Everyday/issues?q=is%3Aissue+is%3Aclosed)에 프로젝트에서 발생하는 Error의 원인/해결방법을 기록했습니다.<br>
이런 기록들이 쌓이다보니, 나중에는 스스로 에러의 원인을 파악하고 해결책을 생각해내는 트러블 슈팅 능력을 기를 수 있었습니다.

### 7. 향후 추가할 만한 요소
1. 유저가 직접 미션 개설
2. 주 n회 포스팅 제한 기능
