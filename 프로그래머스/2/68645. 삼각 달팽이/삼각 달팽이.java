class Solution {
    public int[] solution(int n) {
        
        int[][] temp = new int[n][n];
        
        int v = 1;
        int last = n * (n + 1) / 2;
        int[] now = new int[]{0, 0};
        int d = 0;
        while (v <= last) {
            if (temp[now[0]][now[1]] == 0) {
                temp[now[0]][now[1]] = v++;
            }
            
            if (canMove(temp, now, d)) {
                move(now, d);
            } else {
                d = (d + 1) % 3;
            }
        }
 
        int[] answer = new int[last];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = temp[i][j];
            }
        }
            
        return answer;
    }

    boolean canMove(int[][] temp, int[] now, int d) {
        switch (d) {
            case 0:
                return (now[0] + 1 < temp.length && temp[now[0] + 1][now[1]] == 0);
            case 1:
                return (now[1] + 1 < temp.length && temp[now[0]][now[1] + 1] == 0);
            default:
                return (now[0] - 1 >= 0 && now[1] - 1 >= 0 && temp[now[0] - 1][now[1] - 1] == 0);
        }
    }
    
    void move(int[] now, int d) {
        switch (d) {
            case 0:
                now[0]++;
                break;
            case 1:
                now[1]++;
                break;
            default:
                now[0]--;
                now[1]--;
        }
    }
}
/*
1 0 0 0 0 0
2 15 0 0 0 0
3 16 14 0 0 0
4 17 21 13 0 0
5 18 19 20 12 0
6 7 8 9 10 11

더 갈 칸이 없으면 방향 전환!
-> 더 갈 칸 : 인덱스가 벗어나지 않으면서 값이 채워지지 않은 칸
*/