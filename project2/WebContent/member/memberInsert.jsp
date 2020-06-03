<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style>
body, div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, 
pre, form, fieldset, input, textarea, p, blockquote, th, td { 
  padding:0;
  margin:0;}

fieldset, img {border:0}

ol, ul, li {list-style:none}

:focus {outline:none}

body,
input,
textarea,
select {
  font-family: 'Open Sans', sans-serif;
  font-size: 16px;
  color: #4c4c4c;
}

p {
  font-size: 12px;
  width: 150px;
  display: inline-block;
  margin-left: 18px;
}
h1 {
  font-size: 32px;
  font-weight: 300;
  color: #4c4c4c;
  text-align: center;
  padding-top: 10px;
  margin-bottom: 10px;
}

html{
  background-color: #ffffff;
}

.testbox {
  margin: 20px auto;
  width: 343px; 
  height: 464px; 
  -webkit-border-radius: 8px/7px; 
  -moz-border-radius: 8px/7px; 
  border-radius: 8px/7px; 
  background-color: #ebebeb; 
  -webkit-box-shadow: 1px 2px 5px rgba(0,0,0,.31); 
  -moz-box-shadow: 1px 2px 5px rgba(0,0,0,.31); 
  box-shadow: 1px 2px 5px rgba(0,0,0,.31); 
  border: solid 1px #cbc9c9;
}

input[type=radio] {
  visibility: hidden;
}

form{
  margin: 0 30px;
}

label.radio {
	cursor: pointer;
  text-indent: 35px;
  overflow: visible;
  display: inline-block;
  position: relative;
  margin-bottom: 15px;
}

label.radio:before {
  background: #3a57af;
  content:'';
  position: absolute;
  top:2px;
  left: 0;
  width: 20px;
  height: 20px;
  border-radius: 100%;
}

label.radio:after {
	opacity: 0;
	content: '';
	position: absolute;
	width: 0.5em;
	height: 0.25em;
	background: transparent;
	top: 7.5px;
	left: 4.5px;
	border: 3px solid #ffffff;
	border-top: none;
	border-right: none;

	-webkit-transform: rotate(-45deg);
	-moz-transform: rotate(-45deg);
	-o-transform: rotate(-45deg);
	-ms-transform: rotate(-45deg);
	transform: rotate(-45deg);
}

input[type=radio]:checked + label:after {
	opacity: 1;
}

hr{
  color: #a9a9a9;
  opacity: 0.3;
}

input[type=text],input[type=password]{
  width: 200px; 
  height: 39px; 
  -webkit-border-radius: 0px 4px 4px 0px/5px 5px 4px 4px; 
  -moz-border-radius: 0px 4px 4px 0px/0px 0px 4px 4px; 
  border-radius: 0px 4px 4px 0px/5px 5px 4px 4px; 
  background-color: #fff; 
  -webkit-box-shadow: 1px 2px 5px rgba(0,0,0,.09); 
  -moz-box-shadow: 1px 2px 5px rgba(0,0,0,.09); 
  box-shadow: 1px 2px 5px rgba(0,0,0,.09); 
  border: solid 1px #cbc9c9;
  margin-left: -5px;
  margin-top: 13px; 
  padding-left: 10px;
}

input[type=password]{
  margin-bottom: 25px;
}

#icon {
  display: inline-block;
  width: 30px;
  background-color: #3a57af;
  padding: 8px 0px 8px 15px;
  margin-left: 15px;
  -webkit-border-radius: 4px 0px 0px 4px; 
  -moz-border-radius: 4px 0px 0px 4px; 
  border-radius: 4px 0px 0px 4px;
  color: white;
  -webkit-box-shadow: 1px 2px 5px rgba(0,0,0,.09);
  -moz-box-shadow: 1px 2px 5px rgba(0,0,0,.09); 
  box-shadow: 1px 2px 5px rgba(0,0,0,.09); 
  border: solid 0px #cbc9c9;
}

.gender {
  margin-left: 30px;
  margin-bottom: 30px;
}

.accounttype{
  margin-left: 8px;
  margin-top: 20px;
}

a.button {
  font-size: 14px;
  font-weight: 600;
  color: white;
  padding: 6px 25px 0px 20px;
  margin: 10px 8px 20px 0px;
  display: inline-block;
  float: right;
  text-decoration: none;
  width: 50px; height: 27px; 
  -webkit-border-radius: 5px; 
  -moz-border-radius: 5px; 
  border-radius: 5px; 
  background-color: #3a57af; 
  -webkit-box-shadow: 0 3px rgba(58,87,175,.75); 
  -moz-box-shadow: 0 3px rgba(58,87,175,.75); 
  box-shadow: 0 3px rgba(58,87,175,.75);
  transition: all 0.1s linear 0s; 
  top: 0px;
  position: relative;
}

a.button:hover {
  top: 3px;
  background-color:#2e458b;
  -webkit-box-shadow: none; 
  -moz-box-shadow: none; 
  box-shadow: none;
  
}


</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
	function idDupCheck() {
		//1. xhr 객체 생성
		var xhttp = new XMLHttpRequest();

		//2.콜백 함수 지정 (변경 될 때 실행 this = xhttp의 객체를 가리킴 응답 결과 :responseText)
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4) { //응답완료
				if (this.status == 200) { //정상실행
					console.log("ajax 요청 완료")
					document.getElementById("result").innerHTML = this.responseText; // <span id = "result">여기에 inner를 출력</span><br/>
				} else {
					document.getElementById("result").innerHTML = this.status
							+ this.statusText
				}

			} else {
				//로딩중
				document.getElementById("result").innerHTML = "로딩중";
			}

		};
		//3.서버연결(url을 적어주게 된다."ajax_info.txt" ) 
		//param 공백 주의
		var param = "id=" + document.frm.id.value;
		xhttp.open("POST", "IdDupCheck.do?", true);//비동기여부 자리 , false(동기) ,true(비동기식)(순차적) 호출 -> 결과처리
		xhttp.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		/* xhttp.open("GET", "../IdDupCheck.do?"+param, true); */
		//4.서버 전송
		xhttp.send(param);
		/* xhttp.send(); */
		console.log("ajax 요청 시작")
	}

	function memberCheck() {
		/* if(frm.id.value =="admin"){
		alert("admin이 들어간 아이디 사용 불가");
		frm.id.focus(); */
		//필수입력 체크
		var id = document.getElementById('id'); // input type text id >> dd
		var admin = "admin";
		if (id.value.includes(admin)) {
			alert('admin을 포함할수없음');

			return;
		}
		if (frm.id.value == "") { //trim함수
			alert("아이디 입력");
			frm.id.focus();
			return;
		}

		if (frm.pwd.value == "") {
			alert("패스워드 입력");
			frm.pwd.focus();
			return;
		}
		if (frm.name.value == "") {
			alert("이름 입력");
			frm.name.focus();
			return;
		}
		if (frm.age.value == "") {
			alert("나이 입력");
			frm.age.focus();
			return;
		}
		//성별
		gender = document.getElementsByName("gender");
		cnt = 0;
		for (i = 0; i < gender.length; i++) {
			if (gender[i].checked == true) {
				cnt++;
			}
		}
		if (confirm("회원가입을 하시겠습니까?")) {

			frm.submit();
			alert(frm.id.value + "님, 회원가입을 환영합니다!");
		}

	}
</script>

<body>
	<div align="center">
		<div>
			<h1>회원 가입</h1>
		</div>
		<div></div>
	<div class="testbox">
		<div>

			<span id="result"></span><br>
			<form action="MemberInsert.do" Method="post" name="frm">
				<input type="text" name="id" id="id" placeholder="아이디"
					onchange="idDupCheck()"/>
				<input type="password" name="pwd" id="pwd" placeholder="비밀번호" /><br>
				<input type="password" name="pwd2" id="pwd2" placeholder="비밀번호 확인" /><br>
				<input type="text" name="name" id="name" placeholder="이름" /><br>
				<input type="text" name="age" id="age" placeholder="나이" /><br>
				<input type="text" name="phone" id="phone" placeholder="전화번호">		
				<br>		
				<button type="button" onclick="memberCheck()">회원가입</button>
				 <a href="MemberInsert.do" class="button">가입</a>
			</form>
		</div>
	</div>

</body>



</html>