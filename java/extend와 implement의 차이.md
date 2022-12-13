둘 다 모두 부모의 메서드를 상속받지만, implements는 부모의 메서드를 모두 오버라이딩해서 사용해야만 하고, 다중 상속을 지원한다.

1. extends는 일반 클래스와 abstract 클래스 상속에 사용되고
2. implements는 interface 상속에 사용된다.
3. class가 class를 상속받을 땐 extends를 사용하고, interface가 interface를 상속 받을 땐 extends를 사용한다.
4. class가 interface를 사용할 땐 implements를 써야하고 interface가 class를 사용할 땐 implements를 쓸수 없다.
6. extends는 클래스 한 개만 상속 받을 수 있다.
7. extends 자신 클래스는 부모 클래스의 기능을 사용한다.
8. implements는 여러개 사용 가능하다.
9. implements는 설계 목적으로 구현 가능하다.
10. implements한 클래스는 implements의 내용을 다 사용해야 한다.