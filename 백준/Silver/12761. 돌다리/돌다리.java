import java.util.*;
import java.io.*;
public class Main {
    static int A, B, N, M, result;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[100001];
        visited = new boolean[100001];

        BFS(N);
        System.out.println(result);


    }
    public static void BFS(int v) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(v, 0));
        visited[v] = true;
            while (!q.isEmpty()) {
                Node n = q.poll();
                int x = n.x;

                if (x - 1 >= 0 && !visited[x - 1]) {
                    visited[x - 1] = true;
                    arr[x-1] = n.cnt+1;
                    q.add(new Node(x - 1, n.cnt + 1));
                }
                if (x + 1 < 100001 && !visited[x + 1]) {
                    visited[x + 1] = true;
                    arr[x+1] = n.cnt+1;
                    q.add(new Node(x + 1, n.cnt+1));
                }
                if (x + A < 100001 && !visited[x + A]) {
                    visited[x + A] = true;
                    arr[x+A] = n.cnt+1;
                    q.add(new Node(x + A, n.cnt + 1));
                }
                if (x - A >= 0 && !visited[x - A]) {
                    visited[x - A] = true;
                    arr[x-A] = n.cnt+1;
                    q.add(new Node(x - A, n.cnt + 1));
                }
                if (x + B < 100001 && !visited[x + B]) {
                    visited[x + B] = true;
                    arr[x+B] = n.cnt+1;
                    q.add(new Node(x + B, n.cnt + 1));
                }
                if (x - B >= 0 && !visited[x - B]) {
                    visited[x - B] = true;
                    arr[x-B] = n.cnt+1;
                    q.add(new Node(x - B, n.cnt + 1));
                }
                if (x * A < 100001 && !visited[x * A]) {
                    visited[x * A] = true;
                    arr[x*A] = n.cnt+1;
                    q.add(new Node(x * A, n.cnt + 1));
                }
                if (x * B < 100001 && !visited[x * B]) {
                    visited[x * B] = true;
                    arr[x*B] = n.cnt+1;
                    q.add(new Node(x * B, n.cnt + 1));
                }
                if (arr[M] != 0) {
                    result = n.cnt+1;
                    return;
                }
        }

    }
}

class Node {
    int x, cnt;
    Node (int x, int cnt) {
        this.x = x;
        this.cnt = cnt;
    }
}