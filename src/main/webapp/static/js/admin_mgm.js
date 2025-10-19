function filterAdminsByArea() {
    const area = document.getElementById('aarea').value;

    const params = new URLSearchParams({
        aarea: area,
        page: 1,
        pageSize: window.SEARCH_CON.pageSize,
        sortBy: window.SEARCH_CON.sortBy,
        order: window.SEARCH_CON.order
    });

    location.href = ctx + "/admin/member?" + params.toString();
}



function adminPagination(p) {
    const total = Number(window.PAGING_TOTAL || 1);
    if (p < 1 || p > total) return;

    const aarea = document.getElementById('aarea')?.value || window.SEARCH_CON.aarea;
    const searchType = document.getElementById('searchType')?.value || window.SEARCH_CON.searchType;
    const keyword = document.getElementById('searchVal')?.value || window.SEARCH_CON.keyword;

    const params = new URLSearchParams({
        page: p,
        pageSize: window.SEARCH_CON.pageSize,
        aarea: aarea,
        searchType: searchType,
        keyword: keyword || "",
        sortBy: window.SEARCH_CON.sortBy,
        order: window.SEARCH_CON.order
    });

    location.href = ctx + "/admin/member?" + params.toString();
}

function member_search() {
    const aarea = document.getElementById('aarea')?.value || "all";
    const searchType = document.getElementById('searchType')?.value || "userid";
    const keyword = document.getElementById('searchVal')?.value || "";

    const params = new URLSearchParams({
        aarea, searchType, keyword,
        page: 1,
        pageSize: window.SEARCH_CON.pageSize,
        sortBy: window.SEARCH_CON.sortBy,
        order: window.SEARCH_CON.order
    });

    location.href = ctx + "/admin/member?" + params.toString();

    // 폼 전송은 막고, JS 처리
    return false;
}
