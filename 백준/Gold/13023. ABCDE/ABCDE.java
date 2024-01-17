import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static List<List<Integer>> relations;
    static boolean[] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 사람의 수
        int M = Integer.parseInt(st.nextToken()); // 관계의 수

        relations = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            relations.add(new ArrayList<>());
        }
        visited = new boolean[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relations.get(a).add(b);
            relations.get(b).add(a);
        }

        for (int i = 0; i < N; i++) { // 관계 그룹이 여러 개일 경우 대비해 모든 지점을 시작점으로 dfs() 해봐야 함
            dfs(i, 1);
            if (result == 1) break;
        }

        System.out.println(result);
    }

    public static void dfs(int from, int depth) {
        if (depth >= 5) {
            result = 1;
            return;
        }

        visited[from] = true;

        for (int to : relations.get(from)) {
            if (!visited[to] && result == 0) {
                dfs(to, depth + 1);
            }
        }
        
        visited[from] = false;
    }
}

/*
전체 그래프 상에서 depth >= 5 인 경로가 존재하는지를 찾는 문제
 */