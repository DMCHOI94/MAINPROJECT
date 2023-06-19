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
					<div class="text">[추천] 지친 당신을 위한 달콤함 한조각</div>
				</a>
			</div>
				
			<div class="swiper-slide">
				<a href="#">
					<div class="number">2 / 6</div>
					<img src="/resources/img/banner2.png">
					<div class="text">222</div>
				</a>
			</div>
				
			<div class="swiper-slide">
				<a href="#">
					<div class="number">3 / 6</div>
					<img src="/resources/img/banner3.png">
					<div class="text">333</div>
				</a>
			</div>
				
			<div class="swiper-slide">
				<a href="#">
					<div class="number">4 / 6</div>
					<img src="/resources/img/banner4.png">
					<div class="text">444</div>
				</a>
			</div>
				
			<div class="swiper-slide">
				<a href="#">
					<div class="number">5 / 6</div> 
					<img src="/resources/img/banner5.png">
					<div class="text">555</div>
				</a>
			</div>
				
			<div class="swiper-slide">
				<a href="#">
					<div class="number">6 / 6</div> 
					<img	src="/resources/img/banner6.png">
					<div class="text">666</div>
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
</body>