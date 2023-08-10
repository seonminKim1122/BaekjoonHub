import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());


        int bbeonCnt = 0;
        int degiCnt = 0;
        int now = 0;
        int n = 1;

        while (true) {
            // 뻔-데기-뻔-데기
            for (int i = 0; i < 4; i++) {
                if (i % 2 == 0) {
                    bbeonCnt++;
                    if (target == 0 && bbeonCnt == T) {
                        System.out.println(now);
                        return;
                    }
                } else {
                    degiCnt++;
                    if (target == 1 && degiCnt == T) {
                        System.out.println(now);
                        return;
                    }
                }

                now = (now + 1) % A;
            }

            // 뻔 x (n) + 데기 x (n)
            for (int i = 0; i < n+1; i++) {
                bbeonCnt++;
                if (target == 0 && bbeonCnt == T) {
                    System.out.println(now);
                    return;
                }
                now = (now + 1) % A;
            }

            for (int i = 0; i < n+1; i++) {
                degiCnt++;
                if (target == 1 && degiCnt == T) {
                    System.out.println(now);
                    return;
                }
                now = (now + 1) % A;
            }

            n++;
        }
    }
}