# List와 ArrayList 선언의 차이점

```java
//1
List<Integer> list1 = new ArrayList<Integer>();
//2
ArrayList<Integer> list1 = new ARrayList<Integer>();
```

- List는 인터페이스이고, ArrayList는 클래스임
    - 클래스는 크게 일반 클래스와 클래스 내에 '추상 메서드'가 하나 이상 있거나, abstract로 정의된 추상 클래스로 나뉨
    - 인터페이스는 모든 메서드가 추상 메서드인 경우를 의미하며, 인터페이스를 상속받는 클래스는 인터페이스에서 정의된 추상 메서드를 모두 구현해야 함 (<b>따라서 다양한 클래스를 상속받는 특정 인터페이스는 결국 동일한 메서드를 제공함</b>)
    - ArrayList가 아니라, List로 선언된 변수는 다음과 같이 필요에 따라 다른 리스트 클래스로 쓸 수 있는 <b>구현상의 유연성</b>을 제공함
    
    ```java
    List<Integer> list1 = new ArrayList<Integer>();
    List<Integer> list1 = new LinkedList<Integer>();
    ```
