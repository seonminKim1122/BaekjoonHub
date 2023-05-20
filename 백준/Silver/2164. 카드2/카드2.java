import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (queue.size() >= 2) {
            // 1장 버리기
            queue.poll();

            // 맨 윗장을 맨 아래로 옮기기
            queue.add(queue.poll());
        }

        System.out.println(queue.poll());
    }
}