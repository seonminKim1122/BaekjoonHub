import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> heap = new PriorityQueue<>(
                (o1, o2) -> {
                    if (Math.abs(o1) == Math.abs(o2)) {
                        return o1 - o2;
                    } else {
                        return Math.abs(o1) - Math.abs(o2);
                    }
                }
        );

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            
            if (x != 0) { // 배열에 x 라는 값을 추가
                heap.add(x);
            } else { // 절대값이 가장 작은 값을 출력하고 그 값을 배열에서 제거
                Integer temp = heap.poll();
                if (temp == null) {
                    sb.append(0);
                } else {
                    sb.append(temp);
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}