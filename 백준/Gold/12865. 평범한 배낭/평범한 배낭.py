N, K = map(int, input().split())
dp = [0 for _ in range(K + 1)]
items = []
for i in range(N):
    W, V = map(int, input().split())
    items.append((W, V))

for i in range(N):
    W, V = items[i]
    for j in range(K, 0, -1):
        if j - W >= 0:
            dp[j] = max(dp[j], dp[j - W] + V)

print(dp[K])