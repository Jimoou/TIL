# MySQL ERROR 1045 (28000): Access denied for user 'root' @'localhost ' (using password: YES) 해결하기

## CASE 1. 도커로 mysql을 사용중인데, 따로 sql을 다운받은 경우

도커로 mysql이미지를 다운 받았는데, 따로 mysql까지 다운받아서 포트 호스트 충돌이 나는 경우가 있습니다.
도커로 mysql을 계속 사용하실거라면 로컬에 깔린 mysql을 깔끔히 삭제하시고, 아니라면 도커를 지우시면 됩니다.

## CASE 2. 비밀번호 맞는데 왜 안돼? 한번 더 의심해보기

![도커비번](../database/sql%20%EC%97%B0%EB%8F%996.png)

간혹 User에 데이터베이스 이름을 적는다거나 아님 "root"를 적는다거나 하는 경우도 있고,
password에 mysql진입 비밀번호랑 유저 비밀번호랑 혼동하는 경우가 있습니다. 다시 한번 확인하고 진행해보세요.