<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<jsp:include page="/common/template/header.jsp" />
<body>
	<div align="center">
		<div>
			<h1>�ı� �Խ���</h1>
		</div>
		
			<form name="searchfrm">
			<input name="p" value="1" type="hidden">

			<samp> ID </samp>
			<input name="id" /><br>
			<samp>����</samp>
			<samp>
				<select name="gender">
					<option value="">��ü</option>
					<option value="m">����</osption>
					<option value="f">����</option>
			</select>
			</samp>
			<button>�˻�</button>
		</form>
		
		<div>
			<table border="1">
				<tr>
					<th>�۹�ȣ</th>
					<th>����</th>
					<th>����</th>
					<th>�ۼ�����</th>
					<th>�ۼ�ID</th>
					<th>����</th>
					<th>��õ</th>
				</tr>
				
					<c:forEach var="board" items="${Board}">
					<tr>
						<td>${board.seq}</td>
						<td>${board.title}</td>
						<td>${board.contents}</td>
						<td>${board.regdt}</td>
						<td>${board.id}</td>
						<td>${board.star}</td>
						<td>${board.recommand}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div>
			<button type="button" onclick="location.href='main.do'">Ȩ����</button>
		</div>
		<script type="text/javascript">
			function gopage(p) {
				document.searchfrm.p.value = p;
				document.searchfrm.submit();
				//location.href="EmpList.do?p="+p;
			}
		</script>
		
</body>
<jsp:include page="/common/template/footer.jsp" />
</html>