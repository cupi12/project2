<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memoList</title>
</head>
<body>

		<h3>메모 게시판</h3>	
		<table border="1" align="center">	
			<tr>
				<td>번호</td>
				<td>메모</td>
				<td>날짜</td>
			</tr>
			<tr>
			<c:forEach var="vo" items="MemoList">
				<td>${vo.seq}</td>
				<td>${vo.regdt}</td>
				<td>${vo.memo}</td>
			</c:forEach>
			</tr>
		</table>
</body>
</html>