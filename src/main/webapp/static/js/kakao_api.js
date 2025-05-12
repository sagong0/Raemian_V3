
    /**
    * 회원가입 Kakao API 주소 찾기 PART
    */
    function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            var addr = '';
            var extraAddr = '';

            // 도로명 또는 지번 주소 가져오기
            if (data.userSelectedType === 'R') {
                addr = data.roadAddress;
            } else {
                addr = data.jibunAddress;
            }

            // 참고항목 조합
            if(data.userSelectedType === 'R'){
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                if(extraAddr !== ''){
                    addr += ' (' + extraAddr + ')';
                }
            }

            document.getElementsByName('mzipcode')[0].value = data.zonecode;
            document.getElementsByName('mstreetaddr')[0].value = addr;
            document.getElementsByName('mdetailaddr')[0].focus();
        }
    }).open();
}

    // 버튼 클릭 시 함수 연결
    document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("findAddrBtn").addEventListener("click", function() {
        sample6_execDaumPostcode();
    });
});