/**
 * 예약 수정 PART
 */

document.getElementById("modifyBtn")
    .addEventListener("click", () => {
        if(confirm("예약 수정은 1회만 가능합니다. 수정 하시겠습니까?")){
            document.getElementById("modifyForm")
                .submit();
        }
    });