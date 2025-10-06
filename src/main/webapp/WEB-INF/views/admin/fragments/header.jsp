<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<nav>
    <div class="menusize">
        <ul id="menus">
            <li class="topmenu1">ADMINISTRATOR</li>
            <li class="topmenu2"><a href="">세대정보</a></li>
            <li class="topmenu2"><a href="${pageContext.request.contextPath}/admin/userList">회원관리</a></li>
            <li class="topmenu2"><a href="${pageContext.request.contextPath}/admin/notice">공지사항 관리</a></li>
            <li class="topmenu2"><a href="">FAQ</a></li>
            <li class="topmenu2"><a href="">예약현황</a></li>
            <li class="topmenu2"><a href="">관리자현황</a></li>
            <li class="topmenu3">
                <c:choose>
                    <c:when test="${not empty sessionScope.admin}">
                        ${sessionScope.admin.name}님 환영합니다
                        <a href="${pageContext.request.contextPath}/admin/logout">[로그아웃]</a>
                    </c:when>
                    <c:otherwise>
                        <a href="${pageContext.request.contextPath}/admin">[로그인]</a>
                    </c:otherwise>
                </c:choose>
            </li>
        </ul>
    </div>
    <div class="menuline"></div>
</nav>

<c:if test="${not empty msg}">
    <script>
        alert("${fn:escapeXml(msg)}");
    </script>
</c:if>


