import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        boolean result = solve(0, 0, dots, new boolean[4]);
        answer = result ? 1 : 0;
        return answer;
    }
    
    boolean solve(int depth, int start, int[][] dots, boolean[] path) {
        if (depth == 2) {
            return isParallel(dots, path);
        }
        
        boolean result = false;
        for (int i = start; i < 4; i++) {
            path[i] = true;
            result = result || solve(depth + 1, i + 1, dots, path);
            path[i] = false;
        }
        
        return result;
    }
    
    boolean isParallel(int[][] dots, boolean[] path) {
        List<Integer> temp1 = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            if (path[i]) {
                temp1.add(i);
            } else {
                temp2.add(i);
            }
        }
        
        int[] dot1 = dots[temp1.get(0)];
        int[] dot2 = dots[temp1.get(1)];
        
        int[] dot3 = dots[temp2.get(0)];
        int[] dot4 = dots[temp2.get(1)];
        
        double line1 = (double)Math.abs(dot2[1] - dot1[1]) / Math.abs(dot2[0] - dot1[0]);
        double line2 = (double)Math.abs(dot4[1] - dot3[1]) / Math.abs(dot4[0] - dot3[0]);
        
        return line1 == line2;
    }
}