<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memoList</title>

<script>
	function formSubmit(str) {
		var result = confirm("정말 삭제하시겠습니까?");
		if(result){
			frm.id.value = str;
			frm.submit();
		};
	}
</script>

</head>
<jsp:include page="/common/template/header.jsp" />

<body>

<form id="frm" name="frm" action="MemoDelete.do" method="post">
		<input type="hidden" id="id" name="id">
	</form>
	
	<div align="center">
		<h4>전달사항</h4>
		<table border="2">
			<tr>
				<td>번호</td>
				<td>메모</td>
				<td>날짜</td>
			</tr>
			<tr>
				<c:forEach var="List" items="${memoList }">
					<td>${vo.seq}</td>
					<td>${vo.memo}</td>
					<td>${vo.regdt}</td>
					<tr>
				</c:forEach>
			</tr>
		</table>
	</div>
</body>
<jsp:include page="/common/template/footer.jsp" />

</html>