<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<table>
			<tr>
				<td>번호</td>
				<td>메모</td>
				<td>날짜</td>

			</tr>
			<c:forEach items="${vo}" var="vo">
				<tr>
					<td onclick="form.Submit('${vo.seq}')">${vo.memo}</td>
					<td></td>
				</tr>
			</c:forEach>
		</table>
		<br />

		<form id="frm2" name="frm2" action="AdminMemoInsert.do" method="post">
			<input type="text" placeholder="번호" name="seq" id="seq"><br>
			<input type="text" placeholder="메모" name="memo" id="memo"><br>
			
			<input type="submit" value="메모입력" />
		</form>
	</div>

	<jsp:include page="/common/template/footer.jsp" />

</body>
</html>