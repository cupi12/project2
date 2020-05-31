<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
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
		if (cnt == 0) {
			alert("성별 선택");
			return;
		}
		if (confirm("회원가입을 하시겠습니까?")) {

			frm.submit();
			alert(frm.id.value + "님, 회원가입을 환영합니다!");
		}

	}
</script>
</head>
<jsp:include page="/common/template/header.jsp" />
<body>

	<div align="center">
		<div>
			<h1>회원 가입</h1>
		</div>
		<div></div>

		<div>

			<span id="result"></span><br>
			<form action="MemberInsert.do" Method="post" name="frm">
				<input type="text" name="id" id="id" placeholder="아이디"
					onchange="idDupCheck()"><br>
				<input type="password" name="pwd" id="pwd" placeholder="비밀번호" /><br>
				<input type="password" name="pwd2" id="pwd2" placeholder="비밀번호 확인" /><br>
				<input type="text" name="name" id="name" placeholder="이름" /><br>
				<input type="text" name="age" id="age" placeholder="나이" /><br>
				<input type="text" name="phone" id="phone" placeholder="전화번호"><br>
				성별:<input type="radio" name="gender" value="남">남자 <input
					type="radio" name="gender" value="여"> 여자<br> <span></span>
				<br>
				<button type="button" onclick="memberCheck()">회원가입</button>
				<input type="reset" value="지우기" />
			</form>
		</div>
	</div>

</body>

<jsp:include page="/common/template/footer.jsp" />
</html>