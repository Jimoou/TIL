1. 반복문으로 리스트의 모든 요소들을 하나의 문자열로 변환
for loop를 이용하여 리스트를 문자열로 변환하는 코드를 구현할 수 있습니다.

def listToString(str_list):
    result = ""
    for s in str_list:
        result += s + " "
    return result.strip()


str_list = ['This', 'is', 'a', 'python tutorial']
result = listToString(str_list)
print(result)
Output:

This is a python tutorial
2. String.join()으로 리스트의 모든 요소들을 하나의 문자열로 변환
join()을 이용하면 다음과 같이 리스트를 문자열로 변환할 수 있습니다.

str_list = ['This', 'is', 'a', 'python tutorial']
result = ' '.join(s for s in str_list)
print(result)
Output:

This is a python tutorial
3. join()으로 숫자가 포함된 리스트를 문자열로 변환
리스트가 문자열로만 구성되어있지 않고 숫자가 포함되었을 때, 위의 코드는 실행 중에 exception이 발생합니다.

다음 코드는 숫자를 문자열로 변환하고, join()으로 문자열을 연결합니다.

str_list = ['There', 'is', 4, "items"]
result = ' '.join(str(s) for s in str_list)
print(result)
Output:

There is 4 items
4. map()으로 숫자가 포함된 리스트를 문자열로 변환
다음 코드는 map()을 이용하여 숫자를 문자열로 변환합니다. list comprehension을 사용한 위의 코드보다 더 간단합니다.

str_list = ['There', 'is', 4, "items"]
result = ' '.join(map(str, str_list))
print(result)
Output:

There is 4 items
