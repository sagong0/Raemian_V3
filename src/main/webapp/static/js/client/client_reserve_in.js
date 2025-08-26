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
    const rCount = form.querySelector('input[name="rCount"]:checked');

    if (!rCount) {
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
    const today = new Date();
    today.setHours(0, 0, 0, 0);

    const selectedDate = new Date(rdate);
    selectedDate.setHours(0, 0, 0, 0);

    if (selectedDate.getTime() === today.getTime()) {
        // rtime이 "14:00" 형태라고 가정
        const now = new Date();
        const [hh, mm] = rtime.split(':');
        const reserveDateTime = new Date();
        reserveDateTime.setHours(Number(hh), Number(mm), 0, 0);
        if (reserveDateTime <= now) {
            alert('현재 시간 이후의 예약시간만 선택할 수 있습니다.');
            return;
        }
    }

    // 오늘 날짜 -> 현재 이전 시간 X
    if(selectedDate.getTime() === today.getTime()){
        const now = new Date();
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
            else if(result === "exist"){
                alert("이미 예약된 회원입니다.");
                window.location.href = `${ctx}/`;
            }
            else {
                console.log(result);
                alert("예약 실패...");
            }

        })
        .catch(error => {
            console.error(error);
            alert('예약에 실패했습니다. 다시 시도해주세요.');
        });
});