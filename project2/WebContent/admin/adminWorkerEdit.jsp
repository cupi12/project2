<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<meta charset="UTF-8">
<title>Insert title here</title>

<script>
	
	function wstart(param){
		document.frm1.wname.value=param
		if(confirm("출근입력")){
			frm1.submit();
		}
	}
	function wend(param){
		frm2.wend.value=param
		if(confirm("퇴근입력")){
			frm2.submit();
		}
	}


</script>

</head>

<jsp:include page="/common/template/header.jsp" />

<body>
	<div align="center">
		<h1>직원관리</h1>
		<table border="1">
			<tr>
				<td>번호</td>
				<td>직원명</td>
				<td>근무시작</td>
				<td>근무종료</td>
				<td>근무시간</td>
				<td>근무급여</td>
				<th>직원관리</th>
			</tr>

			<c:forEach items="${workerList}" var="vo">
				<tr>
					<td>${vo.seq}</td>
					<td>${vo.wname }</td>
					<td>${vo.wstart}</td>
					<td>${vo.wend}</td>
					<td>${vo.totalTime}</td>
					<td>${vo.money}</td>
					<td>
					<%-- <button type = "button" onclick="wstart('${vo.wstart}')">출근</button> --%>
					<button type = "button" onclick="wstart('${vo.wname }')">출근</button>
					<button type = "button" onclick="wend('${vo.wend}')">퇴근</button>
					
				</tr>
			</c:forEach>
		</table>
	
		<form action="AdminWorkerInsert.do" method="post" name="frm">
			직원명: <input type="text" name="wname" id="wname">
			<button type="submit">직원추가</button>
		</form>
		
		<form action="AdminWorkerWstart.do" id="frm1" name="frm1" method="post">
			<input type="hidden" id= "wstart" name="wstart">
		</form>
		
	<!-- 	<form action="AdminWorkerWstart.do" method="post" name="frm">
			<button type="submit">출근</button>
		</form>
		<form action="AdminWorkerWend.do" method="post" name="frm2">
			<button type="submit">퇴근</button>
		</form>
		<form action="AdminWorkerTotalTime.do" method="post" name="frm">
			<button type="submit">근무시간</button>
		</form>
		<form action="AdminWorkerMoney.do" method="post" name="frm">
			<button type="submit">근무급여</button>
		</form> -->
	</div>


</body>
<jsp:include page="/common/template/footer.jsp" />

</html>