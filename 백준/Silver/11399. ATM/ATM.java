import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        /*
        각 사람이 돈을 인출하는데 필요한 시간을 최소화 하려면
        걸리는 시간이 적은 사람부터 돈을 인출해야한다.
         */
        Arrays.sort(P);

        int answer = 0;
        int time = 0;
        for (int i = 0; i < N; i++) {
            time += P[i];
            answer += time;
        }

        System.out.println(answer);
    }

}