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

/* 	function recommand(param) {
		location.href = "BoardRecommand.do?=seq" + param;
	} */
	
	function recommand(param) {
		document.frm4.seq.value = param;
		frm4.submit();
	}

	
</script>
</head>
<jsp:include page="/common/template/header.jsp" />
<body>

	<form action="BoardUpdatePath.do" id="frm2" name="frm2" method="post">
		<input type="hidden" id="seq" name="seq" />
	</form>

	<form action="Recommand.do" id="frm4" name="frm4" method="post">
		<input type="hidden" id="seq" name="seq" />
	</form>

	<form action="BoardDelete.do" id="frm" name="frm" method="post">
		<input type="hidden" id="seq" name="seq" />
	</form>
	<div align="center">
		<form action="BoardUpdatePath.do" method="post" name="frm3" id="frm3">
			<br> <label value="${getBoard.id }" name="id" id="id">작성자 : ${getBoard.id }</label><br> 
			<input name="seq" id="seq" type="hidden" value="${getBoard.seq}">
			<br> 제목<h2 name="title" id="title">${getBoard.title}</h2><p></p>
			
			내용 <p style="font-size: 24px; color: black;" cols="30" rows="10"
				name="contents" id="contents">${getBoard.contents }</p>
				
				<img src="board/boardImage/${getBoard.fileName}"
				width="300" height="200" onerror="this.style.display='none';" /><p></p><p></p><p></p>
				
			<br> <label>별점 : ${getBoard.star }</label><br> 
			 <label>추천수:${getBoard.recommand }
				<button type="button" onclick="recommand('${getBoard.seq}')">추천하기</button>
			</label> <br>
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