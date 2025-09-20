/**
 * 예약 취소
 * */

document.getElementById("cancelBtn")
    .addEventListener("click", () => {
        if(confirm("예약 수정은 1회만 가능합니다. 수정 하시겠습니까?")){
            document.getElementById("cancelForm")
                .submit();
        }
    });