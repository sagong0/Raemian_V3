// 현재 휴대전화 인증 여부
var isAuthenticated = false;

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
                    if (resp.trim() === "can_use") {
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
 * 휴대전화 인증번호 발송 PART
 */
const phonePattern = /^\d{3}\d{3,4}\d{4}$/;
var isPhoneRegexCheck = false;

// 사용자 전화번호 수정 --> inPhoneRegaxCheck 다시 false 처리

document.getElementById('mtel').addEventListener('input', function () {
    // 사용자가 번호를 수정했으므로 재검증 필요
    isPhoneRegexCheck = false;
    // 사용자가 번호를 수정했으므로 인증여부도 재 인증 필요
    isAuthenticated = false;
});

document.getElementById("sendSmsBtn")
    .addEventListener("click", function () {
        // 버튼 클릭시의 값
        const phoneNumber = document.getElementById('mtel').value;

        if (phoneNumber === "") {
            alert("휴대번호를 입력해주세요.");
            joinForm.mtel.focus();
            isPhoneRegexCheck = false;
            return;
        } else if (!phonePattern.test(phoneNumber)) {
            alert("올바른 휴대번호를 입력해주세요.");
            joinForm.mtel.focus();
            isPhoneRegexCheck = false;
            return;
        } else {
            isPhoneRegexCheck = true;
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

/**
 * 인증번호 - 인증완료 PART
 */
document.getElementById("checkSms")
    .addEventListener("click", function () {
        const phoneNumber = document.getElementById('mtel').value;
        const inputCode = document.getElementById('certification_num').value;

        if(inputCode === ""){
            alert("인증번호를 입력해주세요.");
            document.getElementById('certification_num').focus();
            return;
        }

        fetch('/checkDummyCode', {
            method: 'POST',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            body: `phoneNumber=${encodeURIComponent(phoneNumber)}&inputCode=${encodeURIComponent(inputCode)}`
        })
            .then(response => {
                return response.json().then(data =>{
                    if(!response.ok){
                        throw new Error(data.message);
                    }
                    return data;
                });
            })
            .then(result => {
                alert(result.message);
                // 인증 상태 true
                isAuthenticated = true;
            })
            .catch(e => alert(e));
    });



// 회원가입 Button Click PART
document.getElementById("joinBtn").addEventListener("click", function () {
    const form = document.getElementById("joinForm");

    const name = form.mname.value.trim();
    const userid = form.mid.value.trim();
    const pw = form.mpw.value.trim();
    const pw2 = form.mpw2.value.trim();
    const phone = form.mtel.value.trim();
    const smsCode = form.certification_num.value.trim();
    const email = form.memail.value.trim();
    const zipcode = form.mzipcode.value.trim();
    const streetAddr = form.mstreetaddr.value.trim();
    const detailAddr = form.mdetailaddr.value.trim();

    const nameRegex = /^[가-힣]+$/;

    // 빈 값 체크
    if (!name || !userid || !pw || !pw2 || !phone || !smsCode || !email || !zipcode || !streetAddr || !detailAddr) {
        alert("모든 필수 입력 항목을 입력해 주세요.");
        return;
    }
    if(!nameRegex.test(name)){
        alert("이름을 확인해주세요.");
        form.mname.focus();
        return;
    }
    if(!idCheck){
        alert("아이디 중복 체크를 진행해주세요.");
        return;
    }

    // 비밀번호 확인 일치 여부
    if (pw !== pw2) {
        alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
        return;
    }

    // 휴대폰 번호 숫자 체크
    if (!isPhoneRegexCheck) {
        alert("휴대폰 번호는 숫자만 입력해야 합니다.");
        return;
    }
    if(!isAuthenticated){
        alert("휴대전화 인증 진행해주세요.");
        return;
    }

    // 이메일 형식 확인 (간단하게)
    if (!/^[\w-.]+@[\w-]+\.[a-z]{2,}$/i.test(email)) {
        alert("이메일 형식이 올바르지 않습니다.");
        return;
    }

    
    // 마케팅 checkbox 부분
    ["agreeEmail", "agreeTel", "agreePost", "agreeSms"].forEach(function (id) {
        const checkbox = document.getElementById(id);
        if (checkbox && checkbox.checked) {
            checkbox.value = "Y";
        }
        // 미 체크시
        else {
            const hiddenInput = document.createElement("input");
            hiddenInput.type = "hidden";
            hiddenInput.name = id;
            hiddenInput.value = "N"
            document.getElementById("joinForm").appendChild(hiddenInput);
        }
    });

    // 모든 검증 통과 → 폼 제출
    form.action="/join";
    form.method="POST";
    form.submit();
});








