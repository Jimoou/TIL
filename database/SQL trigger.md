# SQL trigger
- 데이터에 변경이 생겼을 때(insert, update, delete)가 발생했을 때, 이것이 계기가 되어 자동적으로 실행되는 프로시저(procedure)를 의미

## <span style="color: green">stored function 예제</span>
<b>1.사용자의 닉네임 변경 이력을 저장하는 트리거를 작성해 보자</b>

```java
mysql> delimiter $$
mysql> CREATE TRIGGER log_user_nickname_trigger
    -> BEFORE UPDATE
    -> ON users FOR EACH ROW
    -> BEGIN
    ->     insert into users_log values(OLD.id, OLD.nickname, now());
    //OLD : update 되기 전의 tuple 또는 delete된 tuple을 가리킴
    -> END
    -> $$
mysql> delimiter ;
```

<b>2.사용자가 마트에서 상품을 구매할 때마다 지금까지 누적된 구매 비용을 구하는 트리거를 작성해 보자.</b>

```java
mysql> delimiter $$
mysql> CREATE TRIGGER sum_buy_prices_trigger
    -> AFTER INSERT
    -> ON buy FOR EACH ROW
    -> BEGIN
    ->     DECLARE total INT;
    ->     DECLARE user_id INT DEFAULT NEW.user_id;
    ->     //NEW : insert된 tuple 또는 update된 후의 tuple을 가리킴
    ->     select sum(price) into total from buy where user_id = user_id;
    ->     update user_buy_stats set price_sum = total where user_id = user_id;
    -> END
    -> $$
mysql> delimiter ;
```



![출처 : 쉬운코드] (https://youtu.be/m2jx18yg8EA)