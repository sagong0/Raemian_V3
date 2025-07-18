<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
  <meta property="og:type" content="website">
  <meta property="og:title" content="인천검단 레미안">
  <title>인천검단 레미안</title>
  <!-- css -->
  <link rel="stylesheet" type="text/css"
        href="${pageContext.request.contextPath}/static/css/client/normalize.css?v=<%=System.currentTimeMillis()%>">
  <link rel="stylesheet" type="text/css"
        href="${pageContext.request.contextPath}/static/css/client/slick.css?v=<%=System.currentTimeMillis()%>">
  <link rel="stylesheet" type="text/css"
        href="${pageContext.request.contextPath}/static/css/client/swiper.min.css?v=<%=System.currentTimeMillis()%>">
  <link rel="stylesheet" type="text/css"
        href="${pageContext.request.contextPath}/static/css/client/bootstrap.min.css?v=<%=System.currentTimeMillis()%>">
  <link rel="stylesheet" type="text/css"
        href="${pageContext.request.contextPath}/static/css/client/cal-style.css?v=<%=System.currentTimeMillis()%>">
  <link rel="stylesheet" type="text/css"
        href="${pageContext.request.contextPath}/static/css/client/common.css?v=<%=System.currentTimeMillis()%>">
  <link rel="stylesheet"
        href="${pageContext.request.contextPath}/static/css/client/sweetalert.min.css?v=<%=System.currentTimeMillis()%>">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js?v=<%=System.currentTimeMillis()%>"></script>
  <script src="${pageContext.request.contextPath}/static/css/js/bootstrap.min.js"></script>

  <link rel="stylesheet" type="text/css"
        href="${pageContext.request.contextPath}/static/css/client/top.css?v=<%=System.currentTimeMillis()%>">

  <!-- 추가된 css -->
  <link rel="stylesheet" type="text/css"
        href="${pageContext.request.contextPath}/static/css/client/new_member.css?v=<%=System.currentTimeMillis()%>">
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

      <!-- 서브 화면 시작 -->
      <label class="mbship_title">
        <p>NOTICE</p>
        <ul>
          <li>RAEMIAN 새로운 소식을 확인하세요</li>
        </ul>
      </label>
      <fieldset class="mbship_box">
        <ul>
          <li>번호</li>
          <li>제목</li>
          <li>조회수</li>
          <li>글쓴이</li>
          <li>등록일</li>
        </ul>

        <c:forEach var="notice" items="${notices}" varStatus="loop">
          <ul>
            <li>${loop.index+1}</li>
            <li style="text-align: left;">${notice.ntitle}</li>
            <li>${notice.ncount}</li>
            <li>${notice.nwriter}</li>
            <li>${notice.nindate}</li>
          </ul>
        </c:forEach>

        <span class="pages">
          <ul style="display:flex; justify-content: center">
            <c:set var="searchWord" value="${param.searchWord}" />
            <!-- Page번호 시작 -->
			<c:forEach var="pNo" begin="${list.startPage}" end="${list.endPage}" step="1">
				<li style="color:white;"
                    onclick="noticePagination(${pNo},'${not empty searchWord ? searchWord : ''}');"
                    class="<c:if test='${param.currentPage eq pNo}'>active</c:if>">
                    ${pNo}
                </li>
            </c:forEach>
            <!-- Page번호 끝 -->
          </ul>
        </span>

        <span class="search_css">
        <input type="text" id="searchWord" class="search_in" placeholder="검색할 제목을 입력하세요">
        <input type="submit" onclick="" value="검색" class="search_btn">
        </span>
      </fieldset>

      <!-- 서브 화면 종료 -->
    </div>
    <!-- 카피라이터 시작 -->
    <%@include file="/WEB-INF/views/client/fragments/footer.jsp" %>
    <!-- 카피라이터 종료 -->

  </div>
</div>
</body>
</html>
