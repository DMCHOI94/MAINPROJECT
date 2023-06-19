<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container">
	<div class="productDetail">
		<img class="img" src="/resources/img/bread1.png">
		<div class="text">
			<p class="text1">호밀식빵</p>
			<p class="text3">판매가 : 4,500원</p>
			<div class="text">
				<label for="selectMenu">수량</label>
				<select>
					<option value="" selected>- [필수]옵션을 선택해 주세요 -</option>
					<option value="1">1ea</option>
					<option value="2">2ea</option>
					<option value="3">3ea</option>
					<option value="4">4ea</option>
					<option value="5">5ea</option>
					<option value="6">6ea</option>
					<option value="7">7ea</option>
				</select>
				
				<button class="btn1">구매하기<span>♡</span></button>
				<button class="btn2">장바구니<span>♡</span></button>
				<button class="btn3">관심상품<span>♡</span></button>
			</div>
		</div>

		<main>
			<div class="mainbutton">
				<button class="btn01"><a href="#">배송관련</a></button>
				<button class="btn02"><a href="#">결제관련</a></button>
				<button class="btn03"><a href="#">구매정보</a></button>
				<button class="btn04"><a href="#">상품후기</a></button>
				<button class="btn05"><a href="#">상품문의</a></button>
			</div>

			<section class="maintext">
				<div class="img01"><img src="/img/sidepage11.png"></div>
				<div class="img02"><img src="/img/sidepage17.jpg"></div>
				<div class="img03"><img src="/img/sidepage16.jpg"></div>
				<div class="img04"><img src="/img/sidepage13.png"></div>

				<button class="more">
					<a href="#">더 보 기 👇</a>
				</button>
			</section>
		</main>
	</div>
</div>