# DataGrip과 DOCKER Database 생성, 연동하기 (MySQL, MariaDB)

## 1. 마리아 이미지 다운로드
(이미 다운로드 되어있다면, 2번으로.)

```java
docker pull maria db
```

## 2. mariadb 컨테이너 생성

### 2-1. 생성 안되어 있을 때.

#### 2-1 CASE 1. 터미널로 생성하기

```java
docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1234 --name mariadb_container mariadb
```

![sql터미널 생성](./sql%20%EC%97%B0%EB%8F%99.png)

#### 2-1 CASE 2. 도커로 생성하기

[images]카테고리에 들어가서 생성할 데이터베이스의 런버튼을 누르면

![sql도커 생성](./sql%EC%97%B0%EB%8F%991.png)

요런 화면이 뜹니다. 앞서 터미널에서 설정해준것처럼 아래 양식을 채워 run을 누르면 컨테이너가 생성됩니다.

![sql도커 생성2](./sql%20%EC%97%B0%EB%8F%992.png)

### 2-1. 이미 생성되어 있을 때

![sql도커생성3](./sql%EC%97%B0%EB%8F%993.png)

생성하고 나면 위 사진과 같이 컨테이너가 만들어진걸 확인할 수 있습니다. 그럼 이제 데이터그립과 연동하기 위한 과정을 진행해봅시다.

## 3. DataGrip과 연동하기

### 3-1. DB와 USER 생성

#### 3-2. 터미널에서 생성하기
도커를 사용하실 분은 3-2-2 번으로 가시면 됩니다.

#### 3-2-1. docker 진입하기

```java
docker exec -i 내가만든 컨테이너 이름 /bin/bash
```
#### 3-2-2. mysql shell 진입하기

```java
mysql -u root -p
```

위 명령어를 입력해주고 앞서 설정한 비밀번호를 입력해줍니다.
(주의할 점은 sql진입 명령어와 앞으로 만들어줄 유저의 비밀번호와 혼동되지 않게 설정해주셔야 합니다.)

### 3-2. database 생성 및 한글 설정

```java
CREATE DATABASE 데이터베이스이름 DEFAULT CHARCTER SET utf8 COLLATE utf8_general_ci;
```

### 3-3. USER 생성

```java
CREATE USER '유저이름'@'%' identified by '비밀번호';
```

#### 3-3-1. 사용자에게 권한 설정

```java
grant all privileges on 데이터베이스 이름.* to '유저이름'@'%';
```

이제 DataGrip과 연결만 하면 됩니다.

## 4. DataGrip과 DB 연결하기

### 4-1. 컨테이너 실행하기

![도커연동](./sql%20%EC%97%B0%EB%8F%994.png)

도커를 열고 컨테이너를 가동시켜야 연결이 가능합니다.
컨테이너가 실행중이지 않을때는 연결이 끊깁니다.
추후 연동을 하고 나서도 컨테이너의 실행이 중지되면, 연결이 끊깁니다.

### 4-2. 컨테이너와 연동하기

![도커연동](./sql%20%EC%97%B0%EB%8F%995.png)

좌측 상단에 위치한 추가버튼을 눌러 mariadb를 실행합니다.

![도커연동](./sql%20%EC%97%B0%EB%8F%996.png)

위 양식을 채워넣고 Apply, Ok를 누르면 생성이 됩니다.


