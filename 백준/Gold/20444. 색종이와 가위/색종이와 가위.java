import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        // 가로로 자르는 횟수 자체를 조건으로 삼으면 while 문 탈출 불가능

        long start = 0;
        long end = n / 2; // n이 아니라 n / 2 인 이유는 어차피 가로 세로 뒤바껴도 똑같으니까
        while (start <= end) {
            long horizontal = (start + end) / 2;
            long vertical = n - horizontal;

            long cnt = (horizontal + 1) * (vertical + 1);

            if (cnt == k) {
                System.out.println("YES");
                return;
            } else if (cnt > k) {
                end = horizontal - 1;
            } else {
                start = horizontal + 1;
            }
        }

        System.out.println("NO");
    }
}