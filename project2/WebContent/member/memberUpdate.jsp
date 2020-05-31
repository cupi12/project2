<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<jsp:include page="/common/template/header.jsp"/>
<body>

<div align="center">
	<h1>회원 정보 수정</h1>

		<form name="frm" method="post" action="MemberUpdate.do">
			 아이디 : <input type="text" name="id" id="id" readonly="readonly" value="${member.id}" /><br />
			 비밀번호 : <input type="password" name="pwd" id="pwd"  value="${member.pwd}" /><br /> 
			 이름 : <input type="text" name="name" id="name" /><br /> 
			 나이 : <input type="text" name="age" id="age"/> <br/>
			전화번호 : <input type="text" name="phone" id="phone"/><br/> 
	      	<button type="submit">회원수정</button>
		</form>
		<input type="button" onclick="location.href='MemberDelete.do?id=${member.id}' " value = "회원탈퇴" />
</div>


</body>

<jsp:include page="/common/template/footer.jsp"/>
</html>