import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 집의 갯수(2 <= N <= 100000)
        int M = Integer.parseInt(st.nextToken());   // 길의 갯수(1 <= M <= 1000000)

        PriorityQueue<Edge> edges = new PriorityQueue<>();
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());   // A
            int B = Integer.parseInt(st.nextToken());   // B
            int C = Integer.parseInt(st.nextToken());   // C

            Edge edge = new Edge(A, B, C);
            edges.add(edge);
        }

        int usedEdge = 0;
        int result = 0;
        int[] parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        while (!edges.isEmpty() && usedEdge < N - 1) {
            Edge edge = edges.poll();

            if (union(edge.A, edge.B, parent))  {
                usedEdge++;
                result += edge.C;
            }

            if (usedEdge == N - 1) {
                result -= edge.C;
                break;
            }
        }

        System.out.println(result);
    }

    static boolean union(int A, int B, int[] parent) {
        int root1 = find(A, parent);
        int root2 = find(B, parent);

        if (root1 == root2) {
            return false;
        }

        parent[root2] = root1;
        return true;
    }

    static int find(int A, int[] parent) {
        if (parent[A] == A) {
            return A;
        }

        parent[A] = find(parent[A], parent);
        return parent[A];
    }

    static class Edge implements Comparable<Edge> {
        int A;
        int B;
        int C;

        Edge(int A, int B, int C) {
            this.A = A;
            this.B = B;
            this.C = C;
        }

        @Override
        public int compareTo(Edge other) {
            return this.C - other.C;
        }
    }
}