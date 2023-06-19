<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 제이쿼리 CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- swiper -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
<script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>
<!-- 내가 만든 css, js 경로 -->
<link href="/resources/css/userCommon.css" rel="stylesheet" type="text/css">
<link
	href="https://hangeul.pstatic.net/hangeul_static/css/nanum-square-round.css"
	rel="stylesheet">
</head>

<body>
	<div class="container">
		<!-- header -->
		<div class="header">
			<div class="menu">
				<c:choose>
    			<c:when test="${loggedIn}">
	    		</c:when>
	    		<c:otherwise>
	        	<!-- 로그아웃 상태일 때 -->
	        	<a href="join">회원가입</a>
	    		</c:otherwise>
				</c:choose>
			</div>
			<div class="menu">
				<c:choose>
    			<c:when test="${loggedIn}">
	        	<!-- 로그인 상태일 때 -->
	        	<a href="logout">로그아웃</a>
	    		</c:when>
	    		<c:otherwise>
	        	<!-- 로그아웃 상태일 때 -->
	        	<a href="login">로그인</a>
	    		</c:otherwise>
				</c:choose>
			</div>
			<div class="menu">
				<c:choose>
    			<c:when test="${loggedIn}">
	        	<!-- 로그인 상태일 때 -->
	        	<a href="myPage">마이페이지</a>
	    		</c:when>
	    		<c:otherwise>
	    		</c:otherwise>
				</c:choose>
			</div>
		</div>
		<hr>

		<!-- nav -->
		<div class="nav">
			<div class="img">
				<a href="/"> <img class="logo" src="/resources/img/logo.png">
				</a>
			</div>
			<div class="menu">
				<a href="product">빵보러가기</a> <a href="/">게시판</a>
			</div>
		</div>
		<hr style="margin-bottom: 50px;">
	</div>
</body>
</html>