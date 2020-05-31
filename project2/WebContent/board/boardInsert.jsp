<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<jsp:include page="/common/template/header.jsp" />
<body>
	<div align="center">
		<div>
			<h1>후기 작성</h1>
		</div>
		ID : <input type="text" name="name" id="name" /><br> 
		작성 : <input type="text" name="title" id="title" /><br>
		<textarea rows="35" cols="80">내용입력</textarea>
		<br>
		<button type="button" onclick="validCheck()">등록</button>
		<input type="reset" value="지우기" />
	</div>
</body>
<jsp:include page="/common/template/footer.jsp" />
</html>