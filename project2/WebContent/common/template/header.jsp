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

</head>
<body>
	<div id="header-wrapper">
		<div id="header" class="container">
			<div id="logo">
				<h1>
					<a href="#">Picturesque</a>
				</h1>
			</div>
		</div>
		<div id="menu-wrapper">
			<div id="menu" class="container">
				<ul>
					<li class="current_page_item"><a href="#" accesskey="1"
						title="">메인</a></li>
					<li><a href="Login.do" accesskey="2" title="">로그인</a></li>
					<li><a href="MemberInsert.do" accesskey="2" title="">회원가입</a></li>

					<!-- 사용자메뉴 -->
					<%-- <c:if test="loginId == ${vo.getId() }"> --%>
					<li><a href="Menu.do" accesskey="2" title="">메뉴</a></li>
					<li><a href="#" accesskey="3" title="">결제</a></li>
					<li><a href="#" accesskey="4" title="">후기</a></li>
					<li><a href="" accesskey="5" title="">정보수정</a></li>
					<li><a href="Logout.do" accesskey="6" title="">로그아웃</a></li>
					<%-- </c:if> --%>

					<!-- admin메뉴 -->
					<%-- <c:if test="loginId == admin"> --%>
					<li><a href="AdminMenu.do" accesskey="7" title="">메뉴관리</a></li>
					<li><a href="MemberList.do" accesskey="8" title="">회원관리</a></li>
					<li><a href="BoardList.do" accesskey="9" title="">게시판 관리</a></li>
					<li><a href="#" accesskey="10" title="">매장관리</a></li>
					<li><a href="Logout.do" accesskey="11" title="">로그아웃</a></li>
					<%-- </c:if> --%>

				</ul>
			</div>
		</div>
	</div>
	<div id="wrapper2">
		<div id="portfolio" class="container">
</html>
<%-- 사용하실때<jsp:include page="/common/template/header.jsp"/> --%>