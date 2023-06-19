<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js">
window.onload = function() {
	document
		.getElementById("addr")
		.addEventListener(
			"click",
			function() { //주소입력칸을 클릭하면
				//카카오 지도 발생
				new daum.Postcode(
					{
						oncomplete : function(data) { //선택시 입력값 세팅
							document.getElementById("userAddr").value = data.roadAddress; // 주소 넣기
							document.getElementById("userAddrPostal").value = data.zonecode; // 우편번호 넣기
							document.querySelector("input[name=userAddrDetail]")
									.focus(); //상세입력 포커싱
					}
				}).open();
		});
}
</script>

<div class="container">
	<form action="????????" method="POST">
		<h2>정 보 수 정</h2>
		<div class="user">
			<table class="user_table">
				<tr>
					<th class="text">아이디</th>
					<td>
						<input id="user_id" name="user_id" type="text" readonly>
					</td>
				</tr>
				
				<tr>
					<th class="text">비밀번호</th>
					<td>
						<input id="user_pw" name="user_pw" type="password">
					</td>
				</tr>
				
				<tr>
					<th class="text">비밀번호 확인</th>
					<td>
						<input id="user_confirmPw" name="user_confirmPw" type="password">
					</td>
				</tr><br>
				
				<tr>
					<th class="text">이름</th>
					<td>
						<input id="user_name" name="user_name" type="text" readonly>
					</td>
				</tr><br>

				<tr>
					<th class="text">주소</th>
					<td>
						<input id="userAddr" type="text" name="userAddr" readonly />
					</td>
					<td>
						<button type="button" class="postCode" onclick="execDaumPostcode()">주소입력</button>
					</td>
				</tr>
				
				<tr>
					<th class="text">상세 주소</th>
					<td>
						<input id="userAddrDetail" type="text" name="userAddrDetail" />
					</td>
				</tr>
				
				<tr>
					<th class="text">우편번호</th>
					<td>
						<input id="userAddrPostal" type="text" name="userAddrPostal" readonly />
					</td>
				</tr>

				<tr>
					<th class="gender">성별</th>
					<td>
						<input id="genderM" type="radio" name="genderM" value="M" readonly><label for="genderM">남자</label> 
						<input id="genderW" type="radio" name="genderW" value="W" readonly><label for="genderW">여자</label>
					</td>
				</tr>

				<tr>
					<th class="birth">생년월일</th>
					<td>
						<input class="birth_text1" type="text" maxlength="4" placeholder="ex)1900" readonly>&nbsp년&nbsp&nbsp&nbsp
						<input class="birth_text2" type="text" maxlength="2" placeholder="ex)01" readonly>&nbsp월&nbsp&nbsp&nbsp
						<input class="birth_text3" type="text" maxlength="2" placeholder="ex)01" readonly>&nbsp일
					</td>
				</tr>
			</table>
			
			<div type="submit" class="form-group">
				<a href="myPage" class="user_btn">수정하기</a>
			</div>
		</div>
	</form>
</div>