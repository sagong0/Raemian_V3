let adds = document.querySelector("#member_add");
adds.addEventListener("click",function(){
   location.href="./join";
});


/**
 * 로그인 처리 
 */
var loginBtn = document.getElementById("loginBtn");
loginBtn.addEventListener("click", function(e){
	e.preventDefault();
	
	if(ad_loginForm.aid.value == ""){
		alert("관리자 아이디를 입력해주세요");
	} else if(ad_loginForm.apw.value == ""){
		alert("관리자 비밀번호를 입력해주세요.");
	} else{
		login();
	}
});

function login(){
	ad_loginForm.method = "POST";
	ad_loginForm.action = "./login";
	ad_loginForm.submit();
}