<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
    <meta property="og:type" content="website">
    <meta property="og:title" content="인천검단 레미안">
    <title>인천검단 레미안</title>
    <!-- css -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/client/normalize.css?v=<%=System.currentTimeMillis()%>">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/client/slick.css?v=<%=System.currentTimeMillis()%>">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/client/swiper.min.css?v=<%=System.currentTimeMillis()%>">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/client/bootstrap.min.css?v=<%=System.currentTimeMillis()%>">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/client/cal-style.css?v=<%=System.currentTimeMillis()%>">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/client/common.css?v=<%=System.currentTimeMillis()%>">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/client/sweetalert.min.css?v=<%=System.currentTimeMillis()%>">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js?v=<%=System.currentTimeMillis()%>"></script>
    <script src="${pageContext.request.contextPath}/static/css/js/bootstrap.min.js"></script>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/client/top.css?v=<%=System.currentTimeMillis()%>">

    <!-- 추가된 css -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/client/new_member.css?v=<%=System.currentTimeMillis()%>">
    <!-- 추가된 css -->
</head>

<body>
<!-- wrap -->
<div id="wrap">
    <!-- header 로고 & 대메뉴,소메뉴 -->
    <%@include file="/WEB-INF/views/client/fragments/header.jsp" %>
    <!-- header 로고 & 대메뉴,소메뉴 끝 -->


    <div id="container">
        <div id="index">

            <!-- 로그인 화면 시작 -->
            <label class="mbship_title">
                <p>MEMBER-LOGIN</p>
                <ul>
                    <li>로그인하시면, 회원 별 다양한 맞춤 서비스를 이용하실 수 있습니다.</li>
                </ul>
            </label>

            <form id="loginForm">
                <fieldset class="mbship_box">
        <span class="agree_span">
        <ul class="mblogin">
            <li><img src="${pageContext.request.contextPath}/static/img/client/mainlogin.png"></li>
            <li>
                <span>EXPERIENCE OF PRIDE <br> LOGIN</span>
                <span>

                    <ol class="login_ols">
                        <li><input type="text" name="aid" class="login_input" placeholder="아이디를 입력하세요"></li>
                        <li><input type="password" name="apw" class="login_input"  placeholder="패스워드를 입력하세요"></li>
                        <li><button type="submit" id="loginBtn" class="login_btn1">로그인</button></li>
                        <li><button type="button" id="joinBtn" class="login_btn2">회원가입</button></li>
                        <li style="cursor: pointer;">아이디 찾기 / 비밀번호 찾기</li>
                        <!-- 로그인 validation 실패 메세지 출력 PART -->
                        <c:if test="${not empty loginFail}">
                            <c:forEach var="err" items="${loginFail}">
                                <div style="color:red; text-align:center; font-size:14px;">
                                        ${err}<br/>
                                </div>
                            </c:forEach>
                        </c:if>
                    </ol>
                </span>
            </li>
        </ul>
        </span>
                </fieldset>

            </form>
            <!-- 로그인 화면 종료 -->
        </div>
        <!-- 카피라이터 시작 -->
        <%@include file="/WEB-INF/views/client/fragments/footer.jsp" %>
        <!-- 카피라이터 종료 -->



    </div>
</div>
</body>

<script src="${pageContext.request.contextPath}/static/js/client/client_login.js?v=<%=System.currentTimeMillis()%>"></script>
</html>
