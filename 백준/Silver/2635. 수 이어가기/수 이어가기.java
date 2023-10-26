import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int maxCnt = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int cnt = 2;

            int last = i;
            int beforeLast = N;
            List<Integer> temp = new ArrayList<>();
            temp.add(N);
            temp.add(i);

            int now = beforeLast - last;
            while (now >= 0) {
                cnt++;
                temp.add(now);

                beforeLast = last;
                last = now;
                now = beforeLast - last;
            }

            if (cnt > maxCnt) {
                maxCnt = cnt;
                result = temp;
            }
        }

        System.out.println(maxCnt);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}