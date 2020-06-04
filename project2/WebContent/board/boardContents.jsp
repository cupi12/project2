<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>하준원</title>
<script>
	function update(param) {
		document.frm2.seq.value = param;
		frm2.submit();
	}

	function del(param) {
		frm.seq.value = param;
		if (confirm("정말 삭제하시겠습니까?")) {
			frm.submit();
		}
	}
</script>
</head>
<jsp:include page="/common/template/header.jsp" />
<body>
	<form action="BoardUpdatePath.do" id="frm2" name="frm2" method="post">
		<input type="hidden" id="seq" name="seq" />
	</form>

	<form action="BoardDelete.do" id="frm" name="frm" method="post">
		<input type="hidden" id="seq" name="seq" />
	</form>
	<div align="center">
		<form action="BoardUpdatePath.do" method="post" name="frm3" id="frm3">
			<input name="seq" id="seq" type="hidden" value="${getBoard.seq}">
			제목 <input readonly value="${getBoard.title }" name="title" id="title"><br>
			작성자<input readonly value="${getBoard.id }" name="id" id="id"><br>
			<textarea rows="10px" cols="" readonly name="contents"
				id="contents">${getBoard.contents }</textarea>
			<br> <label>별점 : ${getBoard.star }</label><br> <label>추천수
				: ${getBoard.recommand }</label><br>
			<c:if test="${loginId!=null}">
				<label>추천수:${getBoard.recommand }
					<button type="button" onclick="recommand('${getBoard.seq}')">추천하기</button>

				</label>
			</c:if>
			<br>
			<div>
				<div>
					<!-- ID값이 sessionID와 같을때 보이기-->
					<c:if test="${loginId == getBoard.id}">
						<button type="button" onclick="update('${getBoard.seq }')">수정</button>
					</c:if>
		</form>
		<c:if test="${loginId == getBoard.id}">
			<button type="button" onclick="del('${getBoard.seq }')">삭제</button>
		</c:if>

		<div>
			<button type="button" onclick="location.href='BoardList.do'">홈으로</button>
		</div>
	</div>

</body>
<jsp:include page="/common/template/footer.jsp" />
</html>