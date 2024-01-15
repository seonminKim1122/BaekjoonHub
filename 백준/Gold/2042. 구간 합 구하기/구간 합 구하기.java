import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] arr = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        StringBuilder answer = new StringBuilder();
        long[] tree = new long[arr.length * 4];
        makeTree(arr, tree, 1, 1, N);
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                long temp = arr[b];
                arr[b] = c;
                long diff = arr[b] - temp;
                update(tree, 1, 1, N, b, diff);
            } else {
                // 구간합 구하기
                answer.append(prefixSum(tree, 1, 1, N, b, c));
                answer.append("\n");
            }
        }

        System.out.println(answer);
    }

    public static long makeTree(long[] arr, long[] tree, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return tree[node];
        }

        int mid = (start + end) / 2;
        tree[node] = makeTree(arr, tree, 2 * node, start, mid) + makeTree(arr, tree, 2 * node + 1, mid + 1, end);
        return tree[node];
    }

    public static void update(long[] tree, int node, int start, int end, int idx, long diff) {
        if (idx < start || idx > end) return;

        tree[node] += diff;
        if (start == end) return;

        int mid = (start + end) / 2;
        update(tree, 2 * node, start, mid, idx, diff);
        update(tree, 2 * node + 1, mid + 1, end, idx, diff);
    }

    public static long prefixSum(long[] tree, int node, int start, int end, int left, long right) {
        if (right < start || end < left) return 0;

        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return prefixSum(tree, 2 * node, start, mid, left, right) + prefixSum(tree, 2 * node + 1, mid + 1, end, left, right);
    }
}