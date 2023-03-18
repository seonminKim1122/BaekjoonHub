import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st2.nextToken());
            if (a < X) sb.append(a).append(" ");
        }
        System.out.println(sb);
    }
}