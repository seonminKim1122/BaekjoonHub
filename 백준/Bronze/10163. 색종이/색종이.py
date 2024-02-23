paper = [[0] * 1001 for _ in range(1001)]
n = int(input())
result = [0] * (n + 1)
for k in range(n):
    x, y, width, height = map(int, input().split())
    for i in range(y, y + height):
        for j in range(x, x + width):
            if paper[i][j] != 0:
                result[paper[i][j]] -= 1
            paper[i][j] = k + 1
            result[paper[i][j]] += 1

for i in range(1, n + 1):
    print(result[i])