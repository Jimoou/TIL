```java
//자주 사용하는 String과 StringBuilder의 공통 함수
length() : 문자열의 총길이를 반환한다.
charAt(index) : index 위치에 해당하는 문자를 반환한다.
indexOf(String) : 문자열이 위치하는 index를 반환한다. (String에서는 char도 가능하다.)
substring(from, to) : from부터 to까지 해당되는 문자열을 반환한다. (to index는 포함하지 않는다.)
 

//자주 사용하는 String 클래스 함수
//비교
compareTo(String) : String과 비교 후 String보다 문자가 작다면 1, 크다면 -1, 같다면 0을 반환한다.
compareToIgnoreCase(String) : 대소문자 차이를 무시하고 비교한다.
equals(Object) : Object와 비교 후 같다면 true, 다르면 false를 반환한다. String 클래스는 문자열을 비교한다.
 
//검색
contains(CharSequence) : CharSequence가 포함되어있는지 확인한 후 포함하면 true, 포함하지 않으면 false를 반환한다.
startWith(String) : String으로 시작하면 true, 아니면 false를 반환한다.
endWith(String) : String으로 끝나면 true, 아니면 false를 반환한다.
 
//변환
concat(String) : String과 합친 후 합친 문자열을 반환한다.
repeat(int count) : count만큼 반복 후 반환한다.
replace(char or CharSequence, char or CharSequence) : char, CahrSequence 둘 다 가능하며 앞 인자를 뒷 인자로 변경한다.
toLowerCase() : 소문자로 변환 후 반환한다.
toUpperCase() : 대문자로 변환 후 반환한다.
trim() : 문자열의 "양쪽" 공백을 제거 후 반환한다.
toCharArray() : char 배열 자료형으로 반환한다.

//분리, 결합
split(String regex) : regex를 기준으로 자른 후 String []로 반환한다.
String.join("str" ,String[]) : str을 사이에 넣어주며 String [] 배열을 합친다.

//자주 사용하는 StringBuilder 클래스 함수
//추가
append() : StringBuilder에 추가한다.
 
//삭제
delete(from, to) : from부터 to까지 해당되는 index들을 제거한다. (to는 제외)
deleteCharAt(index) : index에 해당하는 문자 하나를 제거한다.
 
//삽입
insert(index, Object) : index위치에 Object를 추가한다.
 
//변경
replace(from, to, String) : from, to 부분을 String으로 변경한다. (to는 제외)
setLength(len) : len만큼 길이를 변경한다. (len을 0으로 설정하면 내부가 비워지는 효과를 볼 수 있다.)
setChar(index, char) : 해당 index를 char로 변경한다.
reverse() : 문자열을 뒤집는다.
```