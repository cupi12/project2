<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="/common/template/header.jsp"/>

<body>
	<table border="1" align="center" >

		<h3 align="center">메모</h3>
		<form action="memo/MemoDAO.java" align="center" method="post"
			enctype="multijpart/form-data"></form>

		번호 :
		<input type="">
		<br>
		<!-- 데이터 타입  -->
		제목 :
		<input type="text" name="name" id="name">
		<br> 메모 :
		<input type="text" name="start id="start">
		<br>
		<!-- 데이터 타입 date -->

		<br>
		<br>

		<button type="submit">등록 하기</button>
		<button type="submit">수정 하기</button>
		<button type="submit">삭제 하기</button>

	</table>
</body>

<jsp:include page="/common/template/footer.jsp"/>
</html>