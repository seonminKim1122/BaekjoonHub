import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        // BFS 로 문제 풀기
        boolean[] visited = new boolean[1000001];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 0});
        int result = 0;
        while (!queue.isEmpty()) {
            int X = queue.peek()[0];
            int depth = queue.peek()[1];

            if (X == K) {
                result = depth;
                break;
            }
            if (X-1 >= 0 && !visited[X-1]) {
                queue.add(new int[]{X-1, depth+1});
            }

            if (X+1 <= 100000 && !visited[X+1]) {
                queue.add(new int[]{X+1, depth+1});
            }

            if (2*X <= 100000 && !visited[2*X]) {
                queue.add(new int[]{2*X, depth+1});
            }

            queue.remove();
            visited[X] = true;
        }

        System.out.println(result);
    }
}