N = int(input())

works = []
for i in range(N):
    s, e = map(int, input().split())
    works.append((s, e))

works.sort(key=lambda x: (x[1], x[0]))

beforeEnd = 0
reserved_works = 0
for work in works:
    if work[0] >= beforeEnd:
        reserved_works += 1
        beforeEnd = work[1]

print(reserved_works)