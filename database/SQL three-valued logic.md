# SQL three-valued logic.md
## SQL에서 NULL의 의미
- unknown
- unavailable or withheld
- not applicable

- SQL에서 NULL과 비교 연산을 하게 되면 그 결과는 UNKNOWN이다.
- UNKNOWN은 'TRUE 일수도 있고 FALSE일 수도 있다'라는 의미이다.
- three-valued logic: 비교/논리 연산의 결과로 TRUE, FALSE, UNKNOWN을 가진다.

|비교 연산 예제|결과|
|:-:|:-:|
|1 = 1|TRUE|
|1 != 1|FALSE|
|1 = NULL <br> 1 != NULL <br> 1 > NULL <br> 1 <>= NULL <br> NULL = NULL|UNKNOWN|


## SQL에서 NULL인 값 조회하기
잘못된 예
```java
mysql> SELECT id FROM employee WHERE birth_date = NULL;
//아무것도 불러오지 않음.
```

옳은 예
```java
mysql> SELECT id FROM employee WHERE birth_date IS NULL;
//제대로 불러옴.
```

## WHERE절의 condition(s)
- where절에 잇는 condition(s)의 결과가 TRUE인 tuple(s)만 선택 된다.
- 즉, 결과가 FALSE거나 UNKNOWN이면 tuple은 선택되지 않는다.

## NOT IN 사용시 주의사항
- v NOT IN(v1, v2, v3)는 아래와 같은 의미이다.
- v != v1 AND v != v2 AND v != v3

### NOT IN 예제
- 만약 v1, v2, v3 중에 하나가 NULL이라면?

|NOT IN 예제|결과|
|:-:|:-:|
|3 not in (1, 2, 4)|TRUE|
|3 not in (1 ,2 ,3)|FALSE|
|3 not in (1, 3, NULL)|FALSE|
|3 not in (1, 2, NULL)|UNKNOWN|

- NULL이 들어 있다면, 출력이 안되므로 다음과 같이 작성해서 NULL인 경우를 걸러줘야 한다.

```java
//1
mysql> SELECT D.id, D.name
    -> FROM department AS D
    -> WHERE D.id NOT IN (
    ->            SELECT E.dept_id
    ->            FROM employee E
    ->            WHERE E.birth_date >= '2000-01-01'
    ->                  AND E.dept_id IS NOT NULL
    ->        ); 
//2
mysql> SELECT D.id, D.name
    -> FROM department AS D
    -> WHERE D.id NOT EXISTS (
    ->            SELECT E.dept_id
    ->            FROM employee E
    ->            WHERE E.birth_date >= '2000-01-01'
    ->        ); 
```

[출처 : Youtube - 쉬운코드] (https://youtu.be/y_7rOoOodCY)