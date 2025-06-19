/**
 * 삭제 `PART
 */
function del_member(mid){
    if(confirm("해당 회원을 삭제하시겠습니까 ?")){
        fetch(`${contextPath}/admin/userList/delete?mid=${mid}`, {
            method: 'POST'
        })
            .then(res => res.text())
            .then(result => {
                if(result === "OK"){
                    location.reload();
                }
                else {
                    alert("다시 시도해주세요.");
                }
            });
    }
}

/**
 * PageNation
 */
function memberPagination(currentPage, searchType, keyword){
    const url = `${contextPath}/admin/userList?page=${currentPage}&searchType=${encodeURIComponent(searchType)}&keyword=${encodeURIComponent(keyword)}`;
    window.location.href = url;
}
