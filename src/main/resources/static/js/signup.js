document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('signupForm').addEventListener('submit', function(event) {
        event.preventDefault(); // 기본 폼 제출 동작 방지

        // 폼 데이터 가져오기
        const name = document.getElementById('name').value;
        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;
        const phone = document.getElementById('phone').value;

        // 회원가입 데이터 객체 생성
        const memberData = {
            name: name,
            email: email,
            password: password,
            phone: phone
        };

        // Fetch API를 사용하여 서버에 POST 요청 보내기
        fetch('http://localhost:8080/member', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(memberData)
        })
            .then(response => {
                // 응답 상태 코드 확인
                if (response.ok) {
                    return response.text(); // 정상 응답일 때 텍스트로 반환
                } else {
                    return response.text().then(text => {
                        throw new Error(text); // 실패 시 에러 메시지 반환
                    });
                }
            })
            .then(data => {
                // 성공 시 메시지 표시
                document.getElementById('responseMessage').innerText = '회원가입 성공!';
            })
            .catch(error => {
                // 실패 시 메시지 표시
                document.getElementById('responseMessage').innerText = error.message || '회원가입에 실패했습니다. 다시 시도해주세요.';
            });
    });
});
