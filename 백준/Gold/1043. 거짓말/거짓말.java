import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사람의 수
        int M = Integer.parseInt(st.nextToken());

        boolean[] knowTruth = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        int numOfKnowTruth = Integer.parseInt(st.nextToken());
        for (int i = 0; i < numOfKnowTruth; i++) {
            int person = Integer.parseInt(st.nextToken());
            knowTruth[person] = true;
        }

        boolean[][] meet = new boolean[N + 1][N + 1];
        List<int[]> parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int numOfAppender = Integer.parseInt(st.nextToken());
            // 참가자들 번호(이걸 통해서 그래프 만들자)
            int[] appender = new int[numOfAppender];
            for (int j = 0; j < numOfAppender; j++) {
                appender[j] = Integer.parseInt(st.nextToken());
            }
            parties.add(appender);

            for (int x = 0; x < numOfAppender - 1; x++) {
                for (int y = x + 1; y < numOfAppender; y++) {
                    int p1 = appender[x];
                    int p2 = appender[y];

                    meet[p1][p2] = meet[p2][p1] = true;
                }
            }
        }

        for (int i = 0; i < N + 1; i++) {
            if (knowTruth[i]) {
                // dfs 수행
                dfs(knowTruth, meet, i);
            }
        }

        int result = 0;
        for (int[] appenders : parties) {
            boolean canLie = true;
            for (int appender : appenders) {
                if (knowTruth[appender]){
                    canLie = false;
                    break;
                }
            }

            if (canLie) result++;
        }

        System.out.println(result);
    }

    public static void dfs(boolean[] knowTruth, boolean[][] meet, int person) {
        boolean[] together = meet[person];

        for (int i = 0; i < together.length; i++) {
            if (together[i] && !knowTruth[i]) {
                knowTruth[i] = true;
                dfs(knowTruth, meet, i);
            }
        }
    }
}