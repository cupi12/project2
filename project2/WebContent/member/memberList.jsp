<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<jsp:include page="/common/template/header.jsp"/>
<body>
<div align="center">
	<div>
	<h1>회원 목록</h1>
	</div>
<form name="searchfrm">
   <input name="p" value="1" type="hidden">
 
  <samp> ID </samp><input name="id"/><br>
  <samp>성별</samp>  <samp> <select name="gender">
         <option value="">전체</option>
         <option value="m">남자</option>
         <option value="f">여자</option></samp>
      </select>
   <button>검색</button>
</form>	
	
	<div>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>나이</th>
				<th>성별</th>
				<th>전화번호</th>
				<th>가입날짜</th>
			</tr>
			<%--  <c:forEach var="member" items="${memberList}"> 
				<tr>
				<td>${member.id}</td>
				<td>${member.pwd}</td>
				<td>${member.name}</td>
				<td>${member.age}</td>
				<td>${member.gender}</td>
				<td>${member.phone}</td>
				<td> <fmt:parseDate value="${member.regdt}" var="fmtRd" pattern="yyyy-MM-dd"/>
         			 <fmt:formatDate value="${fmtRd}" pattern="yyyy-MM-dd"/></td>
				</tr>
			 </c:forEach>  --%>
		</table>
	</div>	
	<div>
		<button type="button" onclick="location.href='main.do'">홈으로</button>
	</div>
	
	<script type="text/javascript">
   function gopage(p) {
      document.searchfrm.p.value = p;
      document.searchfrm.submit();
      //location.href="EmpList.do?p="+p;
   }
</script>
	
	
</body>
<jsp:include page="/common/template/footer.jsp"/>
</html>