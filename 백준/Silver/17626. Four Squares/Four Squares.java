import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        int[] dp = new int[50001];
        Arrays.fill(dp, 50001);

        for (int i = 1; i <= 223; i++) {
            dp[i * i] = 1;
        }

        for (int i = 1; i <= 50000; i++) {
            for (int j = 1; j * j < i; j++) {
                dp[i] = Math.min(dp[i - j * j] + dp[j * j], dp[i]);
            }
        }
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(dp[n]);
    }

}