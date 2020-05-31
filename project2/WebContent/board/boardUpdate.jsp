<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="/common/template/header.jsp" />
<body>
<div align="center"></div>
<h1>후기 수정</h1>
<div>
	<div>
		<span>이름:</span><input type="text" name="name" id="name" readonly="readonly" value="${board.name}" /><br />
		 비밀번호: <input type="password" name="pwd" id="pwd"  value="${board.pwd}" /><br />  
		 나이: <input type="text" name="age" id="age"/> <br/>  
		전화번호:	<input type="text" name="phone" id="phone"/><br/> 
		작성:<input type="text" name="title" id="title" /><br/>
			<textarea rows="35" cols="80">내용입력</textarea><br/>
      	<input type="button" onclick="location.href='BoardUpdate.do?id=${board.id}' "value="수정" />
		<input type="button" onclick="location.href='BoardUpdate.do?id=${board.id}' "value="후기 삭제" />
	</div>

</div>
</body>
<jsp:include page="/common/template/footer.jsp" />
</html>