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



