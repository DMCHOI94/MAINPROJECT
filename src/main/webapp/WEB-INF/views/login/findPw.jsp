<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container">
	<form action="????????" method="POST">
		<h2>비 밀 번 호 찾 기</h2>
		<div class="user">
			<table class="user_table">
				<tr>
					<th class="text">아이디</th>
					<td>
						<input id="user_id" name="user_id" type="text">
					</td>
				</tr>
				
				<tr>
					<th class="text">이름</th>
					<td>
						<input id="user_name" name="user_name" type="text">
					</td>
				</tr>
				
				<tr>
					<th class="birth">생년월일</th>
					<td>
						<select id="year">
							<option>----</option>
						</select>&nbsp년&nbsp&nbsp&nbsp
						<select id="month">
							<option>--</option>
						</select>&nbsp월&nbsp&nbsp&nbsp
						<select id="day">
							<option>--</option>
						</select>&nbsp일
					</td>
				</tr>
			</table>
			
			<div type="submit" class="form-group">
				<a href="findPwConfirm" class="user_btn">확인</a>
			</div>
		</div>
	</form>
</div>