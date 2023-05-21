import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] oxs = br.readLine().split("");
            int score = 1;
            int result = 0;
            for (String ox : oxs) {
                if (ox.equals("O")) {
                    result += score;
                    score++;
                } else {
                    score = 1;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}