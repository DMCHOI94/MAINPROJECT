<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container">
	<form action="????????" method="POST">
		<h2>고객님의 비밀번호 찾기가 완료 되었습니다.</h2>
		<div class="user">
			<table class="user_table">
				<tr>
					<th class="text">비밀번호</th>
					<td>
						<input id="user_pw" name="user_pw" type="text" readonly>
					</td>
				</tr>
				
				<tr>
					<th class="text">비밀번호</th>
					<td>
						<input id="user_name" name="user_name" type="text" readonly>
					</td>
				</tr>
				
				<tr>
					<th class="birth">생년월일</th>
					<td>
						<select id="year" disabled="disabled">
							<option>----</option>
						</select>&nbsp년&nbsp&nbsp&nbsp
						<select id="month" disabled="disabled">
							<option>--</option>
						</select>&nbsp월&nbsp&nbsp&nbsp
						<select id="day" disabled="disabled">
							<option>--</option>
						</select>&nbsp일
					</td>
				</tr>
			</table>
			
			<div type="submit" class="form-group">
				<a href="login" class="user_btn">확인</a>
			</div>
		</div>
	</form>
</div>