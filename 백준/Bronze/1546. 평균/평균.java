import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] scores = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, scores[i]);
        }

        double sum = 0;
        for (int i = 0; i < N; i++) {
            double newScore = ((double) scores[i]/(double) max) * 100;
            sum += newScore;
        }

        System.out.println(sum/N);
    }
}