<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
$(document).ready(function() {
	const swiper = new Swiper('.swiper', {
		// If we need pagination
		pagination : {
			el : '.swiper-pagination',
		},

		autoplay : {
			delay : 3000, // 2초 후에 슬라이드 넘김
		},
		loop : true, // 무한 재생

		// Navigation arrows
		navigation : {
			nextEl : '.swiper-button-next',
			prevEl : '.swiper-button-prev',
		},
	});
});

</script>
<div class="container">
	<!-- Slider main container -->
	<div class="swiper">
		<!-- Additional required wrapper -->
		<div class="swiper-wrapper">
			<!-- Slides -->
			<div class="swiper-slide">
				<a href="#">
					<div class="number">1 / 6</div>
					<img src="/resources/img/banner1.png">
					<div class="text">[추천] 식빵의 부드러움과 고소함, 건강한 맛을 만나보세요!</div>
				</a>
			</div>
				
			<div class="swiper-slide">
				<a href="#">
					<div class="number">2 / 6</div>
					<img src="/resources/img/banner2.png">
					<div class="text">[신메뉴] 진짜 마늘의 풍미를 느껴보세요. 007빵의 새로운 신메뉴!</div>
				</a>
			</div>
				
			<div class="swiper-slide">
				<a href="#">
					<div class="number">3 / 6</div>
					<img src="/resources/img/banner3.png">
					<div class="text">달콤한 초코머핀으로 당신의 아침을 기분좋게 시작해보세요 :)</div>
				</a>
			</div>
				
			<div class="swiper-slide">
				<a href="#">
					<div class="number">4 / 6</div>
					<img src="/resources/img/banner4.png">
					<div class="text">마카롱의 매력적인 색과 맛을 한 번에 만나보세요, 완벽한 디저트!</div>
				</a>
			</div>
				
			<div class="swiper-slide">
				<a href="#">
					<div class="number">5 / 6</div> 
					<img src="/resources/img/banner5.png">
					<div class="text">상큼한 오렌지잼이 빵과 어울리는 맛의 조합, 매일의 일상에 활력을 더해줍니다.</div>
				</a>
			</div>
				
			<div class="swiper-slide">
				<a href="#">
					<div class="number">6 / 6</div> 
					<img	src="/resources/img/banner6.png">
					<div class="text">딸기잼의 달콤함이 느껴지는, 건강하고 맛있는 딸기잼을 즐겨보세요!</div>
				</a>
			</div>
		</div>
			
		<!-- If we need pagination -->
		<div class="swiper-pagination"></div>
		
		<!-- If we need navigation buttons -->
		<div class="swiper-button-prev"></div>
		<div class="swiper-button-next"></div>

		<!-- If we need scrollbar -->
		<div class="swiper-scrollbar"></div>
	</div> <br><br>

	<!-- content2 -->
	<div class="content2">
			<img class="img1" src="/resources/img/content2_1.png">
			<img class="img2" src="/resources/img/content3.png">
	</div><br>
</div>