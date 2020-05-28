<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<jsp:include page="/common/template/header.jsp"/>
<body>
<div align="center"></div>
<h1>회원 정보 수정</h1>
<div>
<div>
		<span>ID:</span><input type="text" name="id" id="id" readonly="readonly" value="${member.id}" /><br />
		 비밀번호: <input type="password" name="pwd" id="pwd"  value="${member.pwd}" /><br /> 
		 이름:<input type="text" name="name" id="name" /><br /> 
		 나이: <input type="text" name="age" id="age"/> <br/> 
		 성별: <input type="radio" name="gender" value="m" />남자 
			  <input type="radio" name="gender" value="f" /> 여자<br /> 
		전화번호:	<input type="text" name="phone" id="phone"/><br/> 
		<button type="button" onclick="validCheck()">회원가입</button> 
		<input type="reset" value="지우기" />
	</div>
</div>

</body>

<jsp:include page="/common/template/footer.jsp"/>
</html>