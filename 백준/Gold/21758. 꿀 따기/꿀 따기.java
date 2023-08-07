import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] honeys = new int[N];
        int[] honeySums = new int[N];
        for (int i = 0; i < N; i++) {
            honeys[i] = Integer.parseInt(st.nextToken());
            if (i == 0) {
                honeySums[i] = honeys[i];
            } else {
                honeySums[i] = honeySums[i-1] + honeys[i];
            }
        }

        // 벌 - 벌 - 꿀통
        int max = 0;
        for (int i = 1; i < N-1; i++) {
            // honeySums[N-1] - honeys[0] - honeys[i]
            // honeySums[N-1] - honeySums[i]
            int temp = 2 * (honeySums[N-1]) - (honeySums[i] + honeys[0] + honeys[i]);
            if (max < temp) {
                max = temp;
            }
        }

        // 꿀통 - 벌 - 벌
        for (int i = 1; i < N-1; i++) {
            // honeySums[N-1] - honeys[N-1] - honeys[i]
            // honeySums[i-1]
            int temp = honeySums[N-1] + honeySums[i-1] - (honeys[N-1] + honeys[i]);
            if (max < temp) {
                max = temp;
            }
        }

        // 벌 - 꿀통 - 벌
        int temp = honeys[1] + honeySums[N-1] - honeys[0] - honeys[N-1];
        if (max < temp) {
            max = temp;
        }

        System.out.println(max);
    }
}