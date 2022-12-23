emp / emp 접속 - empdb의 테이블들 이용

# 기본
1. 직원 중에서 연봉이 170000 이상인 직원들의 이름, 연봉을 조회하시오.(연봉은 급여(salary)에 12를 곱한 값입니다.)

단, 이름은 "이름", 연봉은 "월급의 12배"로 출력되도록 조회하시오.

```java
mysql> select last_name, salary*12 FROM employees WHERE salary*12 >= 170000;
```

2. 직원 중에서 manager_id가 없는 직원의 이름과 급여를 조회하시오.

```java
mysql> select last_name, salary FROM employees WHERE manager_id IS NULL;
```

3. 2004년 이전에 입사한 직원의 이름, 급여, 입사일을 조회하시오.

```java
mysql> SELECT last_name, salary, hire_date FROM employees WHERE hire_date < '2004-01-01 00:00:00';
```

4. departments 테이블에서 부서코드, 부서명을 조회하시오.

```java
mysql> SELECT department_id, department_name FROM departments;
```

5. jobs 테이블에서 직종코드와 직종명을 조회하시오.

```java
mysql> SELECT job_id, job_title FROM jobs;
```

# 논리연산자

1. 80, 50 번 부서에 속해있으면서 급여가 13000 이상인 직원의 이름, 급여, 부서id를 조회하시오.

```java
mysql> SELECT last_name, salary, department_id FROM employees WHERE department_id IN ('80', '50') and salary >= 13000;
```

2. 2005년 이후에 입사한 직원들 중에서 급여가 1300 이상 20000 이하인 직원들의 이름, 급여, 부서id, 입사일을 조회하시오.

```java
mysql> SELECT last_name, salary, department_id, hire_date FROM employees WHERE hire_date >= '2005-12-31 00:00:00' and salary between
```

# SQL 비교연산자

1. 80, 50 번 부서에 속해있으면서 급여가 13000 이상인 직원의 이름, 급여, 부서id를 조회하시오.

```java
mysql> SELECT last_name, salary, department_id FROM employees WHERE salary >=13000 and (department_id = 80 or department_id = 50);
```

2. 2005년 이후에 입사한 직원들 중에서 급여가 1300 이상 20000 이하인 직원들의 이름, 급여, 부서id, 입사일을 조회하시오.

3. 2005년도 입사한 직원의 정보(이름, 급여, 부서코드, 입사일)만 출력하시오.

```java
mysql> SELECT last_name, salary, department_id, hire_date FROM employees WHERE hire_date between '2004-12-31 00:00:00' and '2005-12-13 00:00:00';
```

4. 직종이 clerk 군인 직원의 이름, 급여, 직종코드를 조회하시오.
(clerk 직종은 job_id에 CLERK을 포함하거나 CLERK으로 끝난다.)

```java
mysql> SELECT last_name, salary, job_id FROM employees WHERE job_id like('%CLERK');
```

5. 12월에 입사한 직원의 이름, 급여, 입사일을 조회하시오.

```java
mysql> SELECT last_name, salary, hire_date FROM employees WHERE DATE_FORMAT(hire_date, '%m') = '12';
```

6. 이름에 le 가 들어간 직원의 이름, 급여, 입사일을 조회하시오.

```java
mysql> SELECT last_name, salary, hire_date FROM employees WHERE last_name like '%el';
```

7. 이름이 m으로 끝나는 직원의 이름, 급여, 입사일을 조회하시오.

```java
mysql> SELECT last_name, salary, hire_date FROM employees WHERE last_name like '%m';
```

8. 이름의 세번째 글자가 d인 이름, 급여, 입사일을 조회하시오.

```java
mysql> SELECT last_name, salary, hire_date FROM employees WHERE last_name like '__d%';
```

9. 커미션을 받는 직원의 이름, 커미션, 급여를 조회하시오.

```java
mysql> SELECT last_name, commission_pct, salary FROM employees WHERE commission_pct IS NOT NULL;
```

10. 커미션을 받지 않는 직원의 이름, 커미션, 급여를 조회하시오.

```java
mysql> SELECT last_name, commission_pct, salary FROM employees WHERE commission_pct IS NOT NULL;
```

# 기타
1. 30, 50, 80 번 부서에 속해있으면서, 급여를 5000 이상 17000 이하를 받는 직원을 조회하시오. 
단, 커미션을 받지 않는 직원들은 검색 대상에서 제외시키며, 먼저 입사한 직원이 먼저 출력되어야 하며 입사일이 같은 경우 급여가 많은 직원이 먼저 출력되도록 하시오.

```java
mysql> SELECT last_name
    -> FROM employees
    -> WHERE department_id in ('30','50','80')
    -> and salary between 5000 and 17000
    -> and commission_pct is NOT NULL
    -> ORDER BY hire_date;
```

2. 각 부서별 최대급여와 최소급여를 조회하시오.
   단, 최대급여와 최소급여가 같은 부서는 직원이 한명일 가능성이 높기때문에 조회결과에서 제외시킨다.

```java
mysql> SELECT department_id, MAX(salary), MIN(salary) FROM employees WHERE department_id is NOT  NULL GROUP BY department_id;
```

3. 각 부서별 인원수를 조회하되 인원수가 5명 이상인 부서만 출력되도록 하시오.

```java
mysql> SELECT department_id, COUNT(last_name) FROM employees GROUP BY department_Id HAVING COUNT(last_name) >= 5;
```


