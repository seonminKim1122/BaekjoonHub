import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input1 = br.readLine().split("");
        String[] input2 = br.readLine().split("");

        int[] init1 = new int[N];
        int[] init2 = new int[N];
        int[] target = new int[N];

        for (int i = 0; i < N; i++) {
            init1[i] = Integer.parseInt(input1[i]);
            init2[i] = init1[i];
            target[i] = Integer.parseInt(input2[i]);
        }

        init2[0] = (init2[0] + 1) % 2;
        init2[1] = (init2[1] + 1) % 2;

        int cnt1 = 0;
        int cnt2 = 1;
        // init1 은 0번째 스위치 안 누른 상태, init2 는 0번째 스위치를 누른 상태
        for (int i = 1; i < N; i++) {
            if (init1[i - 1] != target[i - 1]) { // i - 1번째 상태가 다르면 i 번째 스위치 눌러야 함
                init1[i] = (init1[i] + 1) % 2;
                if (i + 1 < N) {
                    init1[i + 1] = (init1[i + 1] + 1) % 2;
                }
                cnt1++;
            }

            if (init2[i - 1] != target[i - 1]) {
                init2[i] = (init2[i] + 1) % 2;
                if (i + 1 < N) {
                    init2[i + 1] = (init2[i + 1] + 1) % 2;
                }
                cnt2++;
            }
        }

        int result = -1;

        if (init1[N - 1] == target[N - 1] && init2[N - 1] == target[N - 1]) {
            result = Math.min(cnt1, cnt2);
        } else if (init1[N - 1] == target[N - 1]) {
            result = cnt1;
        } else if (init2[N - 1] == target[N - 1]){
            result = cnt2;
        }

        System.out.println(result);
    }
}