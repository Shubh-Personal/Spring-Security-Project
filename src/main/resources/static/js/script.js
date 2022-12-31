let btn = document.getElementById('btnClicked');

let submitBtnClicked = () => {
    let inputBox = document.getElementById('studentId').value || '1';
    window.location.assign(`http://localhost:8080/api/students/${inputBox}`);
}

btn.onclick = submitBtnClicked;

