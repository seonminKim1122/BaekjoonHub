import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        List<Integer> sequence = new ArrayList<>();
        while (k > 1) {
            sequence.add(k);
            k = k % 2 == 0 ? k / 2: (3 * k) + 1;
        }
        sequence.add(1);
        
        int n = sequence.size() - 1;
        for (int i = 0; i < ranges.length; i++) {
            int[] range = ranges[i];
            
            int from = range[0];
            int to = n + range[1];
         
            answer[i] = calc(from, to, sequence);
        }
        
        return answer;
    }
    
    public double calc(int from, int to, List<Integer> sequence) {
        double result = 0;
        
        if (to < from) return -1d;
        
        for (int i = from; i < to; i++) {
            int h1 = sequence.get(i);
            int h2 = sequence.get(i + 1);
            
            int high = Math.max(h1, h2);
            int low = Math.min(h1, h2);
            
            // 사각형의 넓이(high)에서 삼각형((high - low) / 2)을 뺀다.
            
            double s = (double)high - (double)(high - low) / 2;
            result += s;
        }
        
        return result;
    }
}