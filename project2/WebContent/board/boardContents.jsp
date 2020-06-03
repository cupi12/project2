<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>하준원</title>
<script>
	function recommand() {
		location.href = "BoardRecommand.do"
	}

	function del(param) {
		frm.seq.value = param
		if (confirm("정말 삭제하시겠습니까?")) {
			frm.submit();
		}
	}

</script>
</head>
<jsp:include page="/common/template/header.jsp" />
<body>
	<form action="BoardDelete.do" id="frm" name="frm" method="post">
		<input type="hidden" id="seq" name="seq" />
	</form>
	<div align="center">
		<form action="BoardUpdate.do" method="post" name="post">
			제목 <input readonly value="${getBoard.title }" name="title" id="title"><br>
			작성자<input readonly value="${getBoard.id }" name="id" id="id"><br>
			<textarea rows="30px" cols="140px" readonly name="contents"
				id="contents">${getBoard.contents }</textarea>
			<br> <label>별점 : ${getBoard.star }</label><br> <label>추천수
				: ${getBoard.recommand }</label>
			<button type="button" onclick="recommand()">추천하기</button>
			<br>
			<div>
				<div>
					<!-- ID값이 sessionID와 같을때 보이기-->
					<c:if test="${loginId == getBoard.id}">
						<button type="submit">수정</button>
					</c:if>
		</form>
		<c:if test="${loginId == getBoard.id}">
			<button type="button" onclick="del('${getBoard.seq }')">삭제</button>
		</c:if>

		<div>
			<button>홈으로</button>
		</div>
	</div>

	</div>
</body>
<jsp:include page="/common/template/footer.jsp" />
</html>