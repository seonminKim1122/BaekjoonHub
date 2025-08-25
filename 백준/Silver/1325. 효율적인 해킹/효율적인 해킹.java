import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(B).add(A);
        }

        int[] hacks = new int[N + 1];
        int max = hacks[0];
        int[] visit = new int[N + 1];
        int visitCnt = 0;
        for (int i = 1; i <= N; i++) {
            visitCnt++;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visit[i] = visitCnt;

            int hack = 1;
            while (!queue.isEmpty()) {
                int now = queue.poll();

                for (int next : graph.get(now)) {
                    if (visit[next] == visitCnt) continue;
                    queue.add(next);
                    visit[next] = visitCnt;
                    hack++;
                }
            }

            hacks[i] = hack;
            max = Math.max(max, hacks[i]);
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (hacks[i] == max) {
                answer.append(i).append(" ");
            }
        }

        System.out.println(answer);
    }
}