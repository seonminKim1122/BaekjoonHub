whiteBoard = [[0 for _ in range(101)] for _ in range(101)]

N = int(input())
for _ in range(N):
    paperX, paperY = map(int, input().split())

    for i in range(paperX, paperX + 10):
        for j in range(paperY, paperY + 10):
            whiteBoard[i][j] = 1
            

result = 0

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
for i in range(101):
    for j in range(101):
        if whiteBoard[i][j] == 0:
            # 인접한 칸들에 1의 갯수를 더한다
            for k in range(4):
                nx = i + dx[k]
                ny = j + dy[k]

                if nx < 0 or ny < 0 or nx >= 100 or ny >= 100:continue
                if whiteBoard[nx][ny] == 0:continue

                result += 1

print(result)