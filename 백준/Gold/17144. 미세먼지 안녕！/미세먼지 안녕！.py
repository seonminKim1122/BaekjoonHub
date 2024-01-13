# 문제에 대한 풀이는 Python 으로 제공해드리니 이를 Java 로 변환하는 것을 통해
# Java 를 다룰 수 있는지 판단하겠습니다.


def diffuse(room, R, C):
    next_room = [[0 for j in range(C)] for i in range(R)]
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    for i in range(R):
        for j in range(C):
            next_room[i][j] += room[i][j]

            if room[i][j] > 0:

                for k in range(4):
                    nx = i + dx[k]
                    ny = j + dy[k]
                    if nx < 0 or ny < 0 or nx >= R or ny >= C:continue
                    if room[nx][ny] == -1:continue

                    next_room[nx][ny] += (room[i][j] // 5)
                    next_room[i][j] -= (room[i][j] // 5)

    return next_room

def run_aircleaner(room, upper, lower, R, C):

    for i in range(upper - 1, 0, -1):
        room[i][0] = room[i - 1][0]
    for j in range(C - 1):
        room[0][j] = room[0][j + 1]
    for i in range(upper):
        room[i][C - 1] = room[i + 1][C - 1]
    for j in range(C - 1, 0, -1):
        room[upper][j] = room[upper][j - 1]
    room[upper][1] = 0

    for i in range(lower + 1, R - 1):
        room[i][0] = room[i + 1][0]
    for j in range(C - 1):
        room[R - 1][j] = room[R - 1][j + 1]
    for i in range(R - 1, lower, -1):
        room[i][C - 1] = room[i - 1][C - 1]
    for j in range(C - 1, 0, -1):
        room[lower][j] = room[lower][j - 1]
    room[lower][1] = 0            


def sum_of_dust(room):
    result = 0
    for i in range(R):
        for j in range(C):
            if room[i][j] > 0:
                result += room[i][j]
    return result


R, C, T = map(int, input().split())
room = [[0 for j in range(C)] for i in range(R)]
upper = 0
lower = 1
for i in range(R):
    temp = list(map(int, input().split()))
    for j in range(C):
        room[i][j] = temp[j]
        if room[i][j] == -1:
            upper = i - 1
            lower = i

while T > 0:
    room = diffuse(room, R, C)
    run_aircleaner(room, upper, lower, R, C)
    T -= 1

print(sum_of_dust(room))