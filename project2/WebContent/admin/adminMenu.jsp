<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<body>
<h2>메뉴 관리</h2>
	<form id="frm" name="frm" action="AdminMenuEdit.do" method="post">
		<input type="hidden" id="mName" name="mName">
	</form>
	
	
<table>
<tr>
<td>메뉴명</td><td>메뉴가격</td>
</tr>
<c:forEach items="${vo}" var="vo">
	<tr>		
		<td onclick="formSubmit('${vo.mName}')">${vo.mName }</td>
		<td>${vo.mPrice }</td> 
	</tr>
</c:forEach>
</table>
<br/>

<form id="frm2" name="frm2" action="AdminMenuInsert.do" method="post">	
	<input type="text" placeholder="메뉴명" name="mName" id="mName"><br>
	<input type="text" placeholder="메뉴가격" name="mPrice" id="mPrice">
	<input type="submit" value="메뉴추가"/>
</form>
<jsp:include page="/common/template/footer.jsp" />
</body>
</html>