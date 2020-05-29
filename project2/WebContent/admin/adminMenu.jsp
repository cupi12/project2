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
<c:forEach items="${vo }" var="vo">
	<tr>		
		<td onclick="formSubmit('${vo.mName}')">${vo.mName }</td>
		<td>${vo.mPrice }</td> 
	</tr>
</c:forEach>
</table>
<br/>



<input type="text" placeholder="메뉴명" ><br>
<input type="text" placeholder="메뉴가격"><button height="">메뉴 추가</button><br>


<jsp:include page="/common/template/footer.jsp" />
</body>
</html>