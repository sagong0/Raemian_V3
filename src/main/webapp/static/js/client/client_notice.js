function pageFn(currentPage, searchType, keyword){
    const url = `${ctx}/notices?page=${currentPage}&searchType=${encodeURIComponent(searchType)}&keyword=${encodeURIComponent(keyword)}`;
    window.location.href = url;
}

function searchFn(){
    const keyword = document.getElementById("searchWord").value.trim();

    const url = ctx + "/notices?keyword=" + encodeURIComponent(keyword);
    window.location.href = url;
}