import java.util.*;

class Solution {
        
    int solution(int[][] land) {
        
        int N = land.length;
        int[][] point = new int[N][4];
        for (int col = 0; col < 4; col++) {
            point[0][col] = land[0][col];
        }
        System.out.println(Arrays.toString(point[0]));
        for (int row = 1; row < N; row++) {
            
            for (int col = 0; col < 4; col++) {
                int temp = land[row][col];
                for (int before = 0; before < 4; before++) {
                    if (before == col) continue;
                    temp = Math.max(temp, point[row - 1][before] + land[row][col]); 
                }
                point[row][col] = temp;
            }
        }
        
        int answer = point[N - 1][0];
        for (int col = 1; col < 4; col++) {
            answer = Math.max(answer, point[N - 1][col]);
        }
        
        return answer;
    }

}

/*
dfs 로 완탐하면 시간 초과 -> dp 방식 활용

*/