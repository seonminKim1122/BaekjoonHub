import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int cnt = 1;
        while (A != B) {
            if (A > B || (B % 10 != 1 && B % 2 != 0)) {
                cnt = -1;
                break;
            }

            if (B % 10 == 1) {
                B = (B-1) / 10;
            } else {
                B /= 2;
            }

            cnt++;
        }

        System.out.println(cnt);
    }
}