# SQL 그룹짓기, 집계함수, 정렬하기
## <span style="color: green">ORDER BY</span>
- 조회 결과를 특정 attribute(s) 기준으로 정렬하여 가져오고 싶을 때 사용한다.
- default 정렬 방식은 오름차순이다.
- 오름차순 정렬은 ASC로 표기한다
- 내림차순 정렬은 DESC로 표기한다.

### <span style="color: green">ORDER BY 예제</span>
1. 임직원들의 정보를 연봉 순서대로 정렬해서 알고 싶다.

```java
//default(DESC)
mysql> SELECT * FROM employee ORDER BY salary;

//DESC
mysql> SELECT * FROM employee ORDER BY salary DESC;
```

2. 임직원들의 정보를 부서별로 묶어서 부서내 연봉 순서로 내림차순 하겠다.

```java
mysql> SELECT * FROM employee ORDER BY dept_id ASC, salary DESC;
```

## <span style="color: green">aggregate function</span>
- 여러 tuple들의 정보를 요약해서 하나의 값으로 추출하는 함수
- 대표적으로 COUNT, SUM, MAX, MIN, AVG 함수가 있다
- (주로) 관심있는 attribute에 사용된다.
- NULL값들은 제외하고 요약 값을 추출한다.


### <span style="color: green">aggregate function 예제</span>
1. 임직원 수를 알고 싶다.

```java
mysql> SELECT COUNT(*) FROM employee;
//여기서 asterisk가 의미하는 것은 tuple의 수
```

2. 프로젝트 2002에 참여한 임직원 수와 최대 연봉과 최소 연봉과 평균 연봉을 알고 싶다

```java
mysql> SELECT COUNT(*), MAX(salary), MIN(salary), AVG(salary)
    -> FROM works_on W JOIN employee E ON W.empl_id = E.id
    -> WHERE W.proj_id = 2002;
```

## <span style="color: green">GROUP BY</span>
- 관심있는 attribute(s) 기준으로 그룹을 나눠서 그룹별로 aggregate function을 적용하고 싶을 때 사용
- grouping attribute(s) : 그룹을 나누는 기준이 되는 attribute(s)
- grouping attirbute(s)에 NULL값이 있을 때는 NULL 값을 가지는 tuple끼리 묶인다.

### <span style="color: green">GROUP BY 예제</span>
1. 각 프로젝트에 차여한 임직원 수와 최대 연봉과 최소 연봉과 평균 연봉을 알고 싶다.

```java
mysql> SELECT W.proj_id COUNT(*), MAX(salary), MIN(salary), AVG(salary)
    -> FROM works_on W JOIN employee E ON W.empl_id = E.id
    -> GROUP BY W.proj_id;
```

## <span style="color: green">HAVING</span>
- GROUP BY와 함께 사용한다.
- aggregate function의 결과값을 바탕으로 그룹을 필터링하고 싶을 때 사용한다.
- HAVING절에 명시된 조건을 만족하는 그룹만 결과에 포함된다.

### <span style="color: green">HAVING 예제</span>
1. 프로젝트 참여 인원이 7명 이상인 프로젝트들에 대해서 각 프로젝트에 참여한 임직원 수와 최대 연봉과 최소 연봉과 평균 연봉을 알고 싶다.

```java
mysql> SELECT W.proj_id COUNT(*), MAX(salary), MIN(salary), AVG(salary)
    -> FROM works_on W JOIN employee E ON W.empl_id = E.id
    -> GROUP BY W.proj_id;
    -> HAVING COUNT (*) >= 7;
```

2. 각 부서별 인원수를 인원 수가 많은 순서대로 정렬해서 알고 싶다.

```java
mysql> SELECT dept_id, COUNT(*) AS empl_count FROM employee
    -> GROUP BY dept_id
    -> ORDER BY empl_count DESC;
```

3. 각 부서별-성별 인원수를 인원 수가 많은 순서대로 정렬해서 알고 싶다.

```java
mysql> SELECT dept_id, COUNT(*) AS empl_count FROM employee
    -> GROUP BY dept_id, sex
    -> ORDER BY empl_count DESC;
```

4. 회사 전체 평균 연봉보다 평균 연봉이 적은 부서들의 평균 연봉을 알고 싶다.

```java
mysql> SELECT dept_id, AVG(salary)
    -> FROM employee
    -> GROUP BY dept_id
    -> HAVING AVG(salary) < (
    ->              SELECT AVG(salary) FROM employee
    -> .     );
```

5. 각 프로젝트별로 프로젝트에 참여한 90년대생들의 수와 이들의 평균 연봉을 알고 싶다.


```java
mysql> SELECT proj_id, COUNT(*), ROUND(AVG(salary), 0)
    -> FROM works_on W JOIN employee E ON W.empl_id = E.id
    -> WHERE E.birth_date BETWEEN '1990-01-01' AND '1999-12-31'
    -> GROUP BY W.proj_id;
```

6. 프로젝트 참여 인원이 7명 이상인 프로젝트에 한정해서 각 프로젝트별로 프로젝트에 참여한 90년대생들의 수와 이들의 평균 연봉을 알고 싶다.

```java
mysql> SELECT proj_id, COUNT(*), ROUND(AVG(salary), 0)
    -> FROM works_on W JOIN employee E ON W.empl_id = E.id
    -> WHERE E.birth_date BETWEEN '1990-01-01' AND '1999-12-31'
    ->       AND W.proj_id IN ( SELECT proj_id FROM works_on
                                GROUP BY proj_id HAVING COUNT(*) >= 7 )
    -> GROUP BY W.proj_id;
```

## <span style="color: green">SELECT로 조회하기 요약</span>

```java
//1
FROM table(s)

//2
[ WHERE condition(s) ]

//3
[ GROUP BY group attribute(S) ]

//4
[ HAVING group condition(s) ]

//5
[ ORDER BY attribute(S) ]

//6
SELECT attribute(s) or aggreagte function(s)
```


[출처 : Youtube - 쉬운코드] (https://youtu.be/rG8yQ7yKGTE)