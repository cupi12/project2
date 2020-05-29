<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/common/template/header.jsp" />

<h2>메뉴 관리</h2>

<table>
<tr>
<td>메뉴명</td><td>메뉴가격</td>
</tr>
<c:forEach items="${menuList }" var="vo">
<tr>		
<td>
<a href="URL" onclick="window.open('AdminEditMenu.do?mName=${vo.mName }', '_blank', 'width=auto,height=auto,toolbars=no,scrollbars=no'); return false;">
${vo.mName }</a></td>
<td>${vo.mPrice }</td> 
</tr>
</c:forEach>
</table>
<br>



<input type="text" placeholder="메뉴명" ><br>
<input type="text" placeholder="메뉴가격"><button height="">메뉴 추가</button><br>


<jsp:include page="/common/template/footer.jsp" />
</html>