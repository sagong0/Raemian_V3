// 글쓰기 버튼
document.getElementById("writeBtn").addEventListener("click", ()=>{
    location.href = ctx + "/admin/notice/write";
});



function searchNotice(){
    const keyword = document.getElementById('keyword').value.trim();

    const url = ctx + "/admin/notice?keyword=" + encodeURIComponent(keyword);
    window.location.href = url;
}


/**
 * PageNation
 */
function noticePagination(currentPage, searchType, keyword) {
    const url = `${ctx}/admin/notice?page=${currentPage}&searchType=${encodeURIComponent(searchType)}&keyword=${encodeURIComponent(keyword)}`;
    window.location.href = url;
}


/**
 * 삭제 `PART
 */
function del_notice(nid){
    if(confirm("공지사항을 삭제하시겠습니까 ?")){
        fetch(`${ctx}/admin/notice/delete?nid=${nid}`, {
            method: 'POST'
        })
            .then(res => res.text())
            .then(result => {
                if(result === "OK"){
                    alert("삭제 되었습니다.");
                    location.reload();
                }
                else {
                    alert("다시 시도해주세요.");
                }
            });
    }
}

/**
 * 상세 페이지
 * @param nidx
 */
function noticeDetail(nidx){
    const url = `${ctx}/admin/notice/` + nidx;
    window.location.href = url;
}