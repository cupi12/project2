<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding ="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>workerList</title>


</head>

<body>

	<h3>직원 목록</h3>
	<table border="1" align="center">
		<tr>
		<td>번호</td>
		<td>이름</td>
		<td>시작시간</td>
		<td>종료시간</td>
		<td>근무시간</td>
		<td>급여</td>
		</tr>
 		<tr>
		<c:forEach var="vo" items="workerList">
		<td>${vo.seq}</td>
		<td>${vo.wname }</td>
		<td>${vo.wstart }</td>
		<td>${vo.wend }</td>
		<td>${vo.totalTime }</td>
		<td>${vo.money }</td>
		</c:forEach>
		</tr> 
	</table>
	
</body>
</html>