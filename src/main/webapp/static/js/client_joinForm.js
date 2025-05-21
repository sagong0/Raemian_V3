/* 아이디 중복화인 PART */
var id_regex = /^[a-zA-Z0-9]+$/;
var idCheck = false;

document.getElementById("checkIdBtn")
    .addEventListener("click", function () {
        var mid = document.getElementById("mid").value;

        if (mid === "") {
            alert("사용하실 아이디를 입력해주세요.");
            joinForm.mid.focus();
        } else if (!id_regex.test(mid)) {
            alert("아이디는 영문과 숫자만 사용 가능합니다.");
            joinForm.mid.focus();
        } else {
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
                    } else {
                        alert("이미 사용중인 아이디입니다.");
                        joinForm.mid.focus();
                    }

                })
                .catch(e => {
                    alert(e);
                });
        }

    });


/**
 * 휴대전화 인증번호 PART
 */
const phonePattern = /^\d{3}\d{3,4}\d{4}$/;

document.getElementById("sendSmsBtn")
    .addEventListener("click", function () {
        // 버튼 클릭시의 값
        const phoneNumber = document.getElementById('mtel').value;

        if (phoneNumber === "") {
            alert("휴대번호를 입력해주세요.");
            joinForm.mtel.focus();
            return;
        } else if (!phonePattern.test(phoneNumber)) {
            alert("올바른 휴대번호를 입력해주세요.");
            joinForm.mtel.focus();
            return;
        } else {
            requestCode(phoneNumber);
        }
    });

function requestCode(phoneNumber) {
    fetch('/sendDummyCode', {
        method: 'POST',
        headers: {'Content-Type': 'application/x-www-form-urlencoded'},
        body: `phoneNumber=${encodeURIComponent(phoneNumber)}`
    })
        .then(response => {
            if (!response.ok) {
                return response.json().then(err => {
                    throw new Error("다시 시도 - 네트워크 오류")
                });
            }
            return response.json();
        })
        .then(result => {
            console.log(result)
            alert(`${result.message} : ${result.code}`);
        })
        .catch(error => alert(`오류 : ${error}`));
}













