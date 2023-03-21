import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int C = Integer.parseInt(br.readLine());

        for (int i = 0; i < C; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] scores = new int[N];
            int sum = 0;
            for (int j = 0; j < N; j++) {
                scores[j] = Integer.parseInt(st.nextToken());
                sum += scores[j];
            }

            double avg = sum / (double) N;
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (scores[j] > avg) {
                    count++;
                }
            }

            double result = ((double) count / N)*100;
            sb.append(String.format("%.3f", result)+"%\n");
        }
        System.out.println(sb);
    }
}