@rjust
오른쪽으로 정렬하도록 도와준다.
rjust를 통해 공백의 수, 공백을 메워줄 문자를 넣어준다.
val = "77".rjust(5, "0")
print(val) //00077

val = "77777".rjust(5, "0")
print(val) //77777

val = "123".rjust(5, "a")
print(val) //aa123

val = "123".rjust(3, "a")
print(val) //123

@ljust
왼쪽으로 정렬하도록 도와준다.
ljust를 통해 공백의 수, 공백을 메워줄 문자를 넣어준다.
val = "222".ljust(3, "0")
print(val) //222

val = "222".ljust(15, "a")
print(val) //222aaaaaaaaaaaa

@zfill
이는 0을 왼쪽에 채워주는 역할을 한다.
val = "2".zfill(3)
print(val) //002

val = "50000".zfill(5)
print(val) //50000

val = "123".zfill(5)
print(val) //00123
