<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container">
	<form action="" method="POST">
		<h2>고객님의 아이디 찾기가 완료 되었습니다.</h2>
		<div class="user">
			<table class="userTable">
				<tr>
					<th class="userId"><span>아이디</span> : ${findIdResult}</th>
				</tr>
			</table>
			<div type="submit" class="form-group">
				<a href="login" class="user_btn">확인</a>
			</div>
		</div>
	</form>
</div>