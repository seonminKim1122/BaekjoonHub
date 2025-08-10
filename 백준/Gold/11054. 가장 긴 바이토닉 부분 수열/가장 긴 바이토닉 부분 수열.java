import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] LIS = new int[N];
        LIS[0] = 1;
        for (int i = 1; i < N; i++) {
            LIS[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }
            }
        }

        int[] LDS = new int[N];
        LDS[N - 1] = 1;
        for (int i = N - 2; i >= 0; i--) {
            LDS[i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (A[j] < A[i]) {
                    LDS[i] = Math.max(LDS[i], LDS[j] + 1);
                }
            }
        }

        int answer = LIS[0] + LDS[0] - 1;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, LIS[i] + LDS[i] - 1);
        }

        System.out.println(answer);
    }
}