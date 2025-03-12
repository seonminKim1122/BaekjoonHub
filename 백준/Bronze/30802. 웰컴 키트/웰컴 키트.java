import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        int[] applicants = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            applicants[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        // 티셔츠: applicants[i] - 1 / T + 1
        long tShirts = 0;
        for (int i = 0; i < 6; i++) {
            tShirts += applicants[i] / T + (applicants[i] % T > 0 ? 1 : 0);
        }

        System.out.println(tShirts);
        // 펜: N / P 묶음, N % P 개 주문
        System.out.println(N / P + " " + N % P);
    }
}