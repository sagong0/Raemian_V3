function filterAdminsByArea(){
    const selectedArea = document.getElementById("aarea").value;
    console.log(selectedArea);

    location.href = ctx + "/admin/member?aarea=" + selectedArea;
}