n, k = map(int, input().split())
coins = []
for _ in range(n):
    coins.append(int(input()))

dp = [21e8] * (k + 1)
dp[0] = 0

for price in range(k + 1):
    for coin in coins:
        if price - coin < 0: continue
        dp[price] = min(dp[price], dp[price - coin] + 1)

print(-1 if dp[k] == 21e8 else dp[k])