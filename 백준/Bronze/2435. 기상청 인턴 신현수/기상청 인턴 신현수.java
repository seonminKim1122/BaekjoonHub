import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] temperatures = new int[N];
        for (int i = 0; i < N; i++) {
            temperatures[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int i = 0; i < K; i++) {
            result += temperatures[i];
        }

        int temp = result;
        for (int i = K; i < N; i++) {
            temp = temp + temperatures[i] - temperatures[i - K];
            if (temp > result) result = temp;
        }

        System.out.println(result);
    }
}