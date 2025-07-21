<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/page_default.css?v=<%=System.currentTimeMillis()%>">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/admin_css.css/?v=<%=System.currentTimeMillis()%>">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
    <!-- 신규추가된 css 파일 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/notice.css?v=<%=System.currentTimeMillis()%>">
    <!-- 신규추가된 css 파일 끝-->
    <title>관리자 페이지</title>
    <script>
    </script>
</head>
<body>
<%@include file="/WEB-INF/views/client/fragments/header.jsp" %>
<!-- 공지사항 등록 시작 -->
<main class="page_main">
    <section class="page_section">
        <div class="listbody">
            <div class="protitle">공지사항 확인</div>
            <div class="procho">
                <section class="data_listsview">
                    <ol>
                        <li>공지제목</li>
                        <li class="text_in"></li>
                        <li>글쓴이</li>
                        <li class="text_in"></li>
                        <li style="height:520px;">내용</li>
                        <li style="height:520px; padding-top: 10px;">
                            <div class="text_in2"></div>
                        </li>
                        <li>첨부파일</li>
                        <li class="text_in" style="cursor: pointer;" onclick="redirectToUrl('${notice.nfile}')"></li>
                    </ol>
                    <span class="notice_btns">
       <input type="button" value="목록" class="meno_btn2" >
       </span>
                </section>
            </div>
        </div>
    </section>
</main>

<!-- 공지사항 등록 끝 -->
<%@include file="/WEB-INF/views/client/fragments/footer.jsp"%>
</body>
</html>