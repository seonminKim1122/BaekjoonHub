class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int N = lock.length;
        int M = key.length;
        
        int[][] result = turnKey(key, M);
       
        // N x N 사이즈 를 (N + 2 * (M - 1)) x (N + 2 * (M - 1)) 사이즈로 확장
        int size = N + 2 * (M - 1);
        int[][] map = new int[size][size];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[M - 1 + i][M - 1 + j] = lock[i][j];
            }
        }
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int t = 0; t < 4; t++) {
                    key = turnKey(key, M);
                    if (isFit(map, key, i, j, size, N, M)) return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean isFit(int[][] map, int[][] key, int x, int y, int size, int N, int M) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (M - 1 <= i && i < size - (M - 1) && M - 1 <= j && j < size - (M - 1)) {
                    // (i, j) 가 원래 lock 의 범위일 때
                    if (map[i][j] == 1) {
                        // key 의 범위를 벗어나면 pass
                        if (i < x || j < y || i >= x + M || j >= y + M) continue;
                        // key 의 범위 내부이면 1인지 체크
                        if (key[i - x][j - y] == 1) return false;
                    } else {
                        // key 의 범위를 벗어나는지 체크
                        if (i < x || j < y || i >= x + M || j >= y + M) return false;
                        // key 의 범위 내부이면 0인지 체크
                        if (key[i - x][j - y] == 0) return false;
                    }
                }
            }
        }
        return true;
    }
    
    public int[][] turnKey(int[][] key, int M) {
        int[][] result = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                result[j][M - 1 - i] = key[i][j];
            }
        }
        return result;
    }
}
/*
(0, 0) ... (0, M - 1)
...
(M - 1, 0) ... (M - 1, M - 1)

turn
(M - 1, 0) ... (0, 0)
...
(M - 1, M - 1) ... (0, M - 1)
*/