# SQL JOIN
- 두개 이상의 table들에 있는 데이터를 한 번에 조회하는 것
- 여러 종류의 JOIN이 존재한다.

## <span style="color: green">implicit join vs explicit join</span>
### <span style="color: green">implicit join</span>
- from절에는 table들만 나열하고 where절에 join condition을 명시하는 방식
- old-style join syntax
- where 절에 selection condition과 join condition이 같이 있기 때문에 가독성이 떨어진다.
- 복잡한 join 쿼리를 작성하다 보면 실수로 잘못된 쿼리를 작성할 가능성이 크다.

#### ex)
<b>ID가 1인 임직원이 속한 부서 이름은?</b>
```javascript
mysql> SELECT D.name
    -> FROM employee AS E, department AS D
    -> WHERE E.id = 1 and E.dept_id = D.id;
```

### <span style="color: green">explicit join</span>
- explicit join : from절에 JOIN키워드와 함께 joined table들을 명시하는 방식
- from 절에서 ON 뒤에 join condition이 명시된다.
- 가독성이 좋다.
- 복잡한 join 쿼리 작성 중에도 실수할 가능성이 적다.

#### ex)
<b>ID가 1인 임직원이 속한 부서 이름은?</b>
```javascript
mysql> SELECT D.name
    -> FROM employee AS E JOIN department AS D ON E.dept_id = D.id
    -> WHERE E.id = 1;
```

## <span style="color: green">inner join vs outer join</span>
### <span style="color: green">inner join</span>
- 두 table에서 join condition을 만족하는 tuple들로 result table을 만드는 join

```javascript
FROM table1 [INNER] JOIN table2 ON join_ condition
```

- join condition에 사용 가능한 연산자 (operator) : =, <, >, != 등등 여러 비교 연산자가 가능하다.
- join condition에서 null 값을 가지는 tuple은 result table에 포함되지 못한다.

```javascript
mysql> SELECT *
    -> FROM employee E JOIN department D ON E.dept_id = D.id;
```

### <span style="color: green">outer join</span>
- 두 table에서 join condition을 만족하지 않는 tuple들도 result table에 포함하는 join

```javascript
//1
FROM table1 LEFT [OUTER] JOIN table2 ON join_condition
//table1에서 join_condition에 의해서 매칭되지 않는 tuple까지도 함께 결과로 return함.

//2
FROM table1 RIGHT [OUTER] JOIN table2 ON join_condition
//table2에서 join_condition에 의해서 매칭되지 않는 tuple까지도 함께 결과로 return함.

//3 이건 PostgreSql에서만 지원하고 MySql에선 지원하지 않음.
FROM table1 FULL [OUTER] JOIN table2 ON join_condition
//table1,2에서 매칭되지 않는 tuple도 결과로 return함.
```

- join condition에 사용 가능한 연산자 (operator) : =, <, >, != 등등 여러 비교 연산자가 가능하다. 

## <span style="color: green">equi join </span>
- join condition에서 = (equality comparator)를 사용하는 join

### <span style="color: green">equi join에 대한 두 가지 시각</span>
1. <u>inner join, outer join 상관없이 = 를 사용한 join이라면 equi join으로 보는 경우</u>
2. inner join으로 한정해서 = 를 사용한 경우에 equi join으로 보는 경우

### <span style="color: green">USING</span>
- 두 table이 equi join할 때 join하는 attribute의 이름이 같다면, USING으로 간단하게 작성할 수 있다.
- 이 때 같은 이름의 attribute는 result table에서 한 번만 표시 된다.

```javascript
//1
FROM table1 [INNER] JOIN table2 USING (attribute(s))

//2
FROM table1 LEFT [OUTER] JOIN table2 USING (attribute(s))

//3
FROM table1 RIGHT [OUTER] JOIN table2 USING (attribute(s))

//4
FROM table1 FULL [OUTER] JOIN table2 USING (attribute(s))
```

## <span style="color: green">natural join </span>
- 두 table에서 같은 이름을 가지는 모든 attribute pair에 대해서 equi join을 수행한다. 따라서, 의도한대로 join하려 한다면, 각 table의 attribute에 유의해야 한다.
- join condition을 따로 명시하지 않는다.

```javascript
//1
FROM table1 NATURAL [INNER] JOIN table2

//2
FROM table1 NATURAL LEFT [OUTER] JOIN table2

//3
FROM table1 NATURAL RIGHT [OUTER] JOIN table2

//4
FROM table1 NATRUAL FULL [OUTER] JOIN table2
```

## <span style="color: green">cross join </span>
- 두 table의 tuple pair로 만들 수 있는 모든 조합(= Cartesian product)을 result table로 반환한다.
- join condition이 없다

```javascript
//implicit cross join
FROM table1, table2

//explicit cross join
FROM table1 CROSS JOIN table2
```

### <span style="color: green">cross join @MySQL </span>
- MySQL에서는 cross join = inner join = join 이다.
- CROSS JOIN에 ON(or USING)을 같이 쓰면 inner join으로 동작한다.
- INNER JOIN(or JOIN)이 ON(or USING) 없이 사용되면 cross join으로 동작한다.

## <span style="color: green">self join </span>
- table이 자기 자신에게 join하는 경우

## <span style="color: green">JOIN 예제</span>
1. ID가 1003인 부서에 속하는 임직원 중 리더를 제외한 부서원의 ID, 이름, 연봉을 알고 싶다.

```javascript
mysql> SELECT E.id, E.name, E.salary
    -> FROM employee E JOIN department D ON E.dept_id = D.id
    -> WHERE E.dept_id = 1003 and E.id != D.leader_id;
```

2. ID가 2001인 프로젝트에 참여한 임직원들의 이름과 직군과 소속 부서 이름을 알고 싶다

```javascript
mysql> SELECT E.name AS empl_name,
    ->        E.position AS empl_position,
    ->        E.name AS dept_name
    -> FROM works_on W JOIN employee E ON W.empl_id = E.id
    ->                 LEFT JOIN department D ON E.dept_id = D.id
    -> WHERE W.proj_id = 2001;
```