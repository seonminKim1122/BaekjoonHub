import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] basket = new int[N][1];
        for (int w = 0; w < M; w++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st2.nextToken());
            int j = Integer.parseInt(st2.nextToken());
            int k = Integer.parseInt(st2.nextToken());

            for (int l = i; l <= j; l++) {
                basket[l-1][0] = k;
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(basket[i][0]).append(" ");
        }

        System.out.println(sb);
    }
}