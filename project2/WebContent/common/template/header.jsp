<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link
	href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900"
	rel="stylesheet" />
<link href="common/template/default.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="common/template/fonts.css" rel="stylesheet" type="text/css"
	media="all" />

<!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->
<script>
	function logout() {
		if (confirm("정말 로그아웃 하시겠습니까?")) {
			location.href = "Logout.do";
		}
	}

</script>
</head>
<body>

	<div id="header-wrapper">
		<div id="header" class="container">
			<div id="logo" align="center">
				<h1>
					<a href="main.do">동해감자국밥</a>
				</h1>
			</div>
		</div>
		<div id="menu-wrapper">
			<div id="menu" class="container" align="right">
				<ul>
					<c:if test="${loginId == null }">
						<li><a href="Menu.do">메뉴</a></li>
						<li><a href="BoardList.do">후기</a></li>
						<li><a href="common/login.jsp">로그인</a></li>
						<li><a href="MemberInsertMenu.do">회원가입</a></li>
					</c:if>
					<!-- 사용자메뉴 -->

					<c:if test="${loginId != null }">
						<c:if test="${loginId !='admin'}">
							<li><a href="Menu.do">메뉴</a></li>
							<li><a href="Pay.do">결제</a></li>
							<li><a href="BoardList.do">후기</a></li>
							<li ><a href="MemberUpdateView.do?id=${loginId }">정보수정</a></li>
							<li><a href="Logout.do" onclick="logout()">로그아웃</a></li>
						</c:if>
					</c:if>

					<!-- admin메뉴 -->
					<c:if test="${loginId == 'admin'}">
						<li><a href="AdminMenu.do">메뉴관리</a></li>
						<li><a href="MemberList.do">회원관리</a></li>
						<li><a href="BoardList.do">게시판 관리</a></li>
						<li><a href="StoreManage.do">매장관리</a></li>
						<li><a href="AdminWorkerEdit.do">직원관리</a></li>
						<li><a href="MemoList.do">직원메모</a></li>
						<li><a href="Logout.do" onclick="logout()">로그아웃</a></li>
					</c:if>


				</ul>
			</div>
		</div>
	</div>
	<div id="wrapper2">
		<div id="portfolio" class="container">
</html>
<%-- 사용하실때<jsp:include page="/common/template/header.jsp"/> --%>