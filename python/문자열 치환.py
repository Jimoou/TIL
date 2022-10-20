re.sub('패턴', '바꿀문자열', '문자열', 바꿀횟수)

1. 문자열에서 특수문자 제거
\uAC00-\uD7A30 : 모든 한글 음절(가-힣)
a-z : 영어 소문자
A-Z : 영어 대문자
0-9 : 숫자
\s : 띄어쓰기
import re

str = "AA**BB#@$CC 가나다-123"
new_str = re.sub(r"[^\uAC00-\uD7A30-9a-zA-Z\s]", "", str)

print(new_str)
#AABBCC 가나다123

2. 문자열에서 숫자만 남기기
import re

string = "AA**BB#@$CC 가나다-123"

new_str = re.sub(r"[^0-9]", "", string)
print(new_str)
#123

3. 문자열에서 숫자만 제거
import re

string = "AA**BB#@$CC 가나다-123"

new_str = re.sub(r"[0-9]", "", string)
print(new_str)
#AA**BB#@$CC 가나다-

4. 문자열에서 알파벳만 남기기
import re

string = "AA**BB#@$CC 가나다-123"

new_str = re.sub(r"[^a-zA-Z]", "", string)
print(new_str)
#AABBCC
