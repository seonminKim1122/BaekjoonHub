import java.io.*;
import java.util.*;

class Main {
    
    static int answer = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        
        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        
        solve(numbers, 0, 0, N, S);
        if (S == 0) {
            System.out.println(answer - 1);
        } else {
            System.out.println(answer);
        }
    }
    
    public static void solve(int[] numbers, int sum, int depth, int N, int S) {
        if (depth == N) {
            if (sum == S) answer++;
            return;
        }
        
        solve(numbers, sum + numbers[depth], depth + 1, N, S);
        
        solve(numbers, sum, depth + 1, N, S);
    }
}