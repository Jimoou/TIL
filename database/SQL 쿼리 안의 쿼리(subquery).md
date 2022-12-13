# subquery

## SELECT with subquery
### ex)
#### ID가 14인 임직원보다 생일이 빠른 임직원의 ID, 이름, 생일을 알고 싶다.

```javascript
//1단계 ID가 14인 임직원의 생일을 조회
mysql> SELECT birth_date FROM employee WHERE id = 14;

//2단계 조회한 생일을 기준으로 다음과 같이 작성
mysql> SELECT id, name, birth_date FROM employee
    -> WHERE birth_date < '1992-08-04';
```

- 위 두개의 쿼리를 합쳐서 실행할 수 있다.

```javascript
mysql> SELECT id, name, birth_date FROM employee
    -> WHERE birth_date < (
    ->              SELECT birth_date FROM employee WHERE id = 14
    ->      );
```

```
subquery (nested query or inner query) : SELECT, INSERT, UPDATE, DELETE에 포함된 query
outer query (main query) : subquery를 포함하는 query
subquery는 ()안에 기술된다.
```

<br>

#### ID가 1인 임직원과 같은 부서 같은 성별인 임직원들의 ID와 이름과 직군을 알고 싶다.

```javascript
mysql> SELECT id, name, position
    -> FROM employee
    -> WHERE (dept_id, sex) = (
    ->      SELECT dept_id, sex
    ->      FROM employee
    ->      WHERE id = 1
    ->);
```

#### ID가 5인 임직원과 같은 프로젝트에 참여한 임직원들의 ID를 알고 싶다.

```javascript
mysql> SELECT DISTINCT empl_id FROM works_on
    -> WHERE empl_id != 5 AND (proj_id = 2001 OR proj_id = 2002);

mysql> SELECT DISTINCT empl_id FROM works_on
    -> WHERE empl_id != 5 AND proj_id IN(2001,2002);

mysql> SELECT DISTINCT empl_id FROM works_on
    -> WHERE empl_id != 5 AND proj_id IN (
    ->           SELECT proj_id FROM works_on WHERE empl_id = 5
    ->      );
```

#### ID가 5인 임직원과 같은 프로젝트에 참여한 임직원들의 <u>ID</u>와 <u>이름</u>을 알고 싶다.

```javascript
//1
mysql> SELECT id, name
    -> FROM employee
    -> WHERE id IN (
    ->            SELECT DISTINCT empl_id
    ->          FROM works_on
    ->          WHERE empl_id != 5 AND proj_id IN (
    ->                    SELECT proj_id
    ->                    FROM works_on
    ->                    WHERE empl_id = 5
    ->          )
    ->    );

//2
mysql> SELECT id, name
    -> FROM employee,
    ->       (
    ->          SELECT DISTINCT empl_id
    ->          FROM works_on
    ->          WHERE empl_id != 5 AND proj_id IN (
    ->                    SELECT proj_id
    ->                    FROM works_on
    ->                    WHERE empl_id = 5
    ->               )
    ->       ) AS DSTNCT_E
    -> WHERE id = DSTNCT_E.empl_id;
```

#### ID가 7 혹은 12인 임직원이 참여한 프로젝트의 ID와 이름을 알고 싶다.

```python
mysql> SELECT P.id, P.name
    -> FROM project P
    -> WHERE EXISTS (
    ->          SELECT *
    ->          FROM works_on W
    ->          WHERE W.proj_id = P.id AND W.empl_id IN (7,12)
    ->       );

mysql> SELECT P.id, P.name
    -> FROM project P
    -> WHERE id IN (
    ->       SELECT W.proj_id
    ->       FROM works_on W
    ->       WHERE W.empl_id IN (7,12)
    ->     );
```

- correlated query : subquery가 바깥쪽 query의 attribute를 참조할 때, correleated subquery라 부름
- EXISTS : subquery의 결과가 최소 하나의 row라도 있다면 TRUE를 반환
- NOT EXISTS : subquery의 결과가 단 하나의 row도 없다면 TRUE를 반환

#### 2000년대생이 없는 부서의 ID와 이름을 알고 싶다.

```java
mysql> SELECT D.id, D.name
    -> FROM department AS D
    -> WHERE NOT EXISTS (
    ->          SELECT *
    ->          FROM employee E
    ->          WHERE E.dept_id = D.id AND E.birth_date >= '2001-01-01'
    ->      );

mysql> SELECT D.id, D.name
    -> FROM department AS D
    -> WHERE D.id NOT IN (
    ->          SELECT E.dept_id
    ->          FROM employee E
    ->          WHERE E.birth_date >= '2001-01-01'
    ->      );
```

#### 리더보다 높은 연봉을 받는 부서원을 가진 리더의 ID와 이름과 연봉을 알고 싶다.

```java
mysql> SELECT E.id, E.name, E.salary
    -> FROM department D, employee E
    -> WHERE D.leader_id = E.id AND E.salary < ANY (
    ->          SELECT salary
    ->          FROM employee
    ->          WHERE id <> D.leader_id AND dept_id = E.dept_id
    ->      );
```

#### 리더보다 높은 연봉을 받는 부서원을 가진 리더의 ID와 이름과 연봉과 해당 부서 최고 연봉을 알고 싶다.

```javascript
mysql> SELECT E.id, E.name, E.salary
    ->     (
    ->        SELECT max(salary)
    ->        FROM employee
    ->        WHERE dept_id = E.dept_id
    ->     ) AS dept_max_salary
    -> FROM department D, employee E
    -> WHERE D.leader_id = E.id AND E.salary < ANY (
    ->          SELECT salary
    ->          FROM employee
    ->          WHERE id <> D.leader_id AND dept_id = E.dept_id
    ->      );
```

#### ID가 13인 임직원과 한번도 같은 프로젝트에 참여하지 못한 임직원들의 ID, 이름, 직군을 알고 싶다.

```javascript
mysql> SELECT DISTINCT E.id, E.name, E.postion
    -> FROM employee E, works_on W
    -> WHERE E.id = W.empl_id AND W.proj_id <> ALL (
    ->             SELECT proj_id
    ->             FROM works_on
    ->             WHERE empl_id = 13   
    ->         );
```

### 성능 비교 : IN vs EXISTS
RDBMS의 종류와 버전에 따라 다르며 최근 버전은 많은 개선이 이루어져서 IN과 EXISTS의 성능 차이가 거의 없는 것으로 알고 있습니다.

[출처 : Youtube - 쉬운코드] (https://youtu.be/lwmwlA2WhFc)