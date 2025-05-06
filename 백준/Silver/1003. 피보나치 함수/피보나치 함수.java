import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] cnt0 = new int[N + 1]; // cnt0[i]: fibo(i) 의 0 출력횟수
            int[] cnt1 = new int[N + 1]; // cnt1[i]: fibo(i) 의 1 출력횟수
            fibo0(N, cnt0);
            fibo1(N, cnt1);

            bw.write(cnt0[N] + " " + cnt1[N]);
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void fibo0(int N, int[] cnt0) {
        if (N == 1) return;
        if (N == 0) {
            cnt0[0]++;
            return;
        }

        if (cnt0[N - 1] == 0) {
            fibo0(N - 1, cnt0);
        }
        if (cnt0[N - 2] == 0) {
            fibo0(N - 2, cnt0);
        }

        cnt0[N] = cnt0[N - 1] + cnt0[N - 2];
    }

    private static void fibo1(int N, int[] cnt1) {
        if (N == 0) return;
        if (N == 1) {
            cnt1[1]++;
            return;
        }

        if (cnt1[N - 1] == 0) {
            fibo1(N - 1, cnt1);
        }
        if (cnt1[N - 2] == 0) {
            fibo1(N - 2, cnt1);
        }

        cnt1[N] = cnt1[N - 1] + cnt1[N - 2];
    }
}