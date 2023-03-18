import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (a == v) result++;
        }
        sb.append(result);
        System.out.println(result);
    }
}