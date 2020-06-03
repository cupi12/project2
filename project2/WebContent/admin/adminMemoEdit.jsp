<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/common/template/header.jsp" />

<script type="text/javascript">
	function formSubmit(str) {
		frm.wname.value = str;
		frm.submit();
	}
</script>

</head>
<body>

<div align="center">
		<h2>메모</h2>
		<form id="frm" name="frm" action="AdminMemoEdit.do" method="post">
			<input type="hidden" id="memo" name="memo"><br>
		</form>
		<table border = "1">
			<tr>
				<td>번호</td>
				<td>메모</td>
				<td>날짜</td>
			</tr>
			<c:forEach items="${vo}" var="vo">
				<tr>
					<td onclick="formSubmit('${vo.memo}')">${vo.memo }</td>
					
				</tr>
			</c:forEach>
		</table>
		<br />

		<form id="frm2" name="frm2" action="AdminMemoInsert.do" method="post">
			<input type="text" placeholder="메모" name="memo" id="memo"><br>
			<input type="submit" value="메모작성" />
		</form>
	</div>
	<jsp:include page="/common/template/footer.jsp" />
	
	
</body>
</html>