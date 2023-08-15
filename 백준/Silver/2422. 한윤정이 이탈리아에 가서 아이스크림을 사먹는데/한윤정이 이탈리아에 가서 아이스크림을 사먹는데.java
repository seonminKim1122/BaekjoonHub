import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] combination = new int[N][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int iceCream1 = Integer.parseInt(st.nextToken());
            int iceCream2 = Integer.parseInt(st.nextToken());
            combination[iceCream1-1][iceCream2-1] = 1;
            combination[iceCream2-1][iceCream1-1] = 1;
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    if (combination[i][j] + combination[j][k] + combination[k][i] == 0) {
                       result++;
                    }
                }
            }
        }

        System.out.println(result);
    }
}