<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
</head>
<body>
<%@include file="/WEB-INF/views/admin/fragments/header.jsp" %>
<!-- 관리자 리스트 시작 -->
<main class="page_main">
    <section class="page_section">
        <form id="frm" name="frm" method="post" onsubmit="return member_search();">
            <div class="listbody">
                <div class="adlisttitle">관리자 현황</div>
                <div class="procho">
                    <ul>
                        <li class="prochoL procfont">소속</li>
                        <li class="prochoL">
                            <select class="adlistcsel1" name="aarea" id="aarea" onchange="filterAdminsByArea()">
                                <option value="all" ${searchConDTO.aarea == 'all' ? 'selected' : ''}>전체</option>
                                <option value="본사" ${searchConDTO.aarea == '본사' ? 'selected' : ''}>본사</option>
                                <option value="경기도" ${searchConDTO.aarea == '경기도' ? 'selected' : ''}>경기도</option>
                                <option value="인천" ${searchConDTO.aarea == '인천' ? 'selected' : ''}>인천</option>
                                <option value="대전" ${searchConDTO.aarea == '대전' ? 'selected' : ''}>대전</option>
                                <option value="세종" ${searchConDTO.aarea == '세종' ? 'selected' : ''}>세종</option>
                                <option value="광주" ${searchConDTO.aarea == '광주' ? 'selected' : ''}>광주</option>
                                <option value="대구" ${searchConDTO.aarea == '대구' ? 'selected' : ''}>대구</option>
                                <option value="울산" ${searchConDTO.aarea == '울산' ? 'selected' : ''}>울산</option>
                                <option value="전라남도" ${searchConDTO.aarea == '전라남도' ? 'selected' : ''}>전라남도</option>
                                <option value="전라북도" ${searchConDTO.aarea == '전라북도' ? 'selected' : ''}>전라북도</option>
                                <option value="충청남도" ${searchConDTO.aarea == '충청남도' ? 'selected' : ''}>충청남도</option>
                                <option value="충청북도" ${searchConDTO.aarea == '충청북도' ? 'selected' : ''}>충청북도</option>
                                <option value="경상남도" ${searchConDTO.aarea == '경상남도' ? 'selected' : ''}>경상남도</option>
                                <option value="경상북도" ${searchConDTO.aarea == '경상북도' ? 'selected' : ''}>경상북도</option>
                                <option value="제주도" ${searchConDTO.aarea == '제주도' ? 'selected' : ''}>제주도</option>
                            </select>
                        </li>
                    </ul>
                </div>
                <div class="procho">
                    <ul>
                        <li class="prochoL procfont">검색형식</li>
                        <li class="prochoL ">
                            <select id="searchType" class="adlistcsel1" name="search_part">
                                <option value="이름">이름</option>
                                <option value="아이디">아이디</option>
                                <option value="연락처">연락처</option>
                            </select>
                        </li>
                        <li class="prochoL">
                            <input type="text" id="searchVal" name="searchVal" class="adlistcsel1">
                        </li>
                        <li class="prochoL"><input type="submit" id="searchBtn" class="proclick" value="검색"></li>
                        <li class="prochoL"><button type="button" id="allBtn" class="proclick">전체</button></li>
                    </ul>
                </div>
                <div class="protaball">
                    <table width="1100">
                        <thead>
                        <tr style="color: white; background-color: rgb(67, 66, 66);">
                            <td class="listcenter" width=50>NO</td>
                            <td class="listcenter" width=150>구분</td>
                            <td class="listcenter" width=150>아이디</td>
                            <td class="listcenter" width=120>이름</td>
                            <td class="listcenter" width=80>직책</td>
                            <td class="listcenter" width=200>이메일</td>
                            <td class="listcenter" width=120>연락처</td>
                            <td class="listcenter" width=120>현황</td>
                            <td class="listcenter" width=110>적용</td>
                        </tr>
                        </thead>
                        <tbody>

                        <c:if test="${not empty adminPageInfo}">
                            <c:forEach var="admin" items="${adminPageInfo.list}" varStatus="loop">
                                <tr class="master_list">
                                    <td class="listcenter" width=50>${loop.index + 1}</td>
                                    <td class="listcenter" width=150>${admin.department}</td>
                                    <td class="listcenter" width=150>${admin.userid}</td>
                                    <td class="listcenter" width=120>${admin.name}</td>
                                    <td class="listcenter" width=80>${admin.position}</td>
                                    <td class="listcenter" width=200>${admin.email}</td>
                                    <td class="listcenter" width=120>${admin.phone}</td>
                                    <td class="listcenter" width=120>
                                        <select id="status${admin.id}" class="adlistsel3">
                                            <c:choose>
                                                <c:when test="${admin.deleted_at == null}">
                                                    <option selected>근무중</option>
                                                    <option>퇴직중</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option>근무중</option>
                                                    <option selected>퇴직중</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </select></td>
                                    <td class="listcenter" width=110>
                                        <button type="button" class="listclick" onclick="applyAdmin(${admin.id});">적용</button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        </tbody>
                    </table>
                </div>

                <c:if test="${not empty adminPageInfo && adminPageInfo.totalPages > 1}">
                    <div class="propagebt">
                        <ul>
                            <!-- Prev -->
                            <li style="color:white;"
                                class="${adminPageInfo.currentPage <= 1 ? 'disabled' : ''}"
                                onclick="adminPagination(${adminPageInfo.currentPage - 1})">
                                Prev
                            </li>

                            <!-- Page numbers -->
                            <c:forEach var="pNo" begin="1" end="${adminPageInfo.totalPages}" step="1">
                                <li style="color:white;"
                                    class="${pNo == adminPageInfo.currentPage ? 'active' : ''}"
                                    onclick="adminPagination(${pNo})">
                                        ${pNo}
                                </li>
                            </c:forEach>

                            <!-- Next -->
                            <li style="color:white;"
                                class="${adminPageInfo.currentPage >= adminPageInfo.totalPages ? 'disabled' : ''}"
                                onclick="adminPagination(${adminPageInfo.currentPage + 1})">
                                Next
                            </li>
                        </ul>
                    </div>
                </c:if>



            </div>
        </form>
        <!-- 관리자 리스트 끝 -->
    </section>
</main>
<%@include file="/WEB-INF/views/admin/fragments/footer.jsp" %>
<script>
    const ctx = "${pageContext.request.contextPath}";
</script>
<script src="${pageContext.request.contextPath}/static/js/admin_mgm.js?<%=System.currentTimeMillis()%>"></script>
</body>
</html>
