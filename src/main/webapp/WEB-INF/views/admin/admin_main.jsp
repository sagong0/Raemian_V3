<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/css/admin_css.css?v=<%=System.currentTimeMillis()%>">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/css/page_default.css?v=<%=System.currentTimeMillis()%>">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
    <title>관리자 페이지</title>
</head>
<body>
<%@ include file="/WEB-INF/views/admin/fragments/header.jsp" %>


<main>
    <section>
        <div class="ad_top"></div>

        <div class="ad_mainall">
            <div class="ad_main">
                <!-- 일반회원 리스트 시작(추가) -->
                <div class="ad_main1">
                    <ul>
                        <li class="ad_maintitle">일반회원</li>
                        <li class="ad_mainbox">
                            <ol>
                                <li>아이디</li>
                                <li>고객명</li>
                                <li>연락처</li>
                                <li>이메일</li>
                                <li>주소</li>
                            </ol>

                            <c:if test="${not empty Users}">
                                <c:forEach var="user" items="${Users}" varStatus="loop">
                                    <ol class="bgcancel">
                                        <li>${user.mid}</li>
                                        <li>${user.mname}</li>
                                        <li>${user.mtel }</li>
                                        <li>${user.memail }</li>
                                        <li style="text-align: left;">${user.mstreetaddr}</li>
                                    </ol>
                                </c:forEach>
                            </c:if>
                        </li>
                    </ul>
                </div>
                <!-- 일반회원 리스트 끝(추가) -->
            </div>
            <div class="ad_main">
                <div class="ad_main1">
                    <ul>
                        <li class="ad_maintitle">1:1 문의사항</li>
                        <li class="ad_mainbox"></li>
                    </ul>
                </div>
            </div>
            <div class="ad_main">
                <div class="ad_main1">
                    <ul>
                        <li class="ad_maintitle">예약현황</li>
                        <li class="ad_mainbox2">
                            <ol>
                                <li>아이디</li>
                                <li>고객명</li>
                                <li>연락처</li>
                                <li>예약일자</li>
                                <li>예약시간</li>
                                <li>예약인원</li>
                            </ol>


                            <c:forEach var="reserve" items="${reserves}">
                                <ol class="bgcancel">
                                    <li>${reserve.userId}</li>
                                    <li>${reserve.userName}</li>
                                    <li>${reserve.userTell}</li>
                                    <li>${reserve.rdate}</li>
                                    <li>${reserve.rtime}</li>
                                    <li>${reserve.rcount}명</li>
                                </ol>
                            </c:forEach>


                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- 관리자 메인 파트 끝 -->
        <div class="ad_botom"></div>
    </section>
</main>
<%@ include file="/WEB-INF/views/admin/fragments/footer.jsp" %>
</body>
</html>