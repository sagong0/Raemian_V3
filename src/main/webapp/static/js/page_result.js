/**
 * 로그인 처리
 */
var loginBtn = document.getElementById("loginBtn");
loginBtn.addEventListener("click", function (e) {
    e.preventDefault();

    if (ad_loginForm.aid.value === "") {
        alert("관리자 아이디를 입력해주세요");
        ad_loginForm.aid.focus();
    } else if (ad_loginForm.apw.value === "") {
        alert("관리자 비밀번호를 입력해주세요.");
        ad_loginForm.apw.focus();
    } else {
        login();
    }
});

function login() {
    ad_loginForm.method = "POST";
    ad_loginForm.action = "";
    ad_loginForm.submit();
}



// 회원가입 Button Click !
document.getElementById("member_add").addEventListener("click", function (e) {
    e.preventDefault();
    if(confirm("회원가입 페이지로 이동하시겠습니까 ?")){
       location.href = "/admin/join";
    }
})