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


// 근무중, 퇴직중 AJAX 처리
async function applyAdmin(id) {
    const status = document.getElementById('status' + id).value;
    if (!confirm(`${status}으로 변경하시겠습니까?`)) return;

    try {
        const res = await fetch(`${ctx}/admin/member/status`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
            body: new URLSearchParams({ id, status }).toString()
        });
        if (!res.ok) throw new Error(`HTTP ${res.status}`);

        const text = await res.text();
        if (text === 'OK') {
            alert('상태가 변경되었습니다.');
            location.reload();
        } else {
            alert('변경 실패: ' + text);
        }
    } catch (e) {
        console.error(e);
        alert('요청 중 오류가 발생했습니다.');
    }

    
}

// 전체 버튼
document.getElementById("allBtn")
    .addEventListener("click", ()=>{
    location.href = ctx + "/admin/member/";
});