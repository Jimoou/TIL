### 1. 80번부서의 평균급여보다 많은 급여를 받는 직원의 이름,부서id, 급여를 조회하시오.

```java
SELECT first_name, department_id, salary
FROM employees
WHERE salary >  (SELECT AVG(salary) FROM employees WHERE department_id=80);
```

### 2. 'South San Francisco'에 근무하는 직원의 최소급여보다 급여를 많이 받으면서 50 번부서의 평균급여보다 많은 급여를 받는 직원의 이름, 급여, 부서명, 부서id를 조회하시오.

```java
SELECT e.first_name, e.salary, d.department_name, d.department_id
FROM employees e JOIN departments d USING (department_id)
                 JOIN locations l USING(location_id)
WHERE e.salary > (SELECT MIN(salary)
                  FROM employees
                  WHERE department_id =
                  (SELECT department_id
                   FROM locations L
                   JOIN departments USING (location_id)
                   WHERE L.city = 'South San Francisco'))
  and e.salary > (SELECT AVG(salary) FROM employees WHERE department_id = '50');
```

### 3-1.각 직급별(job_title) 인원수를 조회하되 사용되지 않은 직급이 있다면(사용되지 않는 직급은 없다) 해당 직급도 출력결과에 포함시키시오.

```java
SELECT JOB_TITLE, COUNT(\*)
FROM jobs J LEFT OUTER JOIN employees E ON E.JOB_ID=J.JOB_ID
GROUP BY JOB_TITLE;
```

### 3-2. 직급별 인원수가 10명 이상인 직급만 출력결과에 포함시키시오.

```java
SELECT JOB_TITLE, COUNT(_)
FROM jobs J LEFT OUTER JOIN employees E ON E.JOB_ID=J.JOB_ID
GROUP BY JOB_TITLE
HAVING COUNT(_) >= 10;
```

### 4. 각 부서별 최대급여를 받는 직원의 이름, 부서명, 급여를 조회하시오.

```java
SELECT first_name,D.department_name,salary
FROM employees JOIN departments D USING(department_id)
WHERE (department_id, salary) IN (SELECT department_id, max(salary) FROM employees GROUP BY department_id);
```

### 5. 직원의 이름, 부서id, 급여를 조회하시오. 그리고 직원이 속한 해당 부서의 최소급여를 마지막에 포함시켜 출력 하시오.

```java
SELECT FIRST_NAME "직원 이름" , DEPARTMENT_id 부서코드 , SALARY 내급여,
(SELECT min(salary) FROM employees WHERE e.department_id = department_id)
"내부서의 최소급여"
FROM employees e;
```

### 6. 월별 입사자 수를 조회하되, 입사자 수가 10명 이상인 월만 출력하시오.

```java
SELECT MONTH(hire_date) 월, COUNT(MONTH(hire_date)) 월별입사자수
FROM employees
GROUP BY MONTH(hire_date)
HAVING COUNT(MONTH(hire_date)) >= 10;
```

### 7. 자신의 관리자(상사)보다 많은 급여를 받는 직원의 이름과 급여를 조회하시오.

```java
SELECT E.first_name, E.salary
FROM employees E,
     employees M
WHERE E.manager_id = M.employee_id
  AND E.salary > M.salary;
```

### 8. 'Southlake'에서 근무하는 직원의 이름, 급여, 직책(job_title)을 조회하시오.

```java
SELECT e.first_name 이름, e.salary 급여, j.job_title 직책
FROM employees e
         JOIN departments d USING (department_id)
         JOIN locations l USING (location_id)
         JOIN jobs j USING (job_id)
WHERE l.city = 'Southlake';
```

### 9. 국가이름 근무 인원수를 조회하시오. 단, 인원수가 3명 이상인 국가정보만 출력되어야함.

```java
SELECT c.country_name 국가, COUNT(*)
FROM employees e
         JOIN departments d USING (department_id)
         JOIN locations l USING (location_id)
         JOIN countries c USING (country_id)
GROUP BY c.country_name
HAVING COUNT(e.employee_id) >= 3;
```

### 10. 직원의 폰번호, 이메일과 상사의 폰번호, 이메일을 조회하시오. 단, 상사가 없는 직원은 '<관리자 없음>'이 출력되도록 해야 한다.

```java
SELECT E.PHONE_NUMBER 직원폰번호 , E.EMAIL 직원이메일,
IFNULL(M.PHONE_NUMBER, '<관리자 없음>') 상사폰번호,
IFNULL(M.EMAIL , '<관리자 없음>') 상사이메일
FROM employees E LEFT OUTER JOIN employees M USING(manager_id);
```

### 11. 각 부서 이름별로 최대급여와 최소급여를 조회하시오. 단, 최대/최소급여가 동일한 부서는 출력결과에서 제외시킨다.(1사원)

```java
SELECT DEPARTMENT_NAME, MAX(SALARY), MIN(SALARY)
FROM departments D JOIN employees E USING(DEPARTMENT_ID)
GROUP BY DEPARTMENT_NAME
HAVING MAX(SALARY) != MIN(SALARY);
```

### 12. 부서별, 직급별, 평균급여를 조회하시오. 단, 평균급여가 50번부서의 평균보다 많은 부서만 출력되어야 합니다.

```java
SELECT DEPARTMENT_ID, JOB_ID, AVG(SALARY)
FROM employees
GROUP BY DEPARTMENT_ID, JOB_ID
HAVING AVG(SALARY) > (SELECT AVG(SALARY) FROM employees WHERE DEPARTMENT_ID=50);
```
