<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<jsp:include page="/common/template/header.jsp" />
<script>
	function formSubmit(str) {
		var result = confirm("정말 삭제하시겠습니까?");
		if(result){
			frm.id.value = str;
			frm.submit();
		};
	}
</script>

<body>
	<form id="frm" name="frm" action="MemberDelete.do" method="post">
		<input type="hidden" id="id" name="id">
	</form>
	<div align="center">
		<div>
			<h1>회원 목록</h1>
		</div>
		<form name="searchfrm">
			<input name="p" value="1" type="hidden">

			<samp> ID </samp>
			<input name="id" /><br>
			<samp>성별</samp>
			<samp>
				<select name="gender">
					<option value="">전체</option>
					<option value="m">남자
						</osption>
					<option value="f">여자</option>
				</select>
			</samp>
			<button>검색</button>
		</form>

		<div>
			<table border="1">
				<tr>
					<th>ID</th>
					<th>비밀번호</th>
					<th>이름</th>
					<th>나이</th>
					<th>성별</th>
					<th>전화번호</th>
					<th>가입날짜</th>
					<th>관리</th>
				</tr>
				<c:forEach items="${Member }" var="vo">
					<tr align="center">
						<td>${vo.id}</td>
						<td>${vo.pwd}</td>
						<td>${vo.name}</td>
						<td>${vo.age}</td>
						<td>${vo.gender}</td>
						<td>${vo.phone}</td>
						<td>${vo.regdt}</td>
						<td><button onclick="formSubmit('${vo.id }')">삭제</button></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div>
			<button type="button" onclick="location.href='main.do'">홈으로</button>
		</div>

		<script type="text/javascript">
			function gopage(p) {
				document.searchfrm.p.value = p;
				document.searchfrm.submit();
				//location.href="EmpList.do?p="+p;
			}
		</script>
</body>
<jsp:include page="/common/template/footer.jsp" />
</html>