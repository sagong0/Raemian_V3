<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- header -->
	<header id="hd">
		<div class="top_menu">
	        <ul class="top_menu_list">
	        <c:choose>
			    <c:when test="${empty sessionScope.mainMember}">
			        <!-- 세션에 로그인 정보가 없는 경우 -->
			        <li><a href="/raemian/client/login">로그인</a></li>
			        <li><a href="/raemian/client/agree">회원가입</a></li>
			        <li><a href="/raemian/faqs/">FAQ</a></li>
			        <li><a href="/raemian/notices/">공지사항</a></li>
			    </c:when>
			    <c:otherwise>
			        <!-- 세션에 로그인 정보가 있는 경우 -->
			       <c:set var="member" value="${sessionScope.mainMember}" />
			        <li><a href="#">${member.mname}님 환영합니다.
			        <a href="/raemian/client/logOut">[로그아웃]</a>
			        </a></li>
			        <li><a href="/raemian/faqs/">FAQ</a></li>
			        <li><a href="/raemian/notices/">공지사항</a></li>
			    </c:otherwise>
			</c:choose>
		    </ul>
    	</div>
        <div class="top">
            <h1><a href="" class="icon-hd-logo"></a></h1>
            <nav id="gnb">
                <li>
                    <a href=""><span>사업정보</span></a>
                    <ul>
                        <li><a href="/raemian/client/sub01">지구안내</a></li>
                        <li><a href="/raemian/client/sub02">입지안내</a></li>
                        <li><a href="">지역조감도</a></li>
                    </ul>
                </li>
                <li>
                    <a href=""><span>단지정보</span></a>
                    <ul>
                        <li><a href="/raemian/client/sub03">단지안내</a></li>
                        <li><a href="">시스템</a></li>
                        <li><a href="">단지배치도</a></li>
                        <li><a href="">동호배치도</a></li>
                    </ul>
                </li>
                <li>
                    <a href=""><span>세대정보</span></a>
                    <ul>
                        <li><a href="">타입별 평면도</a></li>
                        <li><a href="">인테리어</a></li>
						<li><a href="">사이버모델하우스</a></li>
						<li><a href="">인테리어마감재</a></li>
                    </ul>
                </li>
                <li>
                    <a href=""><span>공급정보</span></a>
                    <ul>
                       <li><a href="">입주자 모집공고</a></li>
                        <li><a href="">E-카달로그</a></li>
                         <li><a href="">공급일정 안내</a></li>
                        <li><a href="">오시는 길</a></li>
                      <li><a href="">청약접수 안내</a></li>
                    </ul>
                </li>
                <li>
                    <a href=""><span>사전방문예약</span></a>
                    <ul>
                        <li><a href="/raemian/client/reserve">사전방문예약</a></li>
                        <li><a href="/raemian/client/reserve/modify">사전방문예약확인</a></li>
                        <li><a href="/raemian/client/reserve/cancel">사전방문예약취소</a></li>
                    </ul>
                </li>
            </nav>
        </div>
	</header>
	<!--// header -->
    