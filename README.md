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

<b>3. 수행 역할</b><br>
* 기획서 작성
* 프로젝트 일정표 작성
* DB 설계, URL 및 API 설계
* 프로젝트 개발환경 구축
* 프론트엔드 
  - 페이지 UI 디자인 및 구현
* 백엔드
  - 로그인/회원가입 기능 구현
  - 메인 홈, 카테고리 페이지, 미션클럽 페이지 구현
  - 미션 가입/탈퇴 구현
  - 포스팅 업로드/수정/삭제 구현
  - 댓글 업로드/삭제 구현
  - 좋아요 생성/해제 구현
  - 마이페이지 마이 미션클럽 조회 기능 구현 
  - 마이페이지 마이 포스트 조회 기능 구현
  - 마이페이지 내 인증 현황 조회 기능 구현
* 트러블슈팅
* 동작 테스트
* AWS 서버 구축

<b>4. 미션!에브리데이 주요 기능</b>
* 운동, 공부, 외국어, 재테크, 취미, 다이어트 등 다양한 카테고리의 미션 가입
* 1주, 2주 단위의 미션에 매일 인증 포스트 올리기
* 마이페이지에서 인증현황 확인 가능
* 좋아요, 댓글달기 등을 통해 친목도모 가능

<b>5. 사용 기술 스택</b>
* Java, JavaScript, jQuery, Bootstrap, HTML, CSS
* Spring 4.11, Apache Tomcat 9.0, Mybatis, MySQL
* MVC Pattern, Ajax
* Git, AWS

## 사용방법

### 1. 회원가입 & 로그인
> ID, PW, 이메일 기입 후 가입 가능합니다. (아이디 중복확인 필수)
<img src="https://blog.kakaocdn.net/dn/bihAbt/btrg2UXSK0c/Y5KNqtmj8FZKCSW2Q2XV9K/img.gif" alt="user">

### 2. 카테고리 & 미션 페이지
> 운동, 공부, 외국어, 다이어트, 취미, 재테크 등 다양한 카테고리의 미션들을 확인할 수 있습니다.
<img src="https://blog.kakaocdn.net/dn/6hMCi/btrg6vi7D5m/GR4H5C1dg9dKNzyu1OM9H1/img.gif" alt="category&mission">

### 3. 미션클럽 페이지
> 미션에 가입해 포스트를 올리고, 좋아요&댓글달기가 가능합니다.
<img src="https://blog.kakaocdn.net/dn/uQ017/btrg4KHCOL7/KlpwX0t1dZWwkFoWuVuJFk/img.gif" alt="post">

### 4-1. 마이 페이지 - 내가 참여한 미션 확인하기
> 내가 참여 중인 미션과 가입일을 확인할 수 있습니다.
<img src="https://blog.kakaocdn.net/dn/t1JY5/btrg10dCx5p/RYAZxoyHPrwk0QNeDVeEx0/img.gif" alt="myMission">

### 4-2. 마이 페이지 - 내가 인증한 포스트 확인하기
> 내가 올린 포스트를 한눈에 확인할 수 있습니다.
<img src="https://blog.kakaocdn.net/dn/cM7yPW/btrg7WUQxkh/0HmdMXc1YQtjWkAvw0Dyk1/img.gif" alt="myPost">

### 4-3. 마이 페이지 - 내 인증현황 확인하기
> 미션별로 내 인증현황을 확인할 수 있습니다. (성공/실패/남은 일수)
<img src="https://blog.kakaocdn.net/dn/cvjdIz/btrg2UDE6oe/8mkEgc0a0m0UnC7sHulUO1/img.gif" alt="myPostStatus">


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
 
### 3. URL 설계
> 정적 화면 설계
* 로그인: user/sign_in_view
* 회원가입: user/sign_up_view
* 메인 홈: mission/main
* 카테고리 상세 페이지: mission/category/[categoryId]
* 미션클럽 페이지: mission/mission_club/[missionId]
* 마이페이지 - 참여 중인 미션: my/mission
* 마이페이지 - 내가 올린 포스트: my/post
* 마이페이지 - 인증 현황: my/status
* 마이페이지 - 인증 현황 상세: my/status/[missionId]
> 동적 API 설계
1. User
* 회원가입: /user/sign_up_for_submit
* 로그인: /user/sign_in_check
* 로그아웃: /user/sign_out
* 아이디 중복체크: /user/is_duplicated_id

2. Mission
* 미션 가입하기: /mission/join
* 미션 탈퇴하기: /mission/out

3. Post
* 글 올리기: /post/create
* 글 수정하기:  /post/update
* 글 삭제하기: /post/delete
* 좋아요 반영: /post/like_stauts

4. Comment
* 댓글 올리기: /comment/create
* 댓글 삭제하기: /comment/delete

### 4. 트러블  슈팅
[개인 블로그](https://calm-lee.tistory.com/category/%EA%B0%9C%EB%B0%9C%20%EC%97%AC%EC%A0%95/Error) 및 [Git Issue 페이지](https://github.com/calm-lee/Mission_Everyday/issues)에 프로젝트에서 발생하는 Error의 원인/해결방법을 기록했습니다.<br>
이런 기록들이 쌓이다보니, 나중에는 스스로 에러의 원인을 파악하고 해결책을 생각해내는 트러블 슈팅 능력을 기를 수 있었습니다.

### 5. 향후 추가할 만한 요소
1. 유저가 직접 미션 개설
2. 주 n회 포스팅 제한 기능
