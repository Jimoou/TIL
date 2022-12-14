# SQL stored procedure

## <span style="color: green">stored function</span>
- 사용자 정의한 프시
- RDBMS에 저장되고 사용되는 프로시저
- 구체적인 하나의 태스크(task)를 수행한다.

- 이외에도 조건문을 통해 분기처리를 하거나
- 반복문을 수행하거나
- 에러를 핸들링하거나 에러를 일으키는 등의 다양한 로직을 정의할 수 있다.
### <span style="color: green">stored function 예제</span>

<b>1.두 정수의 곱셈 결과를 가져오는 프로시저를 작성하자</b>

```java
mysql> delimiter $$
mysql> CREATE PROCEDURE product (IN a int, IN b int, OUT result int)
    -> BEGIN
    ->      SET result = a * b;
    -> END
    -> $$
mysql> delimiter ;
```

<b>1-1.작성한 프로시저 사용하기</b>

```java
//사용
mysql> call product(5, 7, @result);
//조회
mysql> select @result;
```

<b>2.두 정수를 맞바꾸는 프로시저를 작성하자</b>

```java
mysql> delimiter $$
mysql> CREATE PROCEDURE swap(INOUT a int, INOUT b int)
    -> BEGIN
    ->     set @temp = a;
    ->     set a = b;
    ->     set b = @temp;
    -> END
    -> $$
mysql> delimiter ;
```

<b>2-1.작성한 프로시저 사용하기</b>

```java
//입력
mysql> set @a = 5, @b = 7;

//호출
mysql> call swap(@a, @b);

//조회
mysql> select @a, @b;
```

<b>3.각 부서별 평균 연봉을 가져오는 프로시저를 작성하자</b>

```java
mysql> delimiter $$
mysql> CREATE PROCEDURE get_dept_avg_salary()
    -> BEGIN
    ->     select dept_id, avg(salary)
    ->     from employee
    ->     group by dept_id;
    -> END
    -> $$
mysql> delimiter ;
```

<b>3-1.작성한 프로시저 사용하기</b>

```java
//호출
mysql> call get_dept_avg_salary();
```

<b>4.사용자가 프로필 닉네임을 바꾸면 이전 닉네임을 로그에 저장하고 새 닉네임으로 업데이트하는 프로시저를 작성하자</b>

```java
mysql> deleimiter $$
mysql> CREATE PROCEDURE change_nickname(user_id INT, new_nick varchar(30))
    -> BEGIN
    ->     insert into nickname_logs (
    ->      select id, nickname, now() from users where id = user_id
    ->     );
    ->     update users set nickname = new_nick where id = user_id;
    -> END
    -> $$
mysql> delimiter ;
```

<b>4-1.작성한 프로시저 사용하기</b>

```java
//호출
mysql> call change_nickname(1, 'ZIDANE');

//조회
mysql> select * from users;

//로그 조회
mysql> select *from nickname_logs;
```

## <span style="color: green">stored function vs stored function</span>

||STORED PROCEDURE|STORED FUNCTION|
|:-:|:-:|:-:|
|create 문법|CREATE PROCEDURE...|CREATE FUNCTION...|
|return 키워드로 값 반환|불가능<br>(SQL server는 상태코드 반환용으로는 사용 가능)|가능<br>(MySQL, SQL server는 값 반환하려면 필수)|
|파라미터로 값(들) 반환|가능<br>(값(들)을 반환하려면 필수)|일부 가능<br>(Orcale 가능하나 권장 안함, postgreSQL 가능)|
|값을 꼭 반환해야 하나?|필수 아님|필수|
|SQL statement에서 호출|불가능|가능|
|transaction 사용|가능|대부분 불가능<br>(oracle의 경우 가능)|
|주된 사용 목적|business logic|computation|

![출처 : 쉬운코드] (https://youtu.be/m2jx18yg8EA)