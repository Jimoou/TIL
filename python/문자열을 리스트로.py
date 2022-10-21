a= "I love python"
print(a.split()) #공백을 기준으로 나눈다.
 
>>['I','love','python']

a='I/love/python'
print(a.split('/'))
 
>>['I', 'love', 'python']

a="I love python"
print(list(a))
 
>>['I', ' ', 'l', 'o', 'v', 'e', ' ', 'p', 'y', 't', 'h', 'o', 'n']

