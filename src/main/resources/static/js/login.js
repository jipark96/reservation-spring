document.addEventListener('DOMContentLoaded', () => {
    const loginForm = document.getElementById('loginForm');
    const responseMessage = document.getElementById('responseMessage');

    loginForm.addEventListener('submit', async (event) => {
        event.preventDefault();

        // 입력된 이메일과 비밀번호 값 가져옴
        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;

        // 서버에 로그인 요청을 보내기 위해 fetch
        const response = await fetch('/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({email, password}),
        });

        // 서버로부터 응답을 JSON 형식으로 받음
        const data = await response.json();

        if (data.message === "로그인 성공") {
            // 로그인 성공 시
            responseMessage.textContent = '로그인 성공!';
            responseMessage.style.color = 'green';

            // 세션에 있는 member 객체를 클라이언트에 저장
            sessionStorage.setItem('member', JSON.stringify(data.member));  // 서버에서 받은 member 정보를 클라이언트에 저장

            // 로그인 후 홈 페이지로 리디렉션
            window.location.href = '/';
        } else {
            // 로그인 실패 시
            responseMessage.textContent = data.message;
            responseMessage.style.color = 'red';
        }
    });
});
