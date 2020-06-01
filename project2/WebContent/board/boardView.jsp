<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
body
{
   line-height: 1.6em;
}

#hor-minimalist-a
{
   font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
   font-size: 12px;
   background: #fff;
   margin: 45px;
   width: 480px;
   border-collapse: collapse;
   text-align: left;
}
#hor-minimalist-a th
{
   font-size: 14px;
   font-weight: normal;
   color: #039;
   padding: 10px 8px;
   border-bottom: 2px solid #6678b1;
}
#hor-minimalist-a td
{
   color: #669;
   padding: 9px 8px 0px 8px;
}
#hor-minimalist-a tbody tr:hover td
{
   color: #009;
}
div .title .insert .frm {
text_align: center;
}

</style>
</head>
<jsp:include page="/common/template/header.jsp" />
<body>
	<form action="BoardUpdate.do" method="POST">
		글번호: <input name="seq" value="${vo.seq}" type="hidden">
		제목: <input type="text" name="title" id="title" value="${vo.title}"/> <br/>
		본문:<br/> <textarea cols="35" rows="12" name="contents" id="contents">${vo.contents}</textarea><br/> 
		작성자: <input type="text" name="id" id="id" value="${vo.id}"/> <br/>
		<input type="submit" value="작성"/> 
		<a href="BoardDelete.do?seq=${vo.seq}">삭제</a>
		
	</form>
</body>
<jsp:include page="/common/template/footer.jsp" />
</html>