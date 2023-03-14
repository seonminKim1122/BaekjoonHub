import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int dNum = 0;
            int nDNum = 0;
            if (M-N > N) {
                dNum = N;
                nDNum = M-N;
            } else {
                dNum = M-N;
                nDNum = N;
            }

            long result = 1L;

            for (int j = M; j > nDNum; j--) {
                result *= j;
            }
            for (int j = 1; j <= dNum ; j++) {
                result /= j;
            }
            bw.write(result +"\n");

        }

        bw.flush();
        bw.close();
        br.close();
    }
}