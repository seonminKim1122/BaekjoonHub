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


        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] modularS = new int[N];
        long[] count = new long[M];
        modularS[0] = numbers[0] % M;
        count[modularS[0]]++;
        for (int i = 1; i < N; i++) {
            modularS[i] = (modularS[i - 1] + numbers[i] % M) % M;
            count[modularS[i]]++;
        }

        long result = count[0];
        for (int i = 0; i < M; i++) {
            if (count[i] > 1) result += (count[i] * (count[i] - 1)) / 2;
        }

        System.out.println(result);
    }
}
/*
나머지 합 배열
S 를 구하고
0인 케이스를 제외하고는
1 -> N1
2 -> N2
...
M - 1-> N(M-1)
일 때
N1 C 2 + N2 C 2 + N3 C 2 + ... + N(M-1) C 2 를 구하면된다!
 */