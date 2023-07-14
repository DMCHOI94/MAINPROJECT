<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container">
	<form action="" method="POST">
		<h2>마 이 페 이 지</h2>
		<div class="userPage">
			<div class="updatePage">
				<a href="update" class="update">
					<img class="img" src="/resources/img/mypage1.png"><br><br>
					<p class="text">정보수정</p>
				</a>
			</div>
			
			<div class="withdrawalPage">
				<a href="withdrawal" class="withdrawal">
					<img class="img" src="/resources/img/mypage2.png"><br><br>
					<p class="text">회원탈퇴</p>
				</a>
			</div>
		</div>
	</form>
</div>