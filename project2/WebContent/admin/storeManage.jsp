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
<div align="center">
<h2>일별 매출 현황</h2><br>

차트<br>
<button onclick="locationl.href=''">일별차트 출력</button><br>
<hr>
<h2>월별 매출 현황</h2><br>
차트<br>
<button onclick="locationl.href='Chart.do'">월별차트 출력</button>
</div>
</body>
<jsp:include page="/common/template/footer.jsp"/>
</html>