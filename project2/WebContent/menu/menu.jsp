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
	text-align: center;
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
	text-align: center;
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
<script src="https://code.jquery.com/jquery-latest.js"></script>

<style>
/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 15% auto; /* 15% from the top and centered */
	padding: 20px;
	border: 1px solid #888;
	width: 30%; /* Could be more or less, depending on screen size */
}
</style>



<!-- The Modal -->
<div id="myModal" class="modal">

	<!-- Modal content -->
	<div class="modal-content">
		<p style="text-align: center;">
			<span style="font-size: 14pt;"><b><span
					style="font-size: 24pt;">공지</span></b></span>
		</p>

		<p style="text-align: center; line-height: 1.5;">
			<br />
		</p>
		<p>
			<br />
		</p>
		<div
			style="cursor: pointer; background-color: #DDDDDD; text-align: center; padding-bottom: 10px; padding-top: 10px;"
			onClick="close_pop();">
			<span class="pop_bt" style="font-size: 13pt;"> 닫기 </span>
		</div>
	</div>

</div>
<!--End Modal-->
<script>

    $(function (){
        var IMP = window.IMP; // 생략가능
        IMP.init('iamport'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
        var msg;
        
        IMP.request_pay({
            pg : 'kakaopay',
            pay_method : 'card',
            merchant_uid : 'merchant_' + new Date().getTime(),
            name : '동해감자국밥',
            amount : param,
            buyer_email : 'yedam@ac.kr',
            buyer_name : '서강',
            buyer_tel : '010-1598-1521',
            buyer_addr : '대구 곽병원',
            buyer_postcode : '123-456',
            //m_redirect_url : 'http://www.naver.com'
        }, function(rsp) {
            if ( rsp.success ) {
                //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
                jQuery.ajax({
                    url: "/payments/complete", //cross-domain error가 발생하지 않도록 주의해주세요
                    type: 'POST',
                    dataType: 'json',
                    data: {
                        imp_uid : rsp.imp_uid
                        //기타 필요한 데이터가 있으면 추가 전달
                    }
                }).done(function(data) {
                    //[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
                    if ( everythings_fine ) {
                        msg = '결제가 완료되었습니다.';
                        msg += '\n고유ID : ' + rsp.imp_uid;
                        msg += '\n상점 거래ID : ' + rsp.merchant_uid;
                        msg += '\결제 금액 : ' + rsp.paid_amount;
                        msg += '카드 승인번호 : ' + rsp.apply_num;
                        
                        alert(msg);
                    } else {
                        //[3] 아직 제대로 결제가 되지 않았습니다.
                        //[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
                    }
                });
                //성공시 이동할 페이지
                location.href='<%=request.getContextPath()%>/order/paySuccess?msg='+msg;
            } else {
                msg = '결제에 실패하였습니다.';
                msg += '에러내용 : ' + rsp.error_msg;
                //실패시 이동할 페이지
                location.href="<%=request.getContextPath()%>/order/payFail";
                alert(msg);
            }
        });
        
    });

    </script>

<script type="text/javascript">


     function modal(){
        jQuery(document).ready(function() {
                $('#myModal').show();
        });
     }
        //팝업 Close 기능
        function close_pop(flag) {
             $('#myModal').hide();
        };
      
        
      </script>



<script>

	function total(price) {		
		var value = parseInt(price);
		
		var sum = parseInt(document.frm.sum.value); 
		sum += value;
		document.frm.sum.value = sum;		
	}
	
	function amount(name, price){
		var value = parseInt(price);	
		var amount = parseInt(document.frm.amount.value);
	 	amount += value/value;
	 	
	 	if(name != document.frm.menuname){	 	
		document.frm.amount.value = amount;			
		document.frm.menuname.value = name;
	 	}
		
	}

	
	/*   function order(name){
		var menuname = document.frm.menuname.value;
		var value = 0;
		
		var amount = parseInt(document.frm.amount.value); 
			value ++;name
			
			document.frm.amount.value= value;
	}          */    
	
  /*       function add(param) { //늘어나게함
		if(param ==frm.menuname.value){
			
            $('.buttons').append (                        
                '<br>메뉴:<input type="text" name="menuname"> 수량<input type="text" name="amount"> '                    
            ); // end append/*  
		}
        }; // end add() 
	 */
</script>
</head>
<jsp:include page="/common/template/header.jsp" />
<div align="center">
	<c:if test=""></c:if>
	<form name="frm" action="Pay.do" method="post">
		<table border="1">
			<tr>
				<td colspan="3">메뉴목록</td>
			</tr>
			<c:forEach items="${menuList}" var="vo">
				<c:if test="${vo.mName }==frm.menuname.value">
					<tr class="btnAdd">
				</c:if>
				<tr class="btnAdd"
					onclick="total(${vo.mPrice}); amount('${vo.mName }', '${vo.mPrice}'); add('${vo.mName }');">

					<td>${vo.mName }</td>

					<td><img src="menu/image/${vo.fileName}" width="300"
						height="200" /></td>
					<td>${vo.mPrice }원</td>

				</tr>
			</c:forEach>
		</table>
		<form>
		<c:forEach var="menu" items="b">
			<div class="buttons">
				<br> 메뉴:<input type="text" name="menuname" id="menuname"
					readonly> 수량:<input type="text" readonly name="amount"
					id="amount" value="0">
			</div>
		</c:forEach>
		<hr>  
		<br> 합계:<input type="text" readonly name="sum" id="sum" value="0">
		<button type="button" onclick="pay('${frm.sum.value}')">주문</button>
		</form>
		<br>
		<button type="button" onclick="IMP.request_pay(amount,paid_amount))">test</button>
		
	</form>
</div>
<jsp:include page="/common/template/footer.jsp" />
</html>