<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 리스트</title>
</head>
<jsp:include page="/common/template/header.jsp" />

<body>
	<div>
		<h3>직원 목록</h3>
		<table border="1" align="center">
			<tr>
				<td>번호</td>
				<td>이름</td>
				<td>시작시간</td>
				<td>종료시간</td>
				<td>근무시간</td>
				<td>근무급여</td>
				<td>출퇴근 체크</td>
			</tr>
			<tr>
				<c:forEach var="vo" items="${WorkerList}">
					<td>${vo.worker.seq}</td>
					<td>${vo.worker.wname }</td>
					<td>${vo.worker.wstart }</td>
					<td>${vo.worker.wend }</td>
					<td>${vo.worker.totalTime }</td>
					<td>${vo.worker.money }</td>
					<td><button></button></td>
				</c:forEach>
			</tr>
		</table>
	</div>
	<div>
	
	<script type="text/javascript">
		function gopage(p){
			document.searchfrm.p.value = p;
			document.searchfrm.submit();
		}
	</script>
	
	</div>
</body>

<jsp:include page="/common/template/footer.jsp" />


</html>