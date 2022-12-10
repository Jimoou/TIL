# SQL
- Strutured Query Language
- 현업에서 쓰이느 relational DBMS의 표준 언어
- 종합적인 database 언어 : DDL + DML + VDL

## SQL 주요 용어

|relational data model|SQL|
|-|-|
|relation|table|
|attribute|column|
|tuple|row|
|domain|domain|

## SQL에서 relation이란?
- multiset(= bag) of tuples @ SQL
- 중복된 tuple을 허용한다.

### SQL & RDBMS
- SQL은 RBMS의 표준 언어이지만 실제 구현에 강제가 없기 때문에 
RDBMS마다 제공하는 SQL의 스펙이 조금씩 다르다.

### DATABASE vs SCHEMA
- MySQL에서는 DATABASE와 SCHEMA가 같은 뜻을 의미
- CREATE DATABASE company = CREATE SCHEMA company
- 다를 RDBMS에서는 의미가 다르게 쓰임
- PostgreSQL에서는 SCHEMA가 DATABASE의 namespace를 의미

### attribute data type: 숫자
|종류|설명|사이즈|MySQL|
|:-:|:-:|:-:|:-:|
|정수|정수를 저장할 때 사용|1 byte|TINYINT|
|||2 byte|SMALLINT|
|||3 byte|MEDIUMINT|
|||4 byte|INT or INTEGER|
|||8 byte|BIGINT|
|||||
|부동 소수점 방식 <br> (floating-point) | - 실수를 저장할 때 사용 <br>  - 고정 소수점 방식에 비해 정확하지 않다. |4 byte|FLOAT|
|||8 byte|DOUBLE or DOUBLE PRECISION|
|||||
|고정 소수점 방식 <br> (fixed-point)| - 실수를 정확하게 저장할 때 사용 <br>  - DECIMAL(5,2) => [-999.99 ~ 999.99] |variable|FLOAT|
|||variable|DOUBLE or DOUBLE PRECISION|
|||||

### attribute data type: 문자열
|종류|설명|MySQL|
|:-:|:-:|:-:|
|고정 크기 문자열|- 최대 몇개의 '문자'를 가지는 문자열을 저장할지를 지정 <br> - 저장될 문자열의 길이가 최대 길이보다 작으면 나머지를 space로 채워서 저장|CHAR(n) <br> (0 <=n <= 255)|
|||||
|가변 크기 문자열|- 최대 몇개의 '문자'를 가지는 문자열을 저장할지를 지정 <br> - 저장될 문자열의 길이 만큼만 저장|VARCHAR(n) <br> (0 <=n <= 65,535)|
|||||
|사이즈가 큰 문자열|- 사이즈가 큰 문자열을 저장할 때 사용 <br> - 저장될 문자열의 길이가 최대 길이보다 작으면 나머지를 space로 채워서 저장|TINYTEXT <br> TEXT <br> MEDIUMTEXT <br> LONGTEXT|
|||||

### attribute data type: 날짜와 시간
|종류|설명|MySQL|
|:-:|:-:|:-:|
|날짜|- 년, 월, 일을 저장 <br> - YYYY-MM-DD|DATE <br> ('1000-01-01' ~ '9999-12-31')|
|시간|- 시, 분, 초를 저장 <br> - hh:mm:ss or hhh:mm:ss|TIME <br> ('-838:59:59' ~ '838:59:59')|
|날짜와 시간|- 날짜와 시간을 같이 표현 <br> - YYYY-MM-DD hh:mm:ss <br> -TIMESTAMP는 time-zone이 반영됨|DATETIME <br> ('1000-01-01 00:00:00' to '9999-12-31 23:59:59')|
|||TIMESTAMP <br> ('1970-01-01 00:00:01' UTC ~ '2038-01-19 03:14:07' UTC)|
||||

### attribute data type: 날짜와 시간
|종류|설명|MySQL|
|:-:|:-:|:-:|
|byte-string|(문자열이 아니라) byte string을 저장|BINARY <br> VARBINARY <br> BLOB type
|boolean|- true, false를 저장 <br> - MySQL에는 따로 없음|TINYINT로 대체해서 사용
|위치 관련|위치 관련 정보를 저장|GEOMETRY <br> etc|
|JSON|-json 형태의 데이터를 저장 <br> 예){"name": "messi", "age" : 38}|JSON|
||||


## Key constraints : PRIMARY KEY를 선언하는 방법
### attribute 하나로 구성될 때
```mysql
create table Player (
    id      INT     PRIMARY KEY
    ...
);
```
### attribute 하나 이상으로 구성될 때
```mysql
create table Player (
    team_id     VARCHAR(12),
    back_number INT,
    ...
    PRIMARY KEY(team_id, back_number)
);
```

## Key constraints : UNIQUE
- unique로 지정된 attribute(s)는 중복된 값을 가질 수 없다
- 단, NULL은 중복을 허용할 수도 있다. (RDBMS 마다 다름)

### UNIQUE를 선언하는 방법
#### attribute 하나로 구성될 때
```mysql
create table Player (
    id      INT     UNIQUE
    ...
);
```
#### attribute 하나 이상으로 구성될 때
```mysql
create table Player (
    team_id     VARCHAR(12),
    back_number INT,
    ...
    UNIQUE (team_id, back_number)
);
```

## NOT NULL constraint
- attribute가 NOT NULL로 지정되면 해당 attribute는 NULL을 값으로 가질 수 없다.
### NOT NULL을 선언하는 방법
```mysql
create table Student (
    ...
    phone_number INT  NOT NULL   UNIQUE,
    ...
);
```

## attribute DEFAULT
- attribute의 default 값을 정의할 때 사용
- 새로운 tuple을 저장할 때 해당 attribute에 대한 값이 없다면 default 값으로 저장

### DEFAULT를 선언하는 방법
```mysql
create table Orders (
    ...
    menu    varchar(15)     DEFAULT '짜장면',
    ...
);
```

## attribute CHECK
- attribute의 값을 제한하고 싶을 때 사용

### CHECK를 선언하는 방법
#### attribute 하나로 구성될 때
```mysql
create table EMPLOYEE (
    ...
    age    INT    CHECK (age >= 20)
);
```
#### attribute 하나 이상으로 구성될 때
```mysql
create table Player (
    start_date    DATE,
    end_date      DATE,
    ...
    CHECK (start_date < end_date)
);
```