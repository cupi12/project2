<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/common/template/header.jsp" />

<script type="text/javascript">
	function formSubmit(str) {
		frm.mName.value = str;
		frm.submit();
	}
</script>

</head>
<body>

<div align="center">
		<h2>직원 관리</h2>
		<form id="frm" name="frm" action="AdminWorkerEdit.do" method="post">
			<input type="hidden" id="wname" name="wname"><br>
		</form>
		<table border = "1">
			<tr>
				<td>번호</td>
				<td>직원명</td>
				<td>근무시작</td>
				<td>근무종료</td>
				<td>근무시간</td>
				<td>근무급여</td>
			</tr>
			<c:forEach items="${vo}" var="vo">
				<tr>
					<td onclick="formSubmit('${vo.worker}')">${vo.seq}</td>
					<td>${vo.wstart}</td>
					<td>${vo.wend}</td>
					<td>${vo.totaltime}</td>
					<td>${vo.money}</td>
				</tr>
			</c:forEach>
		</table>
		<br />

		<form id="frm2" name="frm2" action="AdminWorkerInsert.do" method="post">
			<input type="text" placeholder="직원명" name="wname" id="wname"><br>
			<input type="text" placeholder="근무시작" name="wstart" id="wstart"><br>
			<input type="text" placeholder="근무종료" name="wend" id="wend"><br>
			<input type="text" placeholder="근무시간" name="totaltime" id="totaltime"><br>
			<input type="" placeholder="근무급여" name="money" id="money"><br>
			
			<input type="submit" value="직원입력" />
		</form>
	</div>
	
	
	
	<jsp:include page="/common/template/footer.jsp" />

</body>
</html>