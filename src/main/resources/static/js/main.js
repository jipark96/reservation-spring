document.addEventListener('DOMContentLoaded', () => {
    const usernameElement = document.getElementById('username');
    const loginLinks = document.getElementById('loginLinks');
    const logoutButton = document.getElementById('logoutButton');
    const logoutBtn = document.getElementById('logoutBtn');
    const signupLink = document.getElementById('signupLink'); // 회원가입 링크 요소 추가

    // sessionStorage에서 member 객체를 가져옴
    const member = JSON.parse(sessionStorage.getItem('member'));

    if (member) {
        // 로그인 상태일 경우, 사용자 이름 표시
        usernameElement.textContent = member.name;

        // 로그인 상태일 때, 로그인 링크 숨기고 로그아웃 버튼 표시
        loginLinks.style.display = 'none';
        logoutButton.style.display = 'block';

        // 로그인 상태일 때, 회원가입 링크도 숨기기
        signupLink.style.display = 'none'; // 회원가입 링크 숨기기

        // 로그아웃 버튼 클릭 시 처리
        // logoutBtn.addEventListener('click', async () => {
        //     const response = await fetch('/logout', {
        //         method: 'POST',
        //         headers: {
        //             'Content-Type': 'application/json',
        //         },
        //     });
        //
        //     const data = await response.json();
        //     if (data.message === "Logout successful") {
        //         // 로그아웃 성공 시 세션에서 정보 삭제하고 페이지 리로드
        //         sessionStorage.removeItem('member'); // 세션에서 member 삭제
        //         window.location.href = '/'; // 리디렉션하여 홈 페이지로 이동 (리로드 대신 리디렉션)
        //     }
        // });


        logoutBtn.addEventListener('click', () => {
            // 클라이언트 측에서 세션 삭제
            sessionStorage.removeItem('member');
            window.location.href = '/';  // 리디렉션하여 홈 페이지로 이동
        });

    } else {
        // 로그인되지 않은 상태일 경우, 로그인 링크 표시
        usernameElement.textContent = '로그인되지 않음';
        loginLinks.style.display = 'block';
        logoutButton.style.display = 'none';

        // 로그인되지 않은 상태일 경우, 회원가입 링크 표시
        signupLink.style.display = 'block'; // 회원가입 링크 표시
    }
});
