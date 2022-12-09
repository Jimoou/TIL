# LIST
## ArrayList

### 시간복잡도
##### add             : O(1)
##### remove          : O(n)
##### get             : O(1)
##### Contains        : O(n)
##### iterator.remove : O(n)
java 1.2에 추가, thread-safe 보장 안함
 특징 :  데이터 추가,삭제를 위해 임시 배열을 생성해 데이터를 복사
   - 대량의 자료를 추가/삭제시 복사가 일어 나게 되어 성능 저하를 일이킴
   - 데이터의 인덱스를 가지고 있어 데이터 검색시 빠름

<hr>
 
## LinkedList

### 시간복잡도
##### add             : O(1)
##### remove          : O(1)
##### get             : O(n)
##### Contains        : O(n)
##### iterator.remove : O(1)
java 1.2에 추가, thread-safe 보장 안함
특징 : 데이터를 저장하는 각 노드가 이전 노드와 다음 노드의 상태만 알고 있다.
   - 데이터 추가/삭제시 빠름
   - 데이터 검색시 처음부터 노드를 순화해야 되기 때문에 느림

<hr>

## CopyOnWriteArrayList

### 시간복잡도
##### add             : O(n)
##### remove          : O(n)
##### get             : O(1)
##### Contains        : O(n)
##### iterator.remove : O(n)
java 1.5 추가 thread-safe 보장, 병렬처리
특징 : 처리에 여분의 오버로드를 가져오지만 순회 작업의 수에 비해 수정 횟수가 최소일때 효과적 이다.
    - add는 ArrayList, LinkedList 보다 느리지만 get은 LinkedList보단 빠르고 ArrayList보단 살짝 느리다.

<hr>

# SET
## HashSet

### 시간복잡도
##### add         :   O(1)
##### contains    :   O(1)
##### next        :   o(h/n) h는 테이블 용량
java 1.2 thread-safe 보장 안함
특징 : 객체들을 순서없이 저장하고 동일한 객체를 중복 저장하지 않는다.
    - 중복되지 않는 값을 등록할때 용의
    - 순서없이 저장되는것 주위
    - null을 허용한다.

<hr>

## LinkedHashSet

### 시간복잡도
##### add       : O(1)
##### contains  : O(1)
##### next      : O(1)
java 1.4 thread-safe 보장 안함
특징 : 속도는 hashSet에 비해 느리지만 좋은 성능을 보장한다.
    - 등록한 순으로 정렬을 한다.
    - null을 허용한다.

<hr>

## CopyOnWriteArraySet

### 시간복잡도
##### add       : O(1)
##### contains  : O(1)
##### next      : O(1)
Java 1.5 에서 나옴
특징 : 적은 메모리를 사용
      - 빠르다
      - null을 사용 할 수 없다.

<hr>

## TreeSet

### 시간복잡도
##### add       : O(log n)
##### contains  : O(log n)
##### next      : O(long n)
java 1.2 에서 나옴 thread-safe 보장 안함
특징 : 객체기준으로 정렬을 한다. 느리다.
    - null을 허용하지 않는다.

<hr>

## ConcurrentSkipListSet

### 시간복잡도
##### add       : O(log n)
##### contains  : O(log n)
##### next      : O(1)
java 1.6 병렬처리, thread-safe 보장, 병렬 보장
특징 : Null을 허용하지 않는다.
  - Tree set 처럼 정렬을 한다.

<hr>

# Map

## HashMap

### 시간복잡도
##### get           : O(1)
##### containsKey   : O(1)
##### next          : O(h/n) h는 테이블 용량
java 1.2 에서 나옴
특징 : 순서에 상관없이 저장됨, Null을 허용한다. thread-safe 보장하지 않는다.

<hr>

## LinkedHashMap

### 시간복잡도
##### get           : O(1)
##### containsKey   : O(1)
##### next          : O(1)
java 1.4 에서 나옴
특징 : 순서대로 등록한다. Null을 허용한다. thread-safe 보장하지 않는다.

<hr>

## IdentityHashMap

### 시간복잡도
##### get           : O(1)
##### containsKey   : O(1)
##### next          : O(h/n) H는 테이블
java 1.4 에서 나옴
특징 : Map 형식에 부합되지 않음

<hr>

## EnumMap

### 시간복잡도
##### get           : O(1)
##### containsKey   : O(1)
##### next          : O(1)
java 1.5 에서 나옴

<hr>

## TreeMap

### 시간복잡도
##### get           : O(log n)
##### containsKey   : O(log n)
##### next          : O(log n)
java 1.2 에서 나옴
특징 : 정렬이 되면서 추가가 됨
     -  null은 허용하지 않음
     -  thread-safe 보장하지 않는다.

<hr>

## ConcurrentHashMap

### 시간복잡도
##### get           : O(1)
##### containsKey   : O(1)
##### next          : O(h/n) h는 테이블
java 1.5 에서 나옴
특징 :  thread-safe 보장하면서 SynchronizedMap 보다 속도가 빠르다
      - null을 허용하지 않음

<hr>

## ConcurrentSkipListMap

### 시간복잡도
##### get           : O(log n)
##### containsKey   : O(log n)
##### next          : O(1)
java 1.6 에서 나옴
특징 : thread-safe 보장하면서 SynchronizedMap 보다 속도가 빠르다
       - 메모리를 사용하여 O(log n)으로 데이터를 검색, 삽입, 삭제가 가능하다
       - lock이 적게 사용되어야 하는 병렬 처리 시스템에 용의

<hr>

# Queue
## PriorityQueue

### 시간복잡도
##### offer(입력)   : O(log n)
##### peek(get)     : O(1)
##### poll(반환)    : O(log n)
##### size          : O(1)
natural order : JVM에서 제공하는 일반적인거와 다를수 있음 순서 ex) 문자는 ASCII 순서로 정렬
java 1.5 에서 나옴
특징 : 일반적은 큐는 FIFO의 구조를 가지지만 자연 네추럴 오더에 따라 정렬
      - Null을 허용하지 않는다.

<hr>

## ConcurrentLinkedQueue

### 시간복잡도
##### offer     : O(1)
##### peek     : O(1)
##### poll     : O(1)
##### size     : O(n)
java 1.5 에서 나옴 thread-safe 보장(결과에 문제가 발생할 여지 있음)
특징 : FIFO 방식 Queue
 - 데이터/추가/삭제가 빠름
- size는 O(1)이 아니다.
- null을 허용하지 않는다.

<hr>

## ArrayBlockingQueue

### 시간복잡도
##### offer     : O(1)
##### peek     : O(1)
##### poll     : O(1)
##### size     : O(1)
java 1.5에서 나옴
특징 - 고정배열에 일반적인 Queue(FIFO)
- 배열이 고정된 사이즈, 생성되면 변경 안됨

<hr>

## LinkedBlockingQueue

### 시간복잡도
##### offer     : O(1)
##### peek     : O(1)
##### poll     : O(1)
##### size     : O(1)
java 1.5 에서 나옴
특징 : FIFO 정렬
- 크기를 지정하지 않을 경우 Integer.MAX_VALUE와 동일하게 생성됨
- 삽입이 동적임

<hr>

## PriorityBlockingQueue

### 시간복잡도
##### offer     : O(log n)
##### peek     : O(1)
##### poll     : O(log n)
##### size     : O(1)
java 1.5 에서 나옴
특징 : PriorityQueue 와 같은 정렬식으로 저장
- 논리적으로 한대로 추가 가능
- 자원이 고갈되면 OOM 발생

<hr>

## DelayQueue

### 시간복잡도
##### offer     : O(log n)
##### peek     : O(1)
##### poll     : O(log n)
##### size     : O(1)
java 1.5 에서 나옴
특징 : 지연이 만료 되었을 때문 요소를 가져올수있다.

<hr>

## ArrayDeque

### 시간복잡도
##### offer     : O(1)
##### peek     : O(1)
##### poll     : O(1)
##### size     : O(1)
java 1.6에서 나옴
특징 : 양 측면에서 요소를 추가하거나 제거 할수 있는 확장 가능한 배열의 특별한 종류

<hr>

## LinkedBlockingDeque

### 시간복잡도
##### offer     : O(1)
##### peek     : O(1)
##### poll     : O(1)
##### size     : O(1)
java 1.6
특징 : 무제한으로 인스턴스화 할수 있음
