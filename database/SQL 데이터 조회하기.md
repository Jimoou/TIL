# SQL 데이터 조회하기

## SELECT statement
- <b>SELECT</b> attribute(s) <b>FROM<b> table(s) <b>WHERE</b> condition(s);
### ex)
- ID가 9인 임직원의 이름과 직군을 알고 싶다.

```java
mysql> SELECT name, position FROM employee WHERE id = 9;
```

- project 2002를 leading하고 있는 임직원의 ID와 이름과 직군을 알고 싶다.

```java
mysql> SELECT employee.id, employee.name, position
    -> FROM project, employee
    -> WHERE project.id = 2002 and project.leader_id = employee.id;
```

## AS
- AS는 테이블이나 attribute에 별칭(alias)을 붙일 때 사용한다.
- AS는 생략 가능하다.

### ex)

```java
mysql> SELECT E.id, E.name, position
    -> FROM project AS P, employee AS E
    -> WHERE P.id = 2002 and P.leader_id = E.id;
```

결과

|id|name|position|
|:-:|:-:|:-:|
|13|JISUNG|PO|


```java
mysql> SELECT E.id AS leader_id, E.name AS leader_name, position
    -> FROM project AS P, employee AS E
    -> WHERE P.id = 2002 and P.leader_id = E.id;
```

결과

|leader_id|leader_name|position|
|:-:|:-:|:-:|
|13|JISUNG|PO|

<b>AS는 생략이 가능하다.</b>

```java
mysql> SELECT E.id leader_id, E.name leader_name, position
    -> FROM project P, employee E
    -> WHERE P.id = 2002 and P.leader_id = E.id;
```

결과

|leader_id|leader_name|position|
|:-:|:-:|:-:|
|13|JISUNG|PO|

## DISTINCT 사용하기
- select결과에서 중복되는 tuples은 제외하고 싶을 때 사용한다.

### ex)
- 디자이너들이 참여하고 있는 프로젝트들의 ID와 이름을 알고 싶다.

```java
mysql> SELECT P.id, P.name
    -> FROM employee AS E, works_on AS W, project AS P
    -> WHERE E.position = 'DSGN' and
    ->       E.id = W.empl_id and W.proj_id = P.id;
```

결과

|id|name|
|:-|:-|
|2002|확장성 있게 백엔드 리팩토링|
|2003|홈페이지 UI 개선|
|2003|홈페이지 UI 개선|

- DISTINCT를 통해 tuple의 중복을 제거
```java
mysql> SELECT DISTINCT P.id, P.name
    -> FROM employee AS E, works_on AS W, project AS P
    -> WHERE E.position = 'DSGN' and
    ->       E.id = W.empl_id and W.proj_id = P.id;
```

결과

|id|name|
|:-|:-|
|2002|확장성 있게 백엔드 리팩토링|
|2003|홈페이지 UI 개선|
|2003|홈페이지 UI 개선|

## LIKE 사용하기
### ex)
- 이름이 N으로 시작하거나 N으로 끝나는 임직원들의 이름을 알고 싶다.

```java
mysql> SELECT name
    -> FROM employee
    -> WHERE name LIKE 'N%' or name LIKE'%N';
```

결과

|name|
|:-:|
|BROWN|
|JOHN|
|NICOLE|

- 이름이 NG가 들어가는 임직원들의 이름을 알고 싶다.

```java
mysql> SELECT name
    -> FROM employee
    -> WHERE name LIKE '%NG%';
```

결과

|name|
|:-:|
|DINGYO|
|JISUNG|

- 이름이 J로 시작하는, 총 네 글자의 이름을 가지는 임직원들의 이름을 알고 싶다.

```java
mysql> SELECT name
    -> FROM employee
    -> WHERE name LIKE 'J___';
```

결과

|name|
|:-:|
|JANE|
|JOHN|

### escape 문자와 함께 LIKE 사용하기
- %로 시작하거나 _로 끝나는 프로젝트 이름을 찾고 싶다면?
- SELECT name FROM project WHERE name LIKE '\%%' or name LIKE '%\_';

### LIKE 정리

|항목|설명|
|:-:|:-|
|LIKE|문자열 pattern matching에 사용|
|reserved character|% : 0개 이상의 임의의 개수를 가지는 문자들을 의미 <br> _ : 하나의 문자를 의미
|escape character|\ : 예약 문자를 escape시켜서 문자 본연의 문자로 사용하고 싶을 때 사용

## *(aterisk) 사용하기
- *(asterisk)는 선택된 tuples의 모든 attributes를 보여주고 싶을 때 사용한다.
### ex)
- ID가 9인 임직원의 모든 attributes를 알고 싶다.

```java
mysql> SELECT * FROM employee WHERE id = 9;
```

결과

|id|name|birth_date|sex|position|salary|dept_id|
|:-:|:-:|:-:|:-:|:-:|:-:|:-:|
|9|HENRY|1982-05-20|M|HR|82000000|1002|

## SELECT without WHERE
테이블에 있는 모든 tuples를 반환한다.
### ex)
- 모든 임직원의 이름과 생일을 알고 싶다.

```java
mysql> SELECT name, birth_date
    -> FROM employee;
```

## 주의사항
1. SELECT로 조회할 때 조건들을 포함해서 조회를 한다면 이 조건들과 관련된 attributes에 index가 걸려있어야 합니다. 그렇지 않다면 데이터가 많아질수록 조회 속도가 느려집니다.
2. 위 내용은 MySQL 기준입니다. 다른 RDBMS의 SQL 문법은 조금씩 다를 수 있습니다.
3. 위 내용은 SELECT와 관련하여 대표적으로 중요한 기본기들을 작성했습니다. 이 외에도 여러 기본적인 조회 기능들과 세부 사항들이 있음을 염두해야 합니다.