<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!DOCTYPE html>
<html lang="en">
<head>
<script src="resources/ckeditor/ckeditor.js"></script>
<script>
/* let ckeditor_config = {
		resize_enabled : false,
		enterMode : CKEDITOR.ENTER_BR,
		shiftEnterMode : CKEDITOR.ENTER_P,
		
}; */
	
function productRegi() {
  // CKEditor에서 입력한 내용을 가져옵니다.
  console.log("등록 버튼 눌렀습니다");
  let name = document.getElementById('productName');
  let price = document.getElementById('productPrice');
  let quantity = document.getElementById('productQuantity');
  
  let productContent = CKEDITOR.instances.productContent.getData();
  let productName = name.value;
  let productPrice = price.value;
  let productQuantity = quantity.value;
  let productImage = document.getElementById('productImage').files[0];
  
  console.log(" 이름 : " + productName);
  console.log(" 가격 : " + productPrice);
  console.log(" 수량 : " + productQuantity);
  console.log(" 내용 : " + productContent);
  
  // FormData 객체 생성
  let formData = new FormData();
  formData.append("productName", productName);
  formData.append("productPrice", productPrice);
  formData.append("productQuantity", productQuantity);
  formData.append("productContent", productContent);
  formData.append("file", productImage);

  // Ajax 요청을 보냅니다.
  $.ajax({
      url: "/adminProductInfo",
      type: "POST",
      data: formData,
      contentType: false,
      processData: false,
      success: function (data) {
          console.log(data);
      },
   	 	error : function(request,status,error) {
  	 	 	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
  	 	 	console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
  		}
  });
}
  
function count(type)  {
	console.log("count 들어옴");
  // 결과를 표시할 element
  const productQuantity = document.getElementById('productQuantity');
  
  // 현재 화면에 표시된 값
  let number = productQuantity.value;
  
  // 더하기/빼기
  if(type === 'quantityPlus') {
    number = parseInt(number) + 1;
  }else if(type === 'quantityMinus')  {
    number = parseInt(number) - 1;
    if(number == -1) {
    	number = 0;
    }
  }
  
  // 결과 출력
  productQuantity.value = number;
}
</script>
</head>
<body>
	  <h1> < 상 품 등 록 > </h1>

    <!-- The toolbar will be rendered in this container. -->
    <div id="productNameDiv">
    	<div>상품명</div>
    	<input id="productName" type="text">
    </div>
    
    <div id="productPriceDiv">
    	<div>상품가격</div>
    	<input id="productPrice" type="text">
    </div>
    
    <div id="productQuantityDiv">
    	<div>상품수량</div>
    	<input id="quantityMinus" type="button" onclick='count("quantityMinus")' value="-"/>
    	<input id="productQuantity" type="text" readonly="readonly" value="0"/>
			<input id="quantityPlus" type="button" onclick='count("quantityPlus")' value="+"/>
    </div>
	
	<div>상품내용</div>
	<textarea name="productContent" id="productContent"></textarea>
	<script>
		CKEDITOR.replace("productContent", {filebrowserUploadUrl : "adminProductImg"});	
	</script>
	<input type="button" value="등록" id="productRegiBtn" onclick="productRegi()">
	
</body>
</html>