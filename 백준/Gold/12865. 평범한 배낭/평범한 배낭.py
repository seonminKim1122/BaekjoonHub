N, K = map(int, input().split())
dp = [[0 for _ in range(K + 1)] for _ in range(N + 1)]

items = [(0,0)]
for i in range(N):
    W, V = map(int, input().split())
    items.append((W, V))

for i in range(1, N + 1):
    W, V = items[i]

    for j in range(1, K + 1):
        dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
        if j - W >= 0:
            dp[i][j] = max(dp[i][j], dp[i - 1][j - W] + V)

print(dp[N][K])