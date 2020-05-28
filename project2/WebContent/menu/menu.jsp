<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<jsp:include page="/common/template/header.jsp" />
<table border="1" align="center">
	<tr>
		<td colspan="1">메뉴목록</td>
	</tr>
	<c:forEach items="menuList" var="vo">
		<tr>
			<td>${vo.mName }</td>
			<td>${vo.mPrice }</td>
		</tr>
	</c:forEach>

</table>


<jsp:include page="/common/template/footer.jsp" />
</html>