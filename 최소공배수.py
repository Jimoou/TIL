a, b, c = map (int, input().split())

index = 1
while index%a != 0 or index%b != 0 or index%c != 0:
    index += 1

print(index)
