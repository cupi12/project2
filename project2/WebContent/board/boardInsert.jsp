<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<jsp:include page="/common/template/header.jsp" />
<body>
	<div align="center" method="post" action="BoardInsert.do">
		<div>
			<h1>후기 작성</h1>
		</div>
		<form>
		제목 : <input type="text" name="title" id="title" /><br>
		작성자 : <input type="text" name="name" id="name" value="${loginId }"/><br> 
		<textarea rows="20" cols="40" placeholder="내용입력"></textarea><br>
		별줌주기:<br>
		추천:<br>
		
		<button type="submit">등록</button>
		<input type="reset" value="지우기" />
		</form>
	</div>
</body>
<jsp:include page="/common/template/footer.jsp" />
</html>