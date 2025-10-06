document.getElementById("saveBtn").addEventListener("click", async () => {
    const form = document.getElementById("noticeForm");

    // CKEditor의 textarea 내용을 실제 textarea에 반영
    if (window.CKEDITOR && CKEDITOR.instances.editor1) {
        CKEDITOR.instances.editor1.updateElement();
    }

    // 값 추출
    const ntitle = form.ntitle.value.trim();
    const nwriter = form.nwriter.value.trim();
    const ncontent = form.ncontent.value.trim();
    const nfile = form.nfile.files[0]; // 선택 안 했으면 undefined

    // 필수값 체크
    if (!ntitle || !nwriter || !ncontent) {
        alert("제목, 글쓴이, 내용을 모두 입력해 주세요.");
        return;
    }

    // FormData 생성
    const formData = new FormData();
    formData.append("ntitle", ntitle);
    formData.append("nwriter", nwriter);
    formData.append("ncontent", ncontent);

    if (nfile) {
        formData.append("nfile", nfile);
    }

    try {
        const response = await fetch(`${contextPath}/admin/notice/write`, {
            method: "POST",
            body: formData
        });

        // FAIL
        // 2xx 또는 3xx(리다이렉트)도 성공으로 처리
        if (!(response.ok || (response.status >= 300 && response.status < 400))) {
            throw new Error("서버 오류");
        }


        // SUCCESS
        alert("공지사항이 등록되었습니다.");
        location.href = `${contextPath}/admin/notice`; // 등록 후 목록 이동
    } catch (err) {
        console.error(err);
        alert("등록에 실패했습니다.");
    }
});
