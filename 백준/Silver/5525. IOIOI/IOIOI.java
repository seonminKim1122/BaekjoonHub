import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        char[] S = br.readLine().toCharArray();

        int left = 0;
        int right = 0;

        int cnt = 1;
        int answer = 0;
        while (left < M && right < M) {
            if (cnt == 2 * N + 1) {
                answer++;
                left += 2;
                cnt -= 2;
                continue;
            }

            // 1. left 가 I 가 아닌 경우 right + 1 로 시작점을 이동한다.
            if (S[left] != 'I') {
                right++;
                left = right;
                cnt = 1;
            } else { // 2. left 가 I인 경우
                // 2-1. right != right + 1 이면 right 만 이동
                if (right < M - 1 && S[right] != S[right + 1]) {
                    right++;
                    cnt++;
                } else {
                // 2-2. right == right + 1 이면 right + 1 에서 재시작
                    right++;
                    left = right;
                    cnt = 1;
                }
            }
        }

        System.out.println(answer);

    }

}
