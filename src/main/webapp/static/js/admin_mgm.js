function filterAdminsByArea() {
    const area = document.getElementById('aarea').value;

    const params = new URLSearchParams({
        aarea: area,
        // 아래 값들은 현재 검색/정렬/페이지 크기를 유지
        keyword: "${fn:escapeXml(searchConDTO.keyword)}",
        searchType: "${searchConDTO.searchType}",
        sortBy: "${searchConDTO.sortBy}",
        order: "${searchConDTO.order}",
        pageSize: "${searchConDTO.pageSize}",
        page: 1 // 소속 바뀌면 1페이지로
    });

    location.href = ctx + "/admin/member?" + params.toString();
}