# SQL stored function

## <span style="color: green">stored function</span>
- 사용자가 정의한 함수
- DBMS에 저장되고 사용되는 함수
- SQL의 select, insert, update, delete statement에서 사용할 수 있다.
- loop를 돌면서 반복적인 작업을 수행하거나 case 키워드를 사용해서 값에 따라 분기 처리 하거나 에러를 핸들링하거나 에러를 일으키는 등의 다양한 동작을 정의할 수 있다.

### <span style="color: green">stored function 예제</span>
<b>1.임직원의 ID를 열자리 정수로 랜덤하게 발급하고 싶다.(ID의 맨 앞자리는 1로 고정이다.)</b>

```java
mysql> delimiter $$
mysql> CREATE FUNCTION id_generator()
    -> RETURNS int
    -> NO SQL
    -> BEGIN
    ->      RETURN (1000000000 + floor(rand()*1000000000));
    -> END
    -> $$
mysql> delimiter;
```

<b>1-1.위에서 만든 함수 id_generator()을 통해 employee 테이블에 임직원 정보를 추가함.</b>

```java
mysql> INSERT INTO employee
    -> VALUES (id_generator(), 'JEHN', '1991-08-04', 'F', 'PO', 100000000, 1005);
```

<b>2. 부서의 ID를 파라미터로 받으면 해당 부서의 평균 연봉을 알려주는 함수를 작성하자.</b>

```java
//1
mysql> delimiter $$
mysql> CREATE FUNCTION dept_avg_salary(d_id int)
    -> RETURNS int
    -> READS SQL DATA
    -> BEGIN
    ->      DECLARE avg_sal int;
    ->      select avg(salary) into avg_sal
    ->                         from employee
    ->                         where dept_id = d_id;
    ->      RETURN avg_sal;
    -> END
    -> $$
mysql> delimiter ;

//2 함수 선언하지 않고 바로 사용하기
mysql> delimiter $$
mysql> CREATE FUNCTION dept_avg_salary(d_id int)
    -> RETURNS int
    -> READS SQL DATA
    -> BEGIN
    ->      select avg(salary) into @avg_sal
    ->                         from employee
    ->                         where dept_id = d_id;
    ->      RETURN @avg_sal;
    -> END
    -> $$
mysql> delimiter ;
```

<b>2-2.만든 함수를 이용해 부서정보와 부서 평균 연봉을 함께 가져오자</b>

```java
mysql> SELECT *, dept_avg_salary(id)
    -> FROM department;
```

<b>3.졸업 요건 중 하나인 토익 800이상을 충족했는지를 알려주는 함수를 작성하자</b>

```java
//1
mysql> delimiter $$
mysql> CREATE FUNCTION toeic_pass_fail(toeic_score int)
    -> RETURNS char(4)
    -> NO SQL
    -> BEGIN
    ->      DECLARE pass_fail char(4);
    ->      IF    toeic_score is null THEN SET pass_fail = 'fail';
    ->      ELSEIF toeic_score < 800   THEN SET pass_fail = 'fail';
    ->      ELSE                           SET pass_fail = 'pass';
    ->      END IF;
    ->      RETURN pass_fail;
    -> END
    -> $$
mysql> delimiter ;

//2 함수를 선언하지 않고 사용
mysql> delimiter $$
mysql> CREATE FUNCTION toeic_pass_fail(toeic_score int)
    -> RETURNS char(4)
    -> NO SQL
    -> BEGIN
    ->      IF    toeic_score is null THEN SET @pass_fail = 'fail';
    ->      ELSEIF toeic_score < 800   THEN SET @pass_fail = 'fail';
    ->      ELSE                           SET @pass_fail = 'pass';
    ->      END IF;
    ->      RETURN @pass_fail;
    -> END
    -> $$
mysql> delimiter ;
```

<b>3-1.앞서 정의한 함수를 통해 학생 정보와 함께 토익 점수 조건을 충족했는지 여부를 같이 가져오자</b>

```java
mysql> SELECT *, toeic_pass_fail(toeic)
    -> FROM student;
```

### <span style="color: green">stored function 삭제하기</span>

```java
mysql> DROP FUNCTION stored_function_name;
```

### <span style="color: green">등록된 stored function 파악하기</span>

```java
mysql> SHOW FUNCTION STATUS where DB = [ DB_name ];
```

### <span style="color: green">어떤 function인지 파악하기</span>

```java
mysql> SHOW CREATE FUNCTION [ Funtion_name ];
```

![출처 : 쉬운코드] (https://youtu.be/I1jjR58Rzic)