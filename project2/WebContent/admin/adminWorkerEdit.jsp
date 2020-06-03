<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<meta charset="UTF-8">
<title>Insert title here</title>

<script>
	function a() {
		if (result = confirm("삭제하시겠습니까?")) {
			location.href = 'AdminMemoDelete.do';
		}
	}

	function update() {
		if (confirm("수정하시겠습니까?")) {
			frm.submit();
		}
	}
</script>

</head>

<jsp:include page="/common/template/header.jsp" />

<body>
	<div align="center">
		<h1>직원관리</h1>
		<table border="1">
			<tr>
				<td>번호</td>
				<td>직원명</td>
				<td>근무시작</td>
				<td>근무종료</td>
				<td>근무시간</td>
				<td>근무급여</td>
			</tr>

			<c:forEach items="${workerList}" var="vo">
				<tr>
					<td>${vo.seq}</td>
					<td>${vo.wname }</td>
					 <td>${vo.wstart}</td>
					<td>${vo.wend}</td>
					<td>${vo.totalTime}</td>
					<td>${vo.money}</td>
				</tr>
			</c:forEach>
		</table>
		<form>
		
		
			<td><button type="submit">출근</button>
				<button type="submit">퇴근</button></td>
		</form>
		<form action="AdminWorkerInsert.do" method="post" name="frm">
			직원명: <input type="text" name="wname" id="wname">
			<button type="submit">직원추가</button>
		</form>

	</div>



</body>
<jsp:include page="/common/template/footer.jsp" />

</html>