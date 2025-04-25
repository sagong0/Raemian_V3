<%@ page language="java" contentType="text/html;charset=UTF-8"
        pageEncoding="UTF-8"%>

<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/admin_css.css?v=<%= System.currentTimeMillis()%>">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
    <title>관리자 페이지</title>
</head>
<body>
<div class="adbody">
    <div class="adtitle">ADMINISTRATOR</div>
    <div class="admoom">
        <form id="ad_loginForm">
            <div class="intotal">
                <div class="adin1">
                    <input type="text" class="loginid" name="aid" value="" placeholder="아이디">
                </div>
                <div class="adin2">
                    <input type="password" class="loginpass" name="apw" value="" placeholder="패스워드">
                </div>
            </div>
            <div class="adbt">
                <button type="submit" id="loginBtn" class="loginbt1">로그인</button>
                <button type="button" class="loginbt2" id="member_add">회원가입</button>
            </div>
            <div class="adinfomain">
                <ul>
                    <li class="adinfo">※ 사원번호가 없을시 관리자에게 연락 바랍니다.</li>
                    <li class="adinfo">※ 모든 정보는 기록되어 집니다.</li>
                    <li class="adinfo">※ 퇴사시 해당 정보는 접속이 불가능 하게 됩니다.</li>
                </ul>
            </div>
        </form>
    </div>

    <!-- 로그인 실패시 실패 메세지 출력 PART -->

</div>
</body>
<script src="${pageContext.request.contextPath}/static/js/page_result.js?v=<%=System.currentTimeMillis()%>"></script>
</html>