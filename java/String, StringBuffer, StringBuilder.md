# String, StringBuffer, StringBuilder

## String                :  문자열 연산이 적고 멀티쓰레드 환경일 경우
## StringBuffer     :  문자열 연산이 많고 멀티쓰레드 환경일 경우

### 객체 선언

```java
StringBuffer sb = new StringBuffer();
```

### 주요 메소드

```java

```

## StringBuilder   :  문자열 연산이 많고 단일쓰레드이거나 동기화를 고려하지 않아도 되는 경우 

### 객체 선언

```java
StringBuilder sb = new StringBuilder(); //객체 선언
StringBuilder sb = new StringBuilder("aaa"); //문자열을 바로 넣을 수도 있다.
```

### 주요 메소드

```java
StringBuilder sb = new StringBuilder("aaa");

// 문자열 추가
System.out.println(sb.append("bbb")); // aaabbb
System.out.println(sb.append(4)); // aaabbb4

// 문자열 삽입 : .insert(int index, String str)
System.out.println(sb.insert(2, "ccc")); // aacccabbb4
        
// 문자열 치환, 문자열 교체 
System.out.println(sb.replace(3, 6, "ye")); // aacyebbb4

// 인덱싱, 문자열 자르기 : .substring(int start, int end) end포함안함
System.out.println(sb.substring(5)); // bbb4
System.out.println(sb.substring(3, 7)); // yebb

// 문자 삭제 : .deleteCharAt(int index)
System.out.println(sb.deleteCharAt(3)); // aacebbb4

// 문자열 삭제 : .delete(int start, int end) end포함안함
System.out.println(sb.delete(3, sb.length())); // aac

// 문자열 변환 : .toString(): String으로 변환한다.
System.out.println(sb.toString()); // aac

// 문자열 뒤집기 : .toString(): String으로 변환한다.
System.out.println(sb.reverse()); // caaƒ

// 문자 대체, 문자 교체, 문자 치환 : .setCharAt(int index, String s): index 위치의 문자를 s로 변경
sb.setCharAt(1, 'b');
System.out.println(sb); // cba

// 문자열 길이 조정 : .setLength(int len): 문자열 길이 조정, 현재 문자열보다 길게 조정하면 공백으로 채워짐, 현재 문자열보다 짧게 조정하면 나머지 문자는 삭제
sb.setLength(2);
System.out.println(sb); // cb
```