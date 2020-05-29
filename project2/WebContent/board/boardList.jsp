<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<jsp:include page="/common/template/header.jsp" />
<body>
	<div align="center">
		<h1>후기 게시판</h1>
 		<div>
		<button onclick="location.href='BoardInsert.do'">후기 등록</button>
		</div>
		<!-- <form name="searchfrm">
			<input name="p" value="1" type="hidden">

			<samp> ID </samp>
			<input name="id" /><br>
			<samp>성별</samp>
			<samp>
				<select name="gender">
					<option value="">전체</option>
					<option value="m">남자
					<option value="f">여자</option>
				</select>
			</samp>
			<button>검색</button>
		</form> -->

		<div>
			<table border="1">
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>내용</th>
					<th>작성일자</th>
					<th>작성ID</th>
					<th>평점</th>
					<th>추천</th>
				</tr>

				<c:forEach var="board" items="${Board}">
					<tr>
						<td>${board.seq}</td>
						<td>${board.title}</td>
						<td>${board.contents}</td>
						<td>${board.regdt}</td>
						<td>${board.id}</td>
						<td>${board.star}</td>
						<td>${board.recommand}</td>
					</tr>
				</c:forEach>
			</table>
			<button type="button" onclick="memberInsert()">홈으로</button>
		</div>
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