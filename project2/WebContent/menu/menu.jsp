<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

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
<script>
	function total(price) {		
		var value = parseInt(price);
		
		var sum = parseInt(document.frm.sum.value); 
		sum += value;
		document.frm.sum.value = sum;		
	}
	
	function amount(name, price){
		var value = parseInt(price);
		var mname = document.frm.menuname.value;
		
		var amount = parseInt(document.frm.amount.value); 
	 	amount += value/value;
	 	
		document.frm.amount.value = amount;		
		mname = name;
		if(mname == null){
			
		}else{
			
		}
		
	}

	
	/*  function order(name){
		var menuname = document.frm.menuname.value;
		var value = 0;
		
		var amount = parseInt(document.frm.amount.value); 
			value ++;
			
			document.frm.amount.value= value;
	}  */
	
	
</script>
</head>
<jsp:include page="/common/template/header.jsp" />
<div align="center">

	<form name="frm" action="Order.do" method="post">
		<table border="1">
			<tr>
				<td colspan="2">메뉴목록</td>
			</tr>
			<c:forEach items="${menuList }" var="vo">
				<tr onclick="total(${vo.mPrice}); amount('${vo.mName }', '${vo.mPrice}');">
					<td>${vo.mName }</td>					
					<td><img src="menu/image/${vo.fileName}" width="300"
               height="200" /></td>
					<td>${vo.mPrice }원</td>
					
				</tr>
			</c:forEach>
		</table>
		<c:forEach var="menu" items="b">
		<br> 메뉴:<input type="text" name="menuname" id="menuname" readonly>
		수량:<input type="text" readonly name="amount" id="amount" value="0" >
		</c:forEach>
		<hr>
		<br> 합계:<input type="text" readonly name="sum" id="sum" value="0">
		<button type="submit">주문하기</button>
	</form>
</div>
<jsp:include page="/common/template/footer.jsp" />
</html>