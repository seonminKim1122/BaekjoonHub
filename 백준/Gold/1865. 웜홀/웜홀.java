import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static List<Link> links;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder results = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        while (TC --> 0) {
            String[] input = br.readLine().split(" ");

            N = Integer.parseInt(input[0]); // 지점의 수
            int M = Integer.parseInt(input[1]); // 도로의 개수
            int W = Integer.parseInt(input[2]); // 웜홀의 개수

            links = new ArrayList<>();
            for (int i = 0; i < M; i++) { // 도로 정보
                String[] temp = br.readLine().split(" ");

                int S = Integer.parseInt(temp[0]) - 1;
                int E = Integer.parseInt(temp[1]) - 1;
                int T = Integer.parseInt(temp[2]);

                links.add(new Link(S, E, T));
                links.add(new Link(E, S, T));
            }

            for (int i = 0; i < W; i++) {
                String[] temp = br.readLine().split(" ");

                int S = Integer.parseInt(temp[0]) - 1;
                int E = Integer.parseInt(temp[1]) - 1;
                int T = Integer.parseInt(temp[2]);

                links.add(new Link(S, E, -T));
            }

            String result = "NO";
            if (bellmanFord(0)) {
                result = "YES";
            }

            results.append(result).append("\n");
        }

        System.out.println(results);
    }

    public static boolean bellmanFord(int start) {

        int[] distance = new int[N];
        Arrays.fill(distance, 10001);
        distance[start] = 0;

        for (int i = 1; i < N; i++) { // N - 1 번 갱신
            for (Link link : links) {
                if (distance[link.to] > distance[link.from] + link.cost) {
                    distance[link.to] = distance[link.from] + link.cost;
                }
            }
        }

        for (Link link : links) {
            if (distance[link.to] > distance[link.from] + link.cost) { // N 번째에 갱신이 이루어진다 = 최단 경로를 구해놨는데 또 감소 (음의 사이클 발생)
                return true;
            }
        }

        return false;
    }
}

class Link {
    int from;
    int to;
    int cost;

    Link (int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}