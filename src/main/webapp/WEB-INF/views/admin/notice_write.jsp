<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/page_default.css?v=<%=System.currentTimeMillis()%>">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/admin_css.css?v=<%=System.currentTimeMillis()%>">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
    <!-- 신규추가된 css 파일 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/notice.css?v=<%=System.currentTimeMillis()%>">
    <!-- 신규추가된 css 파일 끝-->
    <title>관리자 페이지</title>
    <script>
    </script>
</head>
<body>
<%@include file="/WEB-INF/views/admin/fragments/header.jsp" %>
<!-- 공지사항 등록 시작 -->
<main class="page_main">
    <section class="page_section">
        <div class="listbody">
            <div class="protitle">공지사항 등록</div>
            <form id="noticeForm" enctype="multipart/form-data">
                <div class="procho">
                    <section class="data_listsview">
                        <ol>
                            <li>공지제목</li>
                            <li><input type="text" name="ntitle" class="notice_in in1"></li>
                            <li>글쓴이</li>
                            <li>
                                <input type="text" name="nwriter" class="notice_in in2" value="" readonly>
                            </li>
                            <li style="height:520px;">내용</li>
                            <li style="height:520px; padding-top: 10px;">
                                <textarea id="editor1" name="ncontent" class="notice_in in3"></textarea>
                            </li>
                            <li>첨부파일</li>
                            <li>
                                <input type="file" name="nfile" id="nfile">
                            </li>
                        </ol>
                        <span class="notice_btns">
	       <input type="button" value="글등록" id="writeBtn" class="meno_btn2">
	       </span>
                    </section>
                </div>
            </form>
        </div>
    </section>
</main>

<!-- 공지사항 등록 끝 -->
<%@include file="/WEB-INF/views/admin/fragments/footer.jsp" %>

<script src="https://cdn.ckeditor.com/4.22.1/standard/ckeditor.js"></script>
<script>
    CKEDITOR.replace("editor1");
</script>

<script src="${pageContext.request.contextPath}/static/js/notice.js?v=<%=System.currentTimeMillis()%>"></script>
</body>
</html>