>>> for entry in enumerate(['A', 'B', 'C']):
...     print(entry)
...
(0, 'A')
(1, 'B')
(2, 'C')

>>> for i, letter in enumerate(['A', 'B', 'C'], start=1):
...     print(i, letter)
...
1 A
2 B
3 C

enumerate() 함수는 기본적으로 인덱스와 원소로 이루어진 tuple을 만들어줌.

2차원 배열에서 루프
>>> matrix = [['A', 'B', 'C'], ['D', 'E', 'F'], ['G', 'H', 'I']]
>>> for r, row in enumerate(matrix):
...     for c, letter in enumerate(row):
...             print(r, c, letter)
...
0 0 A
0 1 B
0 2 C
1 0 D
1 1 E
1 2 F
2 0 G
2 1 H
2 2 I
