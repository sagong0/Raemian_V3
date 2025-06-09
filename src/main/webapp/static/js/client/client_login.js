document.getElementById("loginBtn")
    .addEventListener("click", function () {
        if(loginForm.aid.value === ""){
            alert("아이디를 확인해주세요.");
            return;
        } else if(loginForm.apw.value==""){
            alert("패스워드 확인해주세요.");
            return;
        }
        else {
            loginForm.action = "";
            loginForm.method = "POST";
            loginForm.submit();
        }
    });