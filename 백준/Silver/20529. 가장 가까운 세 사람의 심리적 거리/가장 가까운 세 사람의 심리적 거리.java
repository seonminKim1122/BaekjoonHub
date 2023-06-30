import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 시간 초과를 어떻게 줄일까? 브루트포스 방식 말고 다른 걸 써야 하나?
// 비둘기집 원리
// 3개의 비둘기알을 2개의 비둘기집에 넣으려면 최소한 하나에는 2개의 알이 들어간다
// MBTI의 종류는 총 16가지
// 모두 다른 MBTI를 입력한다고 해도 입력값이 32개를 초과하면 반드시 하나의 MBTI는 3개가 되고 d 는 0이 된다.

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] mbtis = br.readLine().split(" ");

            if (N > 32) {
                sb.append("0").append("\n");
                continue;
            }

            int min = 12;

            for (int i = 0; i < N-2; i++) {
                for (int j = i+1; j < N-1; j++) {
                    for (int k = j+1; k < N; k++) {
                        int d = calcDistance(mbtis[i], mbtis[j], mbtis[k]);
                        if (min > d) {
                            min = d;
                        }

                        if (min == 0) break;
                    }
                }
            }
            sb.append(min).append("\n");
        }

        System.out.println(sb);
    }

    public static int calcDistance(String A, String B, String C) {
        int d1 = 0;
        int d2 = 0;
        int d3 = 0;

        for (int i = 0; i < 4; i++) {
            if (A.charAt(i) != B.charAt(i)) {
                d1++;
            }

            if (B.charAt(i) != C.charAt(i)) {
                d2++;
            }

            if (C.charAt(i) != A.charAt(i)) {
                d3++;
            }
        }

        return d1 + d2 + d3;
    }
}