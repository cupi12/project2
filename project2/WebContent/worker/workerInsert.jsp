<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>


<body>

<h3 align ="center">직원 등록 페이지</h3>
<form action ="WorkerMemberInsert.do" align="center" method="post" enctype = "multijpart/form-data"></form>

번호 : <input type = ""><br>                                             <!-- 데이터 타입  -->
직원이름 : <input type = "text" name = "wname" id="wname"><br>
근무시작 : <input type = "text" name = "wstart id="wstart"><br>             <!-- 데이터 타입 date -->
근무종료 : <input type = "text" name = "wend" id="wend"><br>                <!-- 데이터 타입 date -->
근무시간 : <input type = "text" name = "totaltime" id = "totaltime"><br>    <!-- 데이터 타입 number -->
급여 : <input type = "money" name = "money" id = "money">               <!-- 데이터 타입 number -->
<br>
<br>

<button type = "submit"> 등록 하기 </button>
<button type = "submit"> 수정 하기 </button>
<button type = "submit"> 삭제 하기 </button>
 
</form>
</body>
</html>