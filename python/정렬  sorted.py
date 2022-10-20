sorted(정렬할 데이터)
sorted(정렬할 데이터, reverse 파라미터)
sorted(정렬할 데이터, key 파라미터)
sorted(정렬할 데이터, key 파라미터, reverse 파라미터)

- reverse 옵션
(reverse 파라미터)해당 파라미터를 이용하면 오름차순으로 정렬할지 내림차순으로 정렬할지 정할 수 있습니다.
디폴트로는 reverse=False로 오름차순으로 정렬이 됩니다.
sorted( ~~ , reverse=True)로 입력하게 되면 내림차순으로 정렬하여 반환합니다.

** 리스트.sort()와 sorted(리스트)의 가장 큰 차이는
리스트.sort() 는 본체의 리스트를 정렬해서 변환하는 것이고,
sorted(리스트) 는 본체 리스트는 내버려두고, 정렬한 새로운 리스트를 반환하는 것입니다.
