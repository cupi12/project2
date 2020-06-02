<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<div align="center">
		<h2>메뉴 관리</h2>
		<form id="frm" name="frm" action="AdminMenuEdit.do" method="get">
			<input type="hidden" id="mName" name="mName"><br>
		</form>
		
		<table>
			<tr>
				<td>메뉴명</td>
				<td>메뉴가격</td>
				<td>메뉴사진</td>
			</tr>
			<c:forEach items="${vo}" var="vo">
				<tr>
					<td onclick="formSubmit('${vo.mName}')">${vo.mName }</td>
					<td>${vo.mPrice }원</td>
					<td><img src="menu/image/${vo.fileName}" width="300" height="200" /></td>
				</tr>
			</c:forEach>
		</table>
		<br />




		<form id="frm2" name="frm2" action="AdminMenuInsert.do" method="post" enctype="multipart/form-data">
			<input type="text" placeholder="메뉴명" name="mName" id="mName"><br>
			<input type="text" placeholder="메뉴가격" name="mPrice" id="mPrice"><br>
			첨부파일<input type = "file" name = "filename" id="filename"><br>
			<input type="submit" value="메뉴추가" />
			
			
<%@page import="java.awt.Image"%>
<%@page import="com.sun.jimi.core.Jimi"%>
<%@page import="com.sun.jimi.core.JimiException"%>
<%@page import="com.sun.jimi.core.JimiUtils"%>
		</form>
		
		
		
	</div>
	<jsp:include page="/common/template/footer.jsp" />
</body>
</html>