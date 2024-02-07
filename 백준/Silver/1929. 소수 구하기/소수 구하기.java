import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        boolean[] isNotPrime = new boolean[end + 1];
        isNotPrime[1] = true;
        for (int i = 2; i <= end; i++) {
            for (int j = i * 2; j <= end; j += i) {
                isNotPrime[j] = true;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (!isNotPrime[i]) {
                answer.append(i).append('\n');
            }
        }

        System.out.println(answer);
    }
}