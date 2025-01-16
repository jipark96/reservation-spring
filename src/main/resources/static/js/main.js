document.addEventListener('DOMContentLoaded', () => {
    const usernameElement = document.getElementById('username');

    // sessionStorage에서 member 객체를 가져옴
    const member = JSON.parse(sessionStorage.getItem('member'));

    if (member) {
        // member 객체에 저장된 사용자 이름을 표시
        usernameElement.textContent = member.name;
    } else {
        usernameElement.textContent = '로그인되지 않음';
    }
});
