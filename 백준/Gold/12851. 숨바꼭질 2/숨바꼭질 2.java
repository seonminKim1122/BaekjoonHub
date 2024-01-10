import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        int[] visitTime = new int[100001];
        Arrays.fill(visitTime, Integer.MAX_VALUE);
        Queue<Integer> queue = new LinkedList<>();
        visitTime[N] = 0;
        queue.add(N);


        int fastestTime = visitTime[K];
        int numOfWay = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == K) {
                fastestTime = visitTime[K];
                numOfWay++;
                continue;
            }

            int[] nexts = {now - 1, now + 1, 2 * now};
            for (int next : nexts) {
                if (next < 0 || next > 100000) continue;
                if (visitTime[now] + 1 <= visitTime[next]) {
                    queue.add(next);
                    visitTime[next] = visitTime[now] + 1;
                }
            }
        }

        System.out.println(fastestTime);
        System.out.println(numOfWay);
    }
}