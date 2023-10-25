import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(i).append(" ");
            dfs(i, 1, sb);
            sb.setLength(sb.length() - 2);
        }
    }

    public static void dfs(int i, int depth, StringBuilder sb) {
        if (depth == M) {
            System.out.println(sb);
            return;
        }

        for (int j = i; j <= N; j++) {
            sb.append(j).append(" ");
            dfs(j, depth + 1, sb);
            sb.setLength(sb.length() - 2);
        }
    }
}