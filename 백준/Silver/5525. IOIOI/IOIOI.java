import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < N; i++) {
            temp.append("IO");
        }
        temp.append("I");

        String Pn = temp.toString();

        int result = 0;
        for (int i = 0; i < M; i++) {
            if (S.charAt(i) == 'I' && i + 2 * N + 1 <= M) {
                String sub = S.substring(i, i + 2 * N + 1);
                if (sub.equals(Pn)) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}