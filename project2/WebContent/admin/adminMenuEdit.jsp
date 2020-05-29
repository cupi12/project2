<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<script>
	function a() {
		var result = confirm("정말 삭제하시겠습니까?");
		if (result) {
			location.href = 'AdminMenuDelete.do?mName=${getMenu.mName }';
		}
	}
	
	function b() {
		var result = confirm("정말 수정하시겠습니까?");
		if (result) {
			location.href = 'AdminMenuUpdate.do';
		}
	}
	
</script>
<title>하준원</title>
</head>
<jsp:include page="/common/template/header.jsp" />
<body>
	메뉴명:
	<input type="text" value="${getMenu.mName }" name="mName" id="mName">
	<br> 가격:
	<input type="text" value="${getMenu.mPrice }" name="mPrice" id="mPrice">
	<br>
	<!-- <button onclick="update()">메뉴 수정</button>
<button>메뉴 삭제</button><br> -->

	<input type="button" onclick="a()" value="삭제" />
	<input type="button" onclick="b()" value="수정" />

</body>
<jsp:include page="/common/template/footer.jsp" />
</html>