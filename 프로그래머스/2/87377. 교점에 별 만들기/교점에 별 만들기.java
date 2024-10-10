import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        
        int N = line.length;
        
        long minX = Long.MAX_VALUE, minY = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE, maxY = Long.MIN_VALUE;
        
        List<long[]> intersections = new ArrayList<>(); 
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                long[] point = getIntersection(line[i], line[j]);
                if (point == null) continue;
                intersections.add(point);
                
                minY = Math.min(point[0], minY);
                maxY = Math.max(point[0], maxY);
                minX = Math.min(point[1], minX);
                maxX = Math.max(point[1], maxX);
            }            
        }
        
        int height = (int)(maxY - minY + 1);
        int width = (int)(maxX - minX + 1);
        
        String[] answer = new String[height];
        Arrays.fill(answer, ".".repeat(width));
        
        for (long[] point : intersections) {
            int y = (int)(maxY - point[0]);
            int x = (int)(point[1] - minX);
            
            char[] temp = answer[y].toCharArray();
            temp[x] = '*';
            answer[y] = String.valueOf(temp);
        }
        
        return answer;
    }
    
    long[] getIntersection(int[] line1, int[] line2) {
        long A = line1[0], B = line1[1], E = line1[2];
        long C = line2[0], D = line2[1], F = line2[2];
        
        if (A * D - B * C == 0) return null;
        
        if ((B * F - E * D) % (A * D - B * C) != 0 || (E * C - A * F) % (A * D - B * C) != 0) {
            return null;
        }
        
        long x = (B * F - E * D) / (A * D - B * C);
        long y = (E * C - A * F) / (A * D - B * C);
        
        return new long[]{y, x};
    }
}
/*
["....*....", 
".........", 
".........", 
"*.......*", 
".........", 
".........", 
".........", 
".........", 
"*.......*"]

["*.......*",
".........",
".........",
".........",
".........",
"*.......*",
".........",
".........",
"....*...."]
*/