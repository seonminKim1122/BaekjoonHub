import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<int[]> towers = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int tower = Integer.parseInt(st.nextToken());

            while (true) {
                if (towers.isEmpty()) { // 레이저를 받을 송신탑이 없다
                    sb.append("0").append(" ");
                    towers.push(new int[]{tower, i+1});
                    break;
                } else { // 송신탑이 있다
                    if (towers.peek()[0] < tower) { // 바로 직전 탑이 나보다 작으면 스택에서 제거(왜? 어차피 나 이후로 들어오는 레이저는 나한테 걸릴 거니까)
                        towers.pop();
                    } else { // 바로 직전 탑이 나보다 크면 해당 탑의 위치를 append 하고 스택에 나를 푸쉬
                        sb.append(towers.peek()[1]).append(" ");
                        towers.push(new int[]{tower, i+1});
                        break;
                    }
                }
            }

        }

        System.out.println(sb);
    }
}