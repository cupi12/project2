<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<script>
	function validCheck() {
		//필수입력 체크
		if (frm.id.value == "") { //trim함수
			alert("id입력");
			frm.id.focus();
			return;
		}

		if (frm.pwd.value == "") {
			alert("pwd입력");
			frm.pwd.focus();
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
			alert("성별 적어도 1개 선택");
			return;
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

		<div>
			<span></span><br>
			<form action="MemberInsert.do" Method="post" name="frm">
				<input type="text" name="id" id="id" placeholder="아이디"><br>
				<input type="password" name="pwd" id="pwd" placeholder="비밀번호" /><br>
				<input type="text" name="name" id="name" placeholder="이름" /><br>
				<input type="text" name="age" id="age" placeholder="나이" /> <br>
				<input type="text" name="phone" id="phone" placeholder="전화번호"><br>
				성별:<input type="radio" name="gender" value="m">남자 <input
					type="radio" name="gender" value="f"> 여자<br>
				<button type="button" onclick="validCheck()">회원가입</button>
				<input type="reset" value="지우기" />
			</form>
		</div>
	</div>
</body>

<jsp:include page="/common/template/footer.jsp" />
</html>