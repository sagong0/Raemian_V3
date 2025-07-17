// 글쓰기 버튼
document.getElementById("writeBtn").addEventListener("click", ()=>{
    location.href = ctx + "/admin/notice/write";
});



function searchNotice(){
    const keyword = document.getElementById('keyword').value.trim();

    const url = ctx + "/admin/notice?keyword=" + encodeURIComponent(keyword);
    window.location.href = url;
}


