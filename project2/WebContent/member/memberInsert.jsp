<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<script>
	function memberCheck() {
		//필수입력 체크
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
		}

	}//end of idValidCheck
	

</script>
</head>
<jsp:include page="/common/template/header.jsp" />
<body>

	<div align="center">
		<div>
			<h1>회원 가입</h1>
		</div>
		<div>
		
		</div> 

		<div>
			
			<span id="result"></span><br>
			<form action="MemberInsert.do" Method="post" name="frm">
				<input type="text" name="id" id="id" placeholder="아이디"><br>
				<input type="password" name="pwd" id="pwd" placeholder="비밀번호" /><br>
				<input type="password" name="pwd2" id="pwd2" placeholder="비밀번호 확인" /><br>
				<input type="text" name="name" id="name" placeholder="이름" /><br>
				<input type="text" name="age" id="age" placeholder="나이" /><br>
				<input type="text" name="phone" id="phone" placeholder="전화번호"><br>
				성별:<input type="radio" name="gender" value="남">남자 <input
					type="radio" name="gender" value="여"> 여자<br>
					<span></span>
					<br>
				<button type="button" onclick="memberCheck()">회원가입</button>
				<input type="reset" value="지우기" />
			</form>
		</div>
	</div>
	
</body>

<jsp:include page="/common/template/footer.jsp" />
</html>