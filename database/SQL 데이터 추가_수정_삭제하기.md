# SQL로 데이터 추가/수정/삭제하기

## 추가
### INSERT statement
- <b>INSERT INTO</b> table_name <b>VALUES</b> <b>(</b>comma-separated all values<b>)</b>;
- <b>INSERT INTO</b> table_name <b>(</b>attributes list<b>)</b>  
&nbsp;&nbsp;&nbsp;&nbsp; <b>VALUES</b> (attributes list 순서와 동일하게 comma-separated values);
- <b>INSERT INTO</b> table_name <b>VALUES</b><b>(</b>..., ..<b>)</b><b>(</b>..., ..<b>)</b><b>(</b>..., ..<b>)</b>;  

## 수정
### UPDATE statement
- UPDATE table_name(s)
- SET attribute = value [, attribute = value, ..]  
&nbsp;&nbsp;&nbsp;&nbsp; [WHERE condition(s) ];

#### ex
```javascript
mysql> UPDATE employee, works-on
    -> SET salary = salary *2
    -> WHERE id = empl_id and proj_id = 2003;
```

```javascript
mysql> UPDATE employee, works-on
    -> SET salary = salary *2
    -> WHERE employee.id = works_on.empl_id and proj_id = 2003;
```

```javascript
mysql> UPDATE employee, works-on
    -> SET salary = salary *2
```

## 삭제
### DELETE statement
- DELETE FROM table_name   
&nbsp;&nbsp;&nbsp;&nbsp; [WHERE condition(s)];

#### ex

```javascript
mysql> DELETE FROM employee WHERE id = 8;
```

```javascript
mysql> DELETE FROM project;
```

[출처 : Youtube - 쉬운코드] (https://youtu.be/mgnd5JWeCK4)