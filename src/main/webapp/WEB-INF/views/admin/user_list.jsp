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
<!-- 회원관리 시작 -->
<main class="page_main">
    <section class="page_section">
        <div class="listbody">
            <div class="protitle">회원 관리</div>
            <div class="procho">
                <section class="search_part">
                    <ol >
                        <li>회원 검색</li>
                        <li>
                            <form method="get" action="${pageContext.request.contextPath}/admin/userList">
                                <select id="searchType" name="searchType" class="search_select">
                                    <option value="userid" ${searchConDTO.searchType == 'userid' ? 'selected' : ''} >아이디</option>
                                    <option value="username" ${searchConDTO.searchType == 'username' ? 'selected' : ''}>이름</option>
                                    <option value="phone_number" ${searchConDTO.searchType == 'phone_number' ? 'selected' : ''}>연락처</option>
                                </select>
                                <input type="text" name="keyword" class="search_input" value="${searchConDTO.keyword}">
                                <input type="submit" id="searchBtn" value="검색" class="datebtn">
                            </form>
                        </li>
                        <li></li>
                        <li></li>
                    </ol>
                </section>
                <section class="member_listsview">
                    <ul>
                        <li>번호</li>
                        <li>아이디</li>
                        <li>고객명</li>
                        <li>연락처</li>
                        <li>이메일</li>
                        <li>주소</li>
                        <li>이메일</li>
                        <li>전화</li>
                        <li>우편물</li>
                        <li>SMS</li>
                        <li>삭제</li>
                    </ul>

                    <c:if test="${not empty pageInfo.list}">
                        <c:forEach var="user" items="${pageInfo.list}" varStatus="loop">
                            <ul>
                                <li>${loop.index+1}</li>
                                <li>${user.mid}</li>
                                <li>${user.mname}</li>
                                <li>${user.mtel}</li>
                                <li>${user.memail}</li>
                                <li style="justify-content: flex-start;">${user.mstreetaddr}</li>
                                <li>${user.agreeEmail}</li>
                                <li>${user.agreeTel}</li>
                                <li>${user.agreePost}</li>
                                <li>${user.agreeSms}</li>
                                <li>
                                    <input type="button" onclick="del_member('${user.mid}')" value="삭제" id="delBtn" class="delbtn">
                                </li>
                            </ul>
                        </c:forEach>
                    </c:if>

                    <c:if test="${empty pageInfo}">
                        <ul class="nodatas">
                            <li>등록된 회원이 없습니다.</li>
                        </ul>
                    </c:if>


                    <aside>
                        <c:if test="${not empty pageInfo}">
                            <div class="page_number">
                                <ul>
                                    <!-- 이전 버튼 -->
                                    <c:if test="${pageInfo.currentPage > 1}">
                                        <li onclick="memberPagination('${pageInfo.currentPage - 1}',
                                                '${searchConDTO.searchType}', '${searchConDTO.keyword}')">
                                            <a>←</a>
                                        </li>
                                    </c:if>

                                    <!-- 현재 페이지 -->
                                    <li class="active" onclick="memberPagination('${pageInfo.currentPage}',
                                            '${empty searchConDTO.searchType ? '' : searchConDTO.searchType}',
                                            '${empty searchConDTO.keyword ? '' : searchConDTO.keyword }')">
                                        <a>${pageInfo.currentPage}</a>
                                    </li>

                                    <!-- 다음 버튼 -->
                                    <c:if test="${pageInfo.currentPage * pageInfo.pageSize < pageInfo.totalCount}">
                                        <li onclick="memberPagination('${pageInfo.currentPage + 1}',
                                                '${searchConDTO.searchType}', '${searchConDTO.keyword}')">
                                            <a>→</a>
                                        </li>
                                    </c:if>
                                </ul>
                            </div>
                        </c:if>
                    </aside>
                </section>
            </div>
        </div>
    </section>
</main>
<!-- 회원관리 끝 -->
<%@include file="/WEB-INF/views/admin/fragments/footer.jsp" %>
<c:if test="${not empty msg}">
    <script>alert("${msg}");</script>
</c:if>

<script>
    const contextPath = '${pageContext.request.contextPath}';
</script>

<script src="${pageContext.request.contextPath}/static/js/user_list.js?v=<%=System.currentTimeMillis()%>"></script>
</body>
</html>