
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
.star-input>.input,
.star-input>.input>label:hover,
.star-input>.input>input:focus+label,
.star-input>.input>input:checked+label{display: inline-block;vertical-align:middle;background:url('img/grade_img.png')no-repeat;}
.star-input{display:inline-block; white-space:nowrap;width:225px;height:40px;padding:25px;line-height:30px;}
.star-input>.input{display:inline-block;width:150px;background-size:150px;height:28px;white-space:nowrap;overflow:hidden;position: relative;}
.star-input>.input>input{position:absolute;width:1px;height:1px;opacity:0;}
star-input>.input.focus{outline:1px dotted #ddd;}
.star-input>.input>label{width:30px;height:0;padding:28px 0 0 0;overflow: hidden;float:left;cursor: pointer;position: absolute;top: 0;left: 0;}
.star-input>.input>label:hover,
.star-input>.input>input:focus+label,
.star-input>.input>input:checked+label{background-size: 150px;background-position: 0 bottom;}
.star-input>.input>label:hover~label{background-image: none;}
.star-input>.input>label[for="p1"]{width:30px;z-index:5;}
.star-input>.input>label[for="p2"]{width:60px;z-index:4;}
.star-input>.input>label[for="p3"]{width:90px;z-index:3;}
.star-input>.input>label[for="p4"]{width:120px;z-index:2;}
.star-input>.input>label[for="p5"]{width:150px;z-index:1;}
.star-input>output{display:inline-block;width:60px; font-size:18px;text-align:right; vertical-align:middle;}
</style>

<style type="text/css">
body {
	font-family: Arial, Helvetica, sans-serif;
	margin: 0 auto;
}

a:link {
	color: #666;
	font-weight: bold;
	text-decoration: none;
}

a:visited {
	color: #666;
	font-weight: bold;
	text-decoration: none;
}

a:active, a:hover {
	color: #bd5a35;
	text-decoration: underline;
}

table a:link {
	color: #666;
	font-weight: bold;
	text-decoration: none;
}

table a:visited {
	color: #999999;
	font-weight: bold;
	text-decoration: none;
}

table a:active, table a:hover {
	color: #bd5a35;
	text-decoration: underline;
}

table {
	font-family: Arial, Helvetica, sans-serif;
	color: #666;
	font-size: 12px;
	text-shadow: 1px 1px 0px #fff;
	background: #eaebec;
	margin: 20px;
	border: #ccc 1px solid;
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	border-radius: 3px;
	-moz-box-shadow: 0 1px 2px #d1d1d1;
	-webkit-box-shadow: 0 1px 2px #d1d1d1;
	box-shadow: 0 1px 2px #d1d1d1;
}

table th {
	padding: 15px;
	border-top: 1px solid #fafafa;
	border-bottom: 1px solid #e0e0e0;
	background: #ededed;
	background: -webkit-gradient(linear, left top, left bottom, from(#ededed),
		to(#ebebeb));
	background: -moz-linear-gradient(top, #ededed, #ebebeb);
}

table th:first-child {
	text-align: left;
	padding-left: 20px;
}

table tr:first-child th:first-child {
	-moz-border-radius-topleft: 3px;
	-webkit-border-top-left-radius: 3px;
	border-top-left-radius: 3px;
}

table tr:first-child th:last-child {
	-moz-border-radius-topright: 3px;
	-webkit-border-top-right-radius: 3px;
	border-top-right-radius: 3px;
}

table tr {
	text-align: center;
	padding-left: 20px;
}

table tr td:first-child {
	text-align: left;
	padding-left: 20px;
	border-left: 0;
}

table tr td {
	padding: 12px;
	border-top: 1px solid #ffffff;
	border-bottom: 1px solid #e0e0e0;
	border-left: 1px solid #e0e0e0;
	background: #fafafa;
	background: -webkit-gradient(linear, left top, left bottom, from(#fbfbfb),
		to(#fafafa));
	background: -moz-linear-gradient(top, #fbfbfb, #fafafa);
}

table tr.even td {
	background: #f6f6f6;
	background: -webkit-gradient(linear, left top, left bottom, from(#f8f8f8),
		to(#f6f6f6));
	background: -moz-linear-gradient(top, #f8f8f8, #f6f6f6);
}

table tr:last-child td {
	border-bottom: 0;
}

table tr:last-child td:first-child {
	-moz-border-radius-bottomleft: 3px;
	-webkit-border-bottom-left-radius: 3px;
	border-bottom-left-radius: 3px;
}

table tr:last-child td:last-child {
	-moz-border-radius-bottomright: 3px;
	-webkit-border-bottom-right-radius: 3px;
	border-bottom-right-radius: 3px;
}

table tr:hover td {
	background: #f2f2f2;
	background: -webkit-gradient(linear, left top, left bottom, from(#f2f2f2),
		to(#f0f0f0));
	background: -moz-linear-gradient(top, #f2f2f2, #f0f0f0);
}
</style>


<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function del(param) {
		frm.seq.value = param
		if (confirm("정말 삭제하시겠습니까?")) {
			frm.submit();
		}
	}

	function GoContents(param) {
		frm2.seq.value = param;
		frm2.submit();
	}
</script>

</head>
<jsp:include page="/common/template/header.jsp" />
<body>
	<form id="frm2" name="frm2" action="BoardContents.do" method="post">
		<input type="hidden" id="seq" name="seq">
	</form>

	<form action="BoardDelete.do" id="frm" name="frm" method="post">
		<input type="hidden" id="seq" name="seq" />
	</form>
	<div align="center">
		<h1>후기 게시판</h1>

		<c:if test="${loginId != null }">
			<div> 
				<button onclick="location.href='BoardInsertPath.do'">후기 등록</button>
			</div>
		</c:if>
		<div>
			<table>
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>작성일자</th>
					<th>작성ID</th>
					<th>평점</th>
					<th>추천</th>
					<c:if test="${loginId==admin && loginId != null }">
						<th>게시판 관리</th>
					</c:if>
				</tr>

				<c:forEach items="${Board }" var="Board">
					<tr>
						<td onclick="GoContents('${Board.seq}')">${Board.seq}</td>
						<td onclick="GoContents('${Board.seq}')">${Board.title}</td>
						<td onclick="GoContents('${Board.seq}')">${Board.regdt}</td>
						<td onclick="GoContents('${Board.seq}')">${Board.id}</td>
						<td  onclick="GoContents('${Board.seq}')">
						<c:forEach begin="1" end="${Board.star}" step="1">
						<img src="board/starImage/star.png"
						width="25" height="25" onerror="this.style.display='none';"/>
						</c:forEach>
						</td>
						<td onclick="GoContents('${Board.seq}')">${Board.recommand}</td>
						<c:if test="${loginId=='admin'}">
							<td><button type="button" onclick="del('${Board.seq }')">삭제</button></td>
						</c:if>
					</tr>
				</c:forEach>
			</table>
			<button type="button" onclick="location.href='main.do'">홈으로</button>
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