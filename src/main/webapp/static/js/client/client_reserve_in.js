document.getElementById("reserveBtn").addEventListener("click", () => {
    const form = document.getElementById("reserveForm");

    // 세션 값 확인
    const userId = form.querySelector('input[name="rid"]').value;
    const userName = form.querySelector('input[name="rname"]').value;

    if (!userId || !userName) {
        alert('로그인 후 신청할 수 있습니다.');
        location.href = `${ctx}/login`;
        return;
    }

    // 2. 인원수 체크 여부
    const rcount = form.querySelector('input[name="rcount"]:checked');

    if (!rcount) {
        alert('인원 수를 선택해주세요.');
        return;
    }

    // 3. 예약일자와 시간 필수값 체크
    const rdate = form.querySelector('input[name="rdate"]').value;
    const rtime = form.querySelector('select[name="rtime"]').value;

    if (!rdate) {
        alert('예약일자를 입력해주세요.');
        return;
    }

    if (!rtime) {
        alert('예약시간을 선택해주세요.');
        return;
    }

    // 4. 예약일자 오늘 이전일 경우 반려
    const selectedDate = new Date(rdate);
    const today = new Date();
    today.setDate(0, 0, 0, 0);

    if(selectedDate < today){
        alert("오늘 이전 날짜로는 예약이 불가능합니다.");
        return;
    }

    // 모든 검증 통과
    // 5. Form 데이터 전송 (AJAX)
    const formData = new FormData(form);

    fetch(`${ctx}/reserve`, {
        method: 'POST',
        body: formData
    })
        .then(response => {
            if (response.ok) {
                return response.text();
            }
            throw new Error('예약 요청 실패');
        })
        .then(result => {
            if(result === "success"){
                alert('예약이 완료되었습니다.');
                window.location.href = `${ctx}/`; // 메인 페이지로 이동
            }
            else {
                console.log(result);
                alert("예약 실패...");
                return;
            }

        })
        .catch(error => {
            console.error(error);
            alert('예약에 실패했습니다. 다시 시도해주세요.');
        });
});