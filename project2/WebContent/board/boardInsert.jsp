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
	<div>
	<h1>�ı� �ۼ�</h1>
	</div>
	<span> 
		 �̸�:<input type="text" name="name" id="name" /><br /> 
		 ����: <input type="text" name="age" id="age"/> <br/>  
		 ��ȭ��ȣ:	<input type="text" name="phone" id="phone"/><br/> 
		 ��й�ȣ: <input type="password" name="pwd" id="pwd" /><br /> 
		�ۼ�:<input type="text" name="title" id="title" /><br/>
			<textarea rows="35" cols="80">�����Է�</textarea>
		<button type="button" onclick="validCheck()">���</button> 
		<input type="reset" value="�����" />
	<div>
	
	
	</div>
</body>
<jsp:include page="/common/template/footer.jsp" />
</html>