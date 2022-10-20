!!!!공백이 섞여 있으면 False!!!!!

Ex1 = 'A' 
Ex2 = 'ABC'
Ex3 = "앱피아"
Ex4 = "Hello Appia"
Ex5 = "100Appia"
#print the is the result for isalpha()
 
print(Ex1.isalpha()) //True
print(Ex2.isalpha()) //True
print(Ex3.isalpha()) //True
print(Ex4.isalpha()) //False
print(Ex5.isalpha()) //False

Ex1 = '010-1234-5678'
Ex2 = '123456'
Ex3 = "R4R3"
print(Ex1.isdigit()) //False
print(Ex2.isdigit()) //True
print(Ex3.isdigit()) //False
