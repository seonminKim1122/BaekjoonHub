import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] basket = new int[N];
        for (int i = 0; i < N; i++) {
            basket[i] = i+1;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            int begin = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st2.nextToken());
            int mid = Integer.parseInt(st2.nextToken());
            // 1 2 3 4 5 6
            for (int j = begin; j < mid; j++) {
                int temp = basket[begin-1];
                for (int k = begin; k < end; k++) {
                    int idx = k-1;
                    basket[idx] = basket[idx+1];
                }
                basket[end-1] = temp;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(basket[i]).append(" ");
        }
        System.out.println(sb);
    }
}