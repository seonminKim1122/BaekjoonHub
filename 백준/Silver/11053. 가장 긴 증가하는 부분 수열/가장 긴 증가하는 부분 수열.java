import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int N = Integer.parseInt(br.readLine());
      int[] numbers = new int[N];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        numbers[i] = Integer.parseInt(st.nextToken());
      }
      
      int[] dp = new int[N]; // dp[i] : i번째 값을 마지막으로 갖는 가장 긴 증가하는 부분 수열의 길이
      dp[0] = 1;
      
      int answer = dp[0];
      for (int i = 1; i < N; i++) {
        dp[i] = 1;
        for (int j = 0; j < i; j++) {
          if (numbers[j] < numbers[i]) {
            dp[i] = Math.max(dp[i], dp[j] + 1);
          }
        }
        
        answer = Math.max(answer, dp[i]);
      }
      
      System.out.println(answer);
  }
}