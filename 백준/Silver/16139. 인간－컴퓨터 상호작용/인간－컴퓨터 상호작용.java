import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] S = br.readLine().toCharArray();

        int[][] cumulateSum = new int[26][S.length + 1];
        for (int i = 1; i <= S.length; i++) {
            char alphabet = S[i - 1];
            for (int j = 0; j < 26; j++) {
                cumulateSum[j][i] = cumulateSum[j][i - 1];
            }
            cumulateSum[alphabet - 'a'][i] = cumulateSum[alphabet - 'a'][i - 1] + 1;
        }

        int Q = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int q = 0; q < Q; q++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char alpha = st.nextToken().charAt(0);
            int i = Integer.parseInt(st.nextToken()) + 1;
            int j = Integer.parseInt(st.nextToken()) + 1;

            int temp = cumulateSum[alpha - 'a'][j] - cumulateSum[alpha - 'a'][i - 1];
            answer.append(temp).append('\n');
        }

        System.out.println(answer);
    }
}