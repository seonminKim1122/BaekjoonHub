import sys
from collections import deque

N, M, K = map(int, sys.stdin.readline().split())

board = [[0 for _ in range(M)] for _ in range(N)]
for i in range(N):
    line = sys.stdin.readline()
    for j in range(M):
        board[i][j] = int(line[j])

def BFS():
    visited = [[[0 for _ in range(M)] for _ in range(N)] for _ in range(K + 1)]
    q = deque()
    q.append((0, 0, 0))
    visited[0][0][0] = 1

    dx = (-1, 1, 0 ,0)
    dy = (0, 0, -1, 1)
    while q:
        x, y, cost = q.popleft()

        if x == N - 1 and y == M - 1:
            return visited[cost][x][y]

        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]

            if nx < 0 or ny < 0 or nx >= N or ny >= M:continue

            if board[nx][ny] == 1 and cost + 1 <= K:
                if visited[cost + 1][nx][ny] > 0: continue
                visited[cost + 1][nx][ny] = visited[cost][x][y] + 1
                q.append((nx, ny, cost + 1))

            elif board[nx][ny] == 0:
                if visited[cost][nx][ny] > 0: continue
                visited[cost][nx][ny] = visited[cost][x][y] + 1
                q.append((nx, ny, cost))

    return -1

print(BFS())
