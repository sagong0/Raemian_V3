function pageFn(currentPage, searchType, keyword){
    const url = `${ctx}/notices?page=${currentPage}&searchType=${encodeURIComponent(searchType)}&keyword=${encodeURIComponent(keyword)}`;
    window.location.href = url;
}