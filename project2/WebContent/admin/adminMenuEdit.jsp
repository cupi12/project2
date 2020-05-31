<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<script>
	function a() {
		if (result = confirm("정말 삭제하시겠습니까?")) {
			location.href = 'AdminMenuDelete.do';
		}
	}
	
	function update() {
		if (confirm("정말 수정하시겠습니까?")) {
			frm.submit();
		}
	}
	
</script>
<title>하준원</title>
</head>
<jsp:include page="/common/template/header.jsp" />
<body>
	<form method="post" action="AdminMenuUpdate.do" name="frm">
	메뉴명:
	<input type="text" value="${getMenu.mName }" name="mName" id="mName">
	<br> 가격:
	<input type="text" value="${getMenu.mPrice }" name="mPrice" id="mPrice">
	<br>
	<input type="button" onclick="update()" value="수정" />
	<input type="button" onclick="a()" value="삭제" />
	</form>



</body>
<jsp:include page="/common/template/footer.jsp" />
</html>