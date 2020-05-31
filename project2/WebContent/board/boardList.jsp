<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function deleteCheck(){
	if(confirm("정말 삭제하시겠습니까?")){
		frm.submit();
	}
}
</script>
</head>
<jsp:include page="/common/template/header.jsp" />
<body>
	<div align="center">
		<h1>후기 게시판</h1>
		<div>
			<button onclick="location.href='BoardInsertMenu.do'">후기 등록</button>
		</div>

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
					<c:if test="${loginId==admin }">
						<th>게시판 관리</th>
					</c:if>
				</tr>

				<c:forEach var="board" items="${Board}">
							<form name="frm" method="post" action="">
					<tr>
						<td>${board.seq}</td>
						<td>${board.title}</td>
						<td>${board.contents}</td>
						<td>${board.regdt}</td>
						<td>${board.id}</td>
						<td>${board.star}</td>
						<td>${board.recommand}</td>
						<c:if test="${loginId==admin }">
							<td><button type="submit" onclick="deleteCheck()">게시글 삭제</button></td>
						</c:if>
					</tr>
							</form>
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