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
<div align="center"></div>
<h1>�ı� ����</h1>
<div>
	<div>
		<span>�̸�:</span><input type="text" name="name" id="name" readonly="readonly" value="${board.name}" /><br />
		 ��й�ȣ: <input type="password" name="pwd" id="pwd"  value="${board.pwd}" /><br />  
		 ����: <input type="text" name="age" id="age"/> <br/>  
		��ȭ��ȣ:	<input type="text" name="phone" id="phone"/><br/> 
		�ۼ�:<input type="text" name="title" id="title" /><br/>
			<textarea rows="35" cols="80">�����Է�</textarea><br/>
      	<input type="button" onclick="location.href='BoardUpdate.do?id=${board.id}' "value="����" />
		<input type="button" onclick="location.href='BoardUpdate.do?id=${board.id}' "value="�ı� ����" />
	</div>

</div>
</body>
<jsp:include page="/common/template/footer.jsp" />
</html>