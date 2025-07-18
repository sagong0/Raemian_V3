<%@ page import="org.example.ramian_pj.dto.AdminMemberDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    AdminMemberDTO adminMember = (AdminMemberDTO) session.getAttribute("admin");
%>

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
            <li class="topmenu3"><%=adminMember.getName()%>님 환영합니다<a href="${pageContext.request.contextPath}/admin/logout">[로그아웃]</a></li
        </ul>
    </div>
    <div class="menuline"></div>
</nav>