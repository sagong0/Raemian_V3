/**
 * 전체 동의 체크 박스
 */
function allagree(ck){
    const checkboxes = document.querySelectorAll('.agree-check');

    checkboxes.forEach(
        cb => cb.checked = ck
    );
}


// function updateAgree(){
//     const allAgree = document.querySelector('.all-agree');
//     const checks = document.querySelectorAll('.agree-check');
//
//     allAgree.checked = Array.from(checks).every(ch => ch.checked);
// }

