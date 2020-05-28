<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<jsp:include page="/common/template/header.jsp" />
<table border="1">
	<tr>
		<td colspan="2">메뉴목록</td>
	</tr>
	<c:forEach items="${menuList }" var="vo">
		<tr>
			<td>${vo.mName }</td>
			<td>${vo.mPrice }</td>
		</tr>
	</c:forEach>

</table><br>
합계:<input type="text" readonly><button>주문하기</button>



<jsp:include page="/common/template/footer.jsp" />
</html>