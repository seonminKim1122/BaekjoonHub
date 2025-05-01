import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        if (n == 0) {
            System.out.println(0);
            return;
        }
        
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }
        
        System.out.println(solve(scores, countExcept(n, 15)));
    }
    
    private static int solve(int[] scores, int except) {
        // score 정렬
        Arrays.sort(scores);
        
        // 절사 평균 구할 대상 수
        int cnt = scores.length - 2 * except;
        
        int sum = 0;
        for (int i = except; i < except + cnt; i++) {
            sum += scores[i];
        }
        
        return calc(sum, cnt);
    }
    
    private static int countExcept(int n, int percent) {
        return calc(n * percent, 100);
    }
    
    private static int calc(int numerator, int denominator) {
        if (2 * (numerator % denominator) < denominator) {
	          return numerator / denominator;
        } else {
            return numerator / denominator + 1;
        }
    }
}