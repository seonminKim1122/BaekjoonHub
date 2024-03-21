import heapq
import sys

heap = []

N = int(input())
for _ in range(N):
    x = int(sys.stdin.readline())

    if x == 0:
        if len(heap) == 0:
            print(0)
        else:
            print(heapq.heappop(heap)[1])
    else:
        heapq.heappush(heap, (abs(x), x))