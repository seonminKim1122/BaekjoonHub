import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] answers;
    static int[] youngJae;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        answers = new int[10];
        for (int i = 0; i < 10; i++) {
            answers[i] = Integer.parseInt(st.nextToken());
        }

        youngJae = new int[10];
        dfs(0);

        System.out.println(result);
    }

    public static void dfs(int depth) {
        if (depth >= 10) {
            int temp = 0;
            for (int i = 0; i < 10; i++) {
                if (answers[i] == youngJae[i]) temp++;
            }

            if (temp >= 5) result++;
            return;
        }

        for (int i = 1; i <= 5; i++) {
            if (depth >= 2 && i == youngJae[depth - 1] && i == youngJae[depth - 2]) continue;
            youngJae[depth] = i;
            dfs(depth + 1);
        }
    }
}