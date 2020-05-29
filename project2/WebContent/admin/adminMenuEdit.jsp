<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
<title>하준원</title>
</head>
<jsp:include page="/common/template/header.jsp"/>
<body>
메뉴명:<input type="text" value="${getMenu.mName }" name="mName" id="mName"><br>  
가격: <input type="text" value="${getMenu.mPrice }" name="mPrice" id="mPrice"><br> 
<button>메뉴 수정</button>
<button>메뉴 삭제</button><br>

</body>
<jsp:include page="/common/template/footer.jsp"/>
</html>