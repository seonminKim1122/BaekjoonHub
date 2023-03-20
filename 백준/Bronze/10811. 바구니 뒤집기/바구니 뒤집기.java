import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] basket = new int[N+1];

        for (int i = 1; i <= N; i++) {
            basket[i] = i;
        }

        for (int k = 0; k < M; k++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st2.nextToken());
            int j = Integer.parseInt(st2.nextToken());

            for (int l = 0; l <= (j-i)/2; l++) {
                int temp = basket[j-l];
                basket[j-l] = basket[i+l];
                basket[i+l] = temp;
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(basket[i]).append(" ");
        }

        System.out.println(sb);
    }
}