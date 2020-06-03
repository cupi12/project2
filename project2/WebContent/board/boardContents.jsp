<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>하준원</title>
<script>
function recommand(){
	location.href="BoardRecommand.do"
}
function del(){
	location.href="BoardDelete.do"
}
</script>
</head>
<jsp:include page="/common/template/header.jsp" />
<body>
	<div align="center">
	<form action="BoardUpdate.do" method="post" name="post">
		제목 <input readonly value="${getBoard.title }" name="title" id="title"><br> 
		작성자<input readonly	value="${getBoard.id }" name="id" id="id"><br>
		<textarea rows="30px" cols="140px" readonly name="contents" id="contents">${getBoard.contents }</textarea><br>
		<label>별점 : ${getBoard.star }</label><br>
		<label>추천수 : ${getBoard.recommand }</label><button type="button" onclick="recommand()">추천하기</button>
		<br>
		<div>
			<div>
			<!-- ID값이 sessionID와 같을때 보이기-->
				<button type="submit">수정</button>
				</form>
				<div>
				<button type="button" onclick="location.href='BoardDelete.do' ">바로삭제 </button>
				<button onclick="del()">삭제</button>
			</div>
			<div>
				<button>홈으로</button>
			</div>
		</div>

	</div>
</body>
<jsp:include page="/common/template/footer.jsp" />
</html>