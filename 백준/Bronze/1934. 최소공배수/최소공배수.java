import java.io.*;
import java.util.*;
public class Main {
    public static int calculator(int A, int B) {
        if (A % B == 0) return B;
        return calculator(B, A%B);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int result = A * (B / calculator(A, B));
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}