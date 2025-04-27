

/**
 * 관리자 회원가입 PART
 */

var joinBtn = document.getElementById("adm_ok");
var emailRx = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
var nameAndIdRx = /^[가-힣]*$/; // 한글만 허용하는 정규표현식
var idDoubleCheck = false;

joinBtn.addEventListener("click", function (e) {
    e.preventDefault();

    if (joinForm.aarea.value == "") {
        alert("소속 지역을 선택하여 주세요.");
    } else if (joinForm.adept.value == "") {
        alert("부서를 선택해주세요.");
    } else if (joinForm.aposition.value == "") {
        alert("관리자 직책을 선택하여 주세요.");
    } else if (joinForm.aname.value == "") {
        alert("관리자 성함을 입력해주세요.");
        joinForm.aname.focus();
    } else if (!nameAndIdRx.test(joinForm.aname.value)) {
        alert("관리자 성함을 확인해주세요.");
    } else if (joinForm.aid.value === "") {
        alert("사용하실 아이디를 입력해주세요.");
        joinForm.aid.focus();
    } else if (!idDoubleCheck) {
        alert("아이디 중복 확인을 해주세요.");
    } else if (joinForm.apw1.value == "") {
        alert("사용하실 패스워드를 입력해주세요.");
        joinForm.apw1.focus();
    } else if (joinForm.apw1.value.length < 6) {
        alert("6자 이상의 패스워드를 입력해주세요.");
        joinForm.apw1.focus();
    } else if (joinForm.apw2.value == "") {
        alert("패스워드 확인을 입력해주세요.");
        joinForm.apw2.focus();
    } else if (joinForm.apw1.value != joinForm.apw2.value) {
        alert("비밀번호를 확인해주세요");
        joinForm.apw1.focus();
    } else if (joinForm.aemail.value == "") {
        alert("사용하실 이메일을 입력해주세요.");
        joinForm.aemail.focus();
    } else if (!emailRx.test(joinForm.aemail.value)) {
        alert("올바른 이메일 형식을 사용해주세요.");
        joinForm.aemail.focus();
    }
    else if (joinForm.atell1.value == "") {
        alert("전화번호를 입력해주세요.");
        joinForm.atell.focus();
    }
    else if (joinForm.atell2.value == "") {
        alert("전화번호를 입력해주세요.");
        joinForm.atell.focus();
    }
    else if (joinForm.atell3.value == "") {
        alert("전화번호를 입력해주세요.");
        joinForm.atell.focus();
    }
    else if (isNaN(joinForm.atell1.value)) {
        alert("전화번호 형식을 확인해주세요.");
        joinForm.atell.focus();
    }
    else if (isNaN(joinForm.atell2.value)) {
        alert("전화번호 형식을 확인해주세요.");
        joinForm.atell.focus();
    }
    else if (isNaN(joinForm.atell3.value)) {
        alert("전화번호 형식을 확인해주세요.");
        joinForm.atell.focus();
    }
    else {
        save_admin();
    }
});

const phoneFullRx = /^01[016789]-\d{3,4}-\d{4}$/; // 휴대폰 번호 포맷 정규식

function save_admin() {
    if (confirm("관리자 등록을 하시겠습니까?")) {

        // Form Submit 하기 직전 전화번호 합치는 PART
        const tel1 = joinForm.atell1.value.trim();
        const tel2 = joinForm.atell2.value.trim();
        const tel3 = joinForm.atell3.value.trim();
        
        const fullTell = `${tel1}-${tel2}-${tel3}`;
        if(!phoneFullRx.test(fullTell)){
            alert("전화번호 형식 확인해주세요.");
            return;
        }
        joinForm.atell.value = fullTell; 
        joinForm.method = "POST";
        joinForm.action = "";
        joinForm.enctype = "application/x-www-form-urlencoded";
        joinForm.submit();
    }
}


/**
 * ID 중복체크 PART
 */
var idRx = /^[a-zA-Z0-9]*$/; // 영문자와 숫자만 허용하는 정규식
var idBtn = document.getElementById("ck_idBtn");
idBtn.addEventListener("click", function (e) {
    e.preventDefault();
    if (joinForm.aid.value == "") {
        alert("사용하실 아이디를 입력해주세요.");
    } else if (!idRx.test(joinForm.aid.value)) {
        alert("아이디는 영문자만 사용 가능합니다.");
        joinForm.aid.value = "";
        joinForm.aid.focus();
    } else if (joinForm.aid.value.length < 6) {
        alert("6자 이상의 아이디를 사용해 주세요.");
        joinForm.aid.focus();
    } else {
        fetch('/admin/id_ck', {
            method: 'POST',
            headers: {
                'Content-Type': 'text/plain'
            },
            body: joinForm.aid.value
        })
            .then(response => response.text())
            .then(data => {
                data = data.trim();
                console.log(data);
                if (data === "can_use") {
                    idDoubleCheck = true;
                    alert("사용 가능한 아이디입니다.");
                    joinForm.aid.readOnly = "readOnly";
                } else if (data === "no_use") {
                    alert("이미 사용중인 아이디입니다.");
                }
            })
            .catch(error => {
                console.error('Error:', error);
            });
    }
});
 
 
 