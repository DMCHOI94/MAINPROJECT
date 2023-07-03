<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
//페이지 로드 시 adminUserInfo 함수를 실행하여 초기 데이터를 가져옵니다.
/* $(document).ready(function() {
  adminUserInfo();
}); */

function adminUserInfo() {
	alert("함수들어옴");
	$.ajax({
		type : 'POST',
		url : '/adminUserInfo',
		success: function(data) {
			console.log(data);
      if (data) {
      	console.log('ajax 안의 data : ' + data);
          let userList = JSON.parse(data);
          console.log('userList : ' + userList);
          
          // tbody 내용을 지운다
          console.log($("#userTable"));
					$("#userTable").empty();
          console.log('$("#userTable")' + $("#userTable"));
          
          let row = "";
          let table = document.getElementById("userTable");
          console.log("table : " + table);
          
       		// userList를 순회하며 tbody에 행을 추가합니다.
          for (let i = 0; i < userList.length; i++) {
          	let user = userList[i];
          	let selBox = '<input id="userCheck" type="checkbox">';
          	let userSeq = user.userSeq;
          	let userId = user.userId;
          	let userPw = user.userPw;
          	let userName = user.userName;
          	let userAddrPostal = user.userAddrPostal;
          	let userAddr = user.userAddr;
          	let userAddrDetail = user.userAddrDetail;
          	let userGender = user.userGender;
          	let userBirth = user.userBirth;
          	let useYN = user.useYN;
          	let adminYN = user.adminYN;
          	let btn = '<button id="userPList" onclick="userPList()">내역조회</button>';
          	let tr = "<tr>";
          	let tr_ = "</tr>";
          	let td = "<td>";
          	let td_ = "</td>";
          	console.log('userList[i] : ' + userList[i]);
              
              console.log('user : ' + user);
              row = 
              		tr + 
              		td + selBox + td_ +  
              		td + userSeq + td_ +
              		td + userId + td_ +
              		td + userPw + td_ +
              		td + userName + td_ +
              		td + userAddrPostal + td_ +
              		td + userAddr + td_ +
              		td + userAddrDetail + td_ +
                  td + userGender + td_ +
                  td + userBirth + td_ +
                  td + useYN + td_ +
                  td + adminYN + td_ +
                  td + btn + tr_;    
              console.log("row : " + row);
              $('#userTable').append(row);
              // document.getElementById("#userTable").innerHTML = row;
          }
          
          
          // table.innerHTML += row;
       		
          
       		
          alert("정보조회 성공");
      } else {
          alert("정보가 일치하지 않습니다.");
      }
  	},
 	 	error : function(request,status,error) {
 	 	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
 	 	console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
}

function userPList() {
	alert("내역조회 버튼누름");
	
}
</script>
<!DOCTYPE html>
<html lang="kor">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="resources/bootstrap/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="resources/bootstrap/js/scripts.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="resources/bootstrap/js/datatables-simple-demo.js"></script>
    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="adminMain">sikppang2 관리자 페이지</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#!">로그아웃</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">회원관리</div>
                            <a class="nav-link" href="adminUser">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                회원관리
                            </a>
                            <div class="sb-sidenav-menu-heading">상품관리</div>
                            <a class="nav-link" href="adminProduct">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                상품관리
                            </a>
                            <div class="sb-sidenav-menu-heading">게시판관리</div>
                            <a class="nav-link" href="adminBoard">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                게시판관리
                            </a>
                        </div>
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">회원관리</h1>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                회원 정보&nbsp;&nbsp;<button onclick="adminUserInfo()" style="width: 55px;" type="button">정보조회</button>&nbsp;
                                <button onclick="adminUserDel()" style="width: 55px;" type="button">정보삭제</button>&nbsp;
                            </div>
                            
                            <div class="card-body">
                                <table id="datatablesSimple">
                                    <thead>
                                        <tr>
                                        		<th>선택</th>
                                            <th>순서</th>
                                            <th>아이디</th>
                                            <th>비밀번호</th>
                                            <th>이름</th>
                                            <th>우편번호</th>
                                            <th>주소</th>
                                            <th>상세주소</th>
                                            <th>성별</th>
                                            <th>생년월일</th>
                                            <th>회원탈퇴여부</th>
                                            <th>관리자계정</th>
                                            <th>구매내역</th>
                                        </tr>
                                    </thead>
                                    <tbody id="userTable">
                                    	<%-- <c:forEach items="${userList}" var="user" varStatus="status">
																			  <tr>
																			    <td>${status.index + 1}</td>
																			    <td>${user.userId}</td>
																			    <td>${user.userPw}</td>
																			    <td>${user.userName}</td>
																			    <td>${user.userAddrPostal}</td>
																			    <td>${user.userAddr}</td>
																			    <td>${user.userAddrDetail}</td>
																			    <td>${user.userGender}</td>
																			    <td>${user.userBirth}</td>
																			    <td>${user.useYN}</td>
																			    <td>${user.adminYN}</td>
																			    <td><button onclick="userPList()">내역조회</button></td>
																			  </tr>
																			</c:forEach> --%>
		                                    <tr>
                                       		 <th>1</th>
                                           <th>2</th>
                                           <th>3</th>
                                           <th>4</th>
                                           <th>5</th>
                                           <th>6</th>
                                           <th>7</th>
                                           <th>8</th>
                                           <th>9</th>
                                           <th>1</th>
                                           <th>2</th>
                                           <th>2</th>
                                           <th>3</th>
                                       </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted"></div>
                            <div>
                                <a href="#"></a>
                                <a href="#"></a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
    </body>
</html>
