window 인증방법
keypair파일 우클릭 속성 -> 보안탭 -> 고급 -> 상속사용안함 체크 후 현재 접속된 계정을 제외한 나머지 계정을 전부 삭제

https://console.toast.com/

ssh -i nhnacademy-ijh.pem ubuntu@125.6.40.193 -> 우분투로 접속

scp -i nhnacademy-ijh.pem ubuntu@125.6.40.193:http.cap . ->  로컬로 파일 가져오기 (우분투아님)