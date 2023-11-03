import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;

    static int[][] relations;
    static boolean[] isMatched;

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        relations = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;

            relations[i][0] = u;
            relations[i][1] = v;
        }

        isMatched = new boolean[N];
        dfs(0, 0);
        System.out.println(result == N ? result : result + 1);
    }

    public static void dfs(int numOfDancer, int idx) {
        if (idx >= M) {
            result = Math.max(numOfDancer, result);
            return;
        }

        if (isMatched[relations[idx][0]] || isMatched[relations[idx][1]]) {
            dfs(numOfDancer, idx + 1);
        } else {

            isMatched[relations[idx][0]] = isMatched[relations[idx][1]] = true;
            dfs(numOfDancer + 2, idx + 1);

            isMatched[relations[idx][0]] = isMatched[relations[idx][1]] = false;
            dfs(numOfDancer, idx + 1);
        }
    }
}