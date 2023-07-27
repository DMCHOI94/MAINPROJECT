<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!DOCTYPE html>
<html lang="en">
<head>
<script src="resources/ckeditor/ckeditor.js"></script>
<script>
let ckeditor_config = {
		resize_enabled : false,
		enterMode : CKEDITOR.ENTER_BR,
		shiftEnterMode : CKEDITOR.ENTER_P,
		filebrowserUploadUrl : "adminProductImg"
};
	
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
  // let productImageInput = document.getElementById('productImage');
  
  if(productName == null) {
  	alert("상품명을 입력해주세요");
  	return false;
  }
  if(productPrice == null) {
  	alert("상품가격을 입력해주세요");
  	return false;
  }
  if(productQuantity == null) {
  	alert("상품수량를 입력해주세요");
  	return false;
  }
  if(productContent == null) {
  	alert("내용을 입력해주세요");
  	return false;
  }
  let pattern = /src="([^"]+)"/g;
	let results = productContent.match(pattern);
  let filePathAndName = '';
  let fileNames = [];
  let filePaths = [];
 	if(results) {
 	  for (let i = 0; i < results.length; i++) {
 	    filePathAndName = results[i].match(/src="([^"]+)"/)[1];
 	    fileName = filePathAndName.substring(filePathAndName.lastIndexOf("/") + 1);
 	    filePath = filePathAndName.substring(0, filePathAndName.lastIndexOf("/") + 1);
 	    console.log("파일 경로 " + (i + 1) + ": " + filePath);
 	    console.log("파일 이름 " + (i + 1) + ": " + fileName);
 	    filePaths.push(filePath);
 	    fileNames.push(fileName);
  	}
  }
  
  console.log(" 이름 : " + productName);
  console.log(" 가격 : " + productPrice);
  console.log(" 수량 : " + productQuantity);
  console.log(" 내용 : " + productContent);
  console.log(" 경로 : " + filePaths);
  console.log(" 이름 : " + fileNames);
  // console.log(" 이미지 : " + productImage);
  
/*   // FileReader 객체 생성
  let reader = new FileReader();

  // 파일 읽기 완료 시 호출되는 이벤트 핸들러
  reader.onload = function(event) {
    let productImage = event.target.result; */
  
  // FormData 객체 생성
  let formData = new FormData();
  formData.append("productName", productName);
  formData.append("productPrice", productPrice);
  formData.append("productQuantity", productQuantity);
  formData.append("productContent", productContent);
  formData.append("fileName", filePaths);
  formData.append("filePath", fileNames);
  // formData.append("productImage", productImage);

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
	console.log("에디터 버전 : " + CKEDITOR.version);
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
		CKEDITOR.replace("productContent", ckeditor_config);	
	</script>
	<input type="button" value="등록" id="productRegiBtn" onclick="productRegi()">
	
</body>
</html>