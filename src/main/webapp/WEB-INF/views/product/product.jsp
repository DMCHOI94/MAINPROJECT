<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
// 빵
function breadList() {
	let first = $('#first');
	let second = $('#second');
	let third = $('#third');
	let fourth = $('#fourth');
	first.animate(
      {
          opacity: 1  // 반투명하게 설정
      }
  );
	second.animate(
      {
          opacity: 0.5  // 반투명하게 설정
      },
      500  // 애니메이션 지속 시간
  );
	third.animate(
      {
          opacity: 0.5  // 반투명하게 설정
      },
      500  // 애니메이션 지속 시간
  );
	fourth.animate(
      {
          opacity: 0.5  // 반투명하게 설정
      },
      500  // 애니메이션 지속 시간
  );
	
	let breadList = 
	`<div class="product2">
		<a class="first">
		<img class="img" src="/resources/img/arrow3.png" style="transform: scale(0.5); margin-top: -50px;">
		<div class="text">
		</div>
		</a>
		<a class="second">
		<div class="text">
		</div>
		</a>
		<a class="third">
		<div class="text">
		</div>
		</a>
		<a class="fourth">
		<div class="text">
		</div>
		</a>
	</div>
	<div class="product2" style="margin-top: 0;">
	<a href="bread1" class="first">
		<img class="img" src="/resources/img/bread1.png">
		<div class="text">
			<p class="text1">호밀식빵</p><br>
			<p class="text2">고소하고 부드러운 맛</p><br>
			<p class="text3">4,500원</p>
		</div>
	</a>

	<a href="bread2" class="second">
		<img class="img" src="/resources/img/bread2.png">
		<div class="text">
			<p class="text1">단호박식빵</p><br>
			<p class="text2">달콤한 호박 풍미가 입안 가득한 맛있는 빵</p><br>
			<p class="text3">5,100원</p>
		</div>
	</a>

	<a href="bread3" class="third">
		<img class="img" src="/resources/img/bread3.png">
		<div class="text">
			<p class="text1">바게트</p><br>
			<p class="text2">바삭하고 쫄깃한 식감의  <br>프랑스식 긴 빵으로 다양한<br>음식과 잘 어울리는 고소한 맛</p><br>
			<p class="text3">3,900원</p>
		</div>
	</a>
	
	<a href="bread4" class="fourth">
	<img class="img" src="/resources/img/bread4.png">
	<div class="text">
		<p class="text1">소라빵</p><br>
		<p class="text2">소라를 넣어 고소하고 감칠맛이 나는<br>해산물 풍미가 가미된 빵</p><br>
		<p class="text3">2,000원</p>
	</div>
	</a>
</div>
	
<div class="product2">
	<a href="bread5" class="fifth">
		<img class="img" src="/resources/img/bread5.png">
		<div class="text">
			<p class="text1">도넛</p><br>
			<p class="text2">달콤한 도넛로 다양한 맛과 토핑으로<br>즐길 수 있는 미국식 디저트</p><br>
			<p class="text3">1,800원</p>
		</div>
	</a>

	<a href="bread6" class="sixth">
		<img class="img" src="/resources/img/bread6.png">
		<div class="text">
			<p class="text1">마늘빵</p><br>
			<p class="text2">감칠맛 나는 마늘 풍미가 가미된 고소하고 향긋한 빵</p><br>
			<p class="text3">2,100원</p>
		</div>
	</a>
</div>`;

	$(".list").empty();
	$('.list').append(breadList);
}

// 디저트
function dessertList() {
	console.log('디저트');
	let first = $('#first');
	let second = $('#second');
	let third = $('#third');
	let fourth = $('#fourth');
	first.animate(
      {
          opacity: 0.5  // 반투명하게 설정
      },
      500  // 애니메이션 지속 시간
  );
	second.animate(
      {
          opacity: 1  // 반투명하게 설정
      },
  );
	third.animate(
      {
          opacity: 0.5  // 반투명하게 설정
      },
      500  // 애니메이션 지속 시간
  );
	fourth.animate(
      {
          opacity: 0.5  // 반투명하게 설정
      },
      500  // 애니메이션 지속 시간
  );
	
	let dessertList = 
		`<div class="product2">
		<a class="first">
		<div class="text">
		</div>
		</a>
		<a class="second">
		<img class="img" src="/resources/img/arrow3.png" style="transform: scale(0.5); margin-top: -50px;">
		<div class="text">
		</div>
		</a>
		<a class="third">
		<div class="text">
		</div>
		</a>
		<a class="fourth">
		<div class="text">
		</div>
		</a>
	</div>
	<div class="product2" style="margin-top: 0;">
	<a href="dessert2" class="second">
		<img class="img" src="/resources/img/dessert2.png">
		<div class="text">
			<p class="text1">마카롱</p><br>
			<p class="text2">아로마틱하고 향긋한 뚱카롱</p><br>
			<p class="text3">3,500원</p>
		</div>
	</a>
	
	<a href="dessert1" class="first">
	<img class="img" src="/resources/img/dessert1.png">
	<div class="text">
		<p class="text1">초코 머핀</p><br>
		<p class="text2">달콤한 초코가 듬뿍 들어간 초코 머핀</p><br>
		<p class="text3">3,300원</p>
	</div>
	</a>

	<a href="dessert3" class="third">
		<img class="img" src="/resources/img/dessert3.png">
		<div class="text">
			<p class="text1">조각 케익</p><br>
			<p class="text2">고급스러운 초콜릿과 신선한<br>딸기의 환상적인 만남</p><br>
			<p class="text3">4,900원</p>
		</div>
	</a>

	<a href="dessert4" class="fourth">
		<img class="img" src="/resources/img/dessert4.png">
		<div class="text">
			<p class="text1">파이 케익</p><br>
			<p class="text2">속은 부드럽고 겉은 바삭한 파이 크러스트와<br>함께 달콤한 딸기 필링의 조화로움</p><br>
			<p class="text3">6,000원</p>
		</div>
	</a>
</div>
	
<div class="product2">
	<a href="dessert5" class="fifth">
		<img class="img" src="/resources/img/dessert5.png">
		<div class="text">
			<p class="text1">푸딩</p><br>
			<p class="text2">싱그러운 망고의 상큼함과<br>달콤함이 입안에 퍼지는 푸딩</p><br>
			<p class="text3">3,400원</p>
		</div>
	</a>

	<a href="dessert6" class="sixth">
		<img class="img" src="/resources/img/dessert6.png">
		<div class="text">
			<p class="text1">주문제작 2단 케익</p><br>
			<p class="text2">부드럽고 촉촉한 케이크의 텍스처와 달콤한<br>딸기의 신선한 과즙을 선물해보세요</p><br>
			<p class="text3">22,500원</p>
		</div>
	</a>
</div>`;

	$(".list").empty();
	$('.list').append(dessertList);
}

// 잼
function jamList() {
	console.log('잼');
	let first = $('#first');
	let second = $('#second');
	let third = $('#third');
	let fourth = $('#fourth');
	first.animate(
      {
          opacity: 0.5  // 반투명하게 설정
      },
      500  // 애니메이션 지속 시간
  );
	second.animate(
      {
          opacity: 0.5  // 반투명하게 설정
      },
      500  // 애니메이션 지속 시간
  );
	third.animate(
      {
          opacity: 1  // 반투명하게 설정
      },
  );
	fourth.animate(
      {
          opacity: 0.5  // 반투명하게 설정
      },
      500  // 애니메이션 지속 시간
  );
	
	let jamList = 
		`<div class="product2">
		<a class="first">
		<div class="text">
		</div>
		</a>
		<a class="second">
		<div class="text">
		</div>
		</a>
		<a class="third">
		<img class="img" src="/resources/img/arrow3.png" style="transform: scale(0.5); margin-top: -50px;">
		<div class="text">
		</div>
		</a>
		<a class="fourth">
		<div class="text">
		</div>
		</a>
	</div>
	<div class="product2" style="margin-top: 0;">
	<a href="jam2" class="second">
		<img class="img" src="/resources/img/jam2.png">
		<div class="text">
			<p class="text1">수제 오렌지잼</p><br>
			<p class="text2">상큼한 오렌지 향과 달콤한 맛이<br> 입맛을 돋구는 수제 오렌지 잼</p><br>
			<p class="text3">7,400원</p>
		</div>
	</a>

	<a href="jam3" class="third">
		<img class="img" src="/resources/img/jam3.png">
		<div class="text">
			<p class="text1">수제 사과잼</p><br>
			<p class="text2">싱그러운 사과의 신선한 맛과 과즙이<br>입안에 퍼지는 수제 사과잼</p><br>
			<p class="text3">7,400원</p>
		</div>
	</a>
	
	<a href="jam1" class="first">
	<img class="img" src="/resources/img/jam1.png">
	<div class="text">
		<p class="text1">수제 초코잼</p><br>
		<p class="text2">진한 초콜릿 풍미와 달콤한 맛이 어우러져<br>입안에서 녹아내리는 수제 초코잼</p><br>
		<p class="text3">6,900원</p>
	</div>
	</a>

	<a href="jam4" class="fourth">
		<img class="img" src="/resources/img/jam4.png">
		<div class="text">
			<p class="text1">수제 포도잼</p><br>
			<p class="text2">은은한 포도 향과 달콤한 맛이<br>입맛을 사로잡는 수제 포도잼</p><br>
			<p class="text3">7,600원</p>
		</div>
	</a>
</div>
	
<div class="product2">
	<a href="jam5" class="fifth">
		<img class="img" src="/resources/img/jam5.png">
		<div class="text">
			<p class="text1">수제 체리잼</p><br>
			<p class="text2">풍부한 체리 풍미와 상큼한 맛이<br>입안에서 피어나는 수제 체리잼</p><br>
			<p class="text3">8,500원</p>
		</div>
	</a>

	<a href="jam6" class="sixth">
		<img class="img" src="/resources/img/jam6.png">
		<div class="text">
			<p class="text1">수제 딸기잼</p><br>
			<p class="text2">신선한 딸기의 달콤한 향과 맛이<br>입맛을 사로잡는 수제 딸기잼</p><br>
			<p class="text3">7,800원</p>
		</div>
	</a>
</div>`;

	$(".list").empty();
	$('.list').append(jamList);
}

function snackList() {
	console.log('스낵');
	let first = $('#first');
	let second = $('#second');
	let third = $('#third');
	let fourth = $('#fourth');
	first.animate(
      {
          opacity: 0.5  // 반투명하게 설정
      },
      500  // 애니메이션 지속 시간
  );
	second.animate(
      {
          opacity: 0.5  // 반투명하게 설정
      },
      500  // 애니메이션 지속 시간
  );
	third.animate(
      {
          opacity: 0.5  // 반투명하게 설정
      },
      500  // 애니메이션 지속 시간
  );
	fourth.animate(
      {
          opacity: 1  // 반투명하게 설정
      },
  );
	
	let snackList = 
		`<div class="product2">
		<a class="first">
		<div class="text">
		</div>
		</a>
		<a class="second">
		<div class="text">
		</div>
		</a>
		<a class="third">
		<div class="text">
		</div>
		</a>
		<a class="fourth">
		<img class="img" src="/resources/img/arrow3.png" style="transform: scale(0.5); margin-top: -50px;">
		<div class="text">
		</div>
		</a>
	</div>
	<div class="product2" style="margin-top: 0;">
	<a href="snack2" class="second">
		<img class="img" src="/resources/img/snack2.png">
		<div class="text">
			<p class="text1">담백한 쿠키</p><br>
			<p class="text2">달지 않고 바삭한 식감이 어우러진 담백한 쿠키</p><br>
			<p class="text3">3,200원</p>
		</div>
	</a>

	<a href="snack3" class="third">
		<img class="img" src="/resources/img/snack3.png">
		<div class="text">
			<p class="text1">프레즐</p><br>
			<p class="text2">고소하고 짭짤한 맛이 입맛을 돋구며 바삭한<br>텍스처로 씹을수록 매력을 더하는 프레즐</p><br>
			<p class="text3">3,400원</p>
		</div>
	</a>

	<a href="snack4" class="fourth">
		<img class="img" src="/resources/img/snack4.png">
		<div class="text">
			<p class="text1">딸기맛 사탕</p><br>
			<p class="text2">상큼한 딸기 향과 달콤한 맛이 입안<br>가득 퍼지는 딸기맛 사탕</p><br>
			<p class="text3">2,000원</p>
		</div>
	</a>
	
	<a href="snack1" class="first">
	<img class="img" src="/resources/img/snack1.png">
	<div class="text">
		<p class="text1">캐릭터 쿠키</p><br>
		<p class="text2">부드러운 쿠키 텍스처와 풍부한 초콜릿 맛이<br>어우러져 아이들에게 인기 있는 캐릭터 쿠키</p><br>
		<p class="text3">2,900원</p>
	</div>
	</a>
</div>
	
<div class="product2">
	<a href="snack5" class="fifth">
		<img class="img" src="/resources/img/snack5.png">
		<div class="text">
			<p class="text1">초코 쿠키</p><br>
			<p class="text2">풍부한 초콜릿 맛과 부드러운 쿠키의 조합으로<br>달콤한 미끄러움이 입안을 가득 채우는 초코 쿠키</p><br>
			<p class="text3">2,300원</p>
		</div>
	</a>

	<a href="snack6" class="sixth">
		<img class="img" src="/resources/img/snack6.png">
		<div class="text">
			<p class="text1">막대 사탕</p><br>
			<p class="text2">다양한 과일 풍미와 달콤한 맛이 막대<br>모양으로 즐겁게 녹아내리는 막대 사탕</p><br>
			<p class="text3">1,000원</p>
		</div>
	</a>
</div>`;

	$(".list").empty();
	$('.list').append(snackList);
}
</script>
<div class="container">
	<h2>원하시는 메뉴를 선택해주세요 </h2>
	<div class="product1">
		<a id="first" class="first" onclick="breadList()">
			<img class="img" src="/resources/img/bread1.png">
			<div class="text">
				<p class="text1">bread</p><br>
				<p class="text2">겉은 바삭하고 속은 촉촉한 빵</p>
			</div>
		</a>
	
		<a id="second" class="second" onclick="dessertList()">
			<img class="img" src="/resources/img/dessert1.png">
			<div class="text">
				<p class="text1">dessert</p><br>
				<p class="text2">달콤하고 부드러운 디저트</p>
			</div>
		</a>
	
		<a id="third" class="third" onclick="jamList()">
			<img class="img" src="/resources/img/jam1.png">
			<div class="text">
				<p class="text1">jam</p><br>
				<p class="text2">달콤하고 부드러운 잼</p>
			</div>
		</a>
	
		<a id="fourth" class="fourth" onclick="snackList()">
			<img class="img" src="/resources/img/snack1.png">
			<div class="text">
				<p class="text1">snack</p><br>
				<p class="text2">달콤하고 부드러운 스낵</p>
			</div>
		</a>
	</div>
	<div class="list">
		
	</div>
</div>