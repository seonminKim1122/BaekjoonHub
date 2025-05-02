import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        // B: 총 감독관의 감시 가능 수, 부감독관의 감시 가능 수
        // 총 감독관의 반드시 1명씩 시험장에 배치되어야 함

        long result = 0;
        for (int i = 0; i < N; i++) {
            // 총 감독관 1명
            result += 1;

            // 나머지 인원에 대해 필요한 부감독관
            int remain = A[i] - B;
            if (remain <= 0) continue;

            result += (remain / C);
            if (remain % C != 0) result++;

        }

        System.out.println(result);
    }

}