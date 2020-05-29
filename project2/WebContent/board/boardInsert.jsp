<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<jsp:include page="/common/template/header.jsp" />
<body>
<div align="center"></div>
	<div>
	<h1>후기 작성</h1>
	</div>
	<span> 
		 이름:<input type="text" name="name" id="name" /><br /> 
		 나이: <input type="text" name="age" id="age"/> <br/>  
		 전화번호:	<input type="text" name="phone" id="phone"/><br/> 
		 비밀번호: <input type="password" name="pwd" id="pwd" /><br /> 
		작성:<input type="text" name="title" id="title" /><br/>
			<textarea rows="35" cols="80">내용입력</textarea>
		<button type="button" onclick="validCheck()">등록</button> 
		<input type="reset" value="지우기" />
	<div>
	
	
	</div>
</body>
<jsp:include page="/common/template/footer.jsp" />
</html>