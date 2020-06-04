<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>주문내역</title>
</head>
<jsp:include page="/common/template/header.jsp" />
<body>
	<div align="center">
		<h2>결제내역</h2>
		<table border="1">
			<tr>
				<td>주문날짜</td>
				<td>주문수량</td>
				<td>결제가격</td>
			</tr>
			<c:forEach items="${list }" var="vo">
				<tr>
					<td>${vo.regdt }</td>
					<td>${vo.amount }</td>
					<td>${vo.price }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
<jsp:include page="/common/template/footer.jsp" />
</html>