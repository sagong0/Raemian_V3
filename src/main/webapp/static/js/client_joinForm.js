/* 아이디 중복화인 PART */
var id_regex = /^[a-zA-Z0-9]+$/;
var idCheck = false;

document.getElementById("checkIdBtn")
    .addEventListener("click", function () {
        var mid = document.getElementById("mid").value;

        if(mid === ""){
            alert("사용하실 아이디를 입력해주세요.");
            joinForm.mid.focus();
        } else if(!id_regex.test(mid)){
            alert("아이디는 영문과 숫자만 사용 가능합니다.");
            joinForm.mid.focus();
        } else{
            fetch('/id_check', {
                method: 'POST',
                headers: {
                    'Content-Type': 'text/plain'
                },
                body: mid,
            })
                .then(response => {
                    if (!response.ok) {
                        throw new Error(response.statusText);
                    }
                    return response.text();
                })
                .then(resp => {
                    if (resp === "can_use") {
                        alert("사용 가능한 아이디입니다.");
                        joinForm.mid.readOnly = "readOnly";
                        idCheck = true;
                    } else{
                        alert("이미 사용중인 아이디입니다.");
                        joinForm.mid.focus();
                    }

                })
                .catch(e => {
                    alert(e);
                });
        }

});