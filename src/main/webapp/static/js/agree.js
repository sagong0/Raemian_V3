/**
 * 전체 동의 체크 박스
 */
function allagree(ck){
    const checkboxes = document.querySelectorAll('.agree-check');

    checkboxes.forEach(
        cb => cb.checked = ck
    );
}


function updateAgree(){
    const allAgree = document.querySelector('.all-agree');
    const checks = document.querySelectorAll('.agree-check');

    allAgree.checked = Array.from(checks).every(ch => ch.checked);
}

/* 다음단계 버튼 Click Event */
document.getElementById("nextBtn")
    .addEventListener("click", function (e) {
        const allChecked = Array
            .from(document.querySelectorAll('.agree-check'))
            .every(ch => ch.checked);
        if(!allChecked){
            alert("필수 약관에 동의해주세요.");
            return;
        }
        location.href = "/join";
    });












