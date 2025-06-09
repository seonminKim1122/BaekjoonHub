import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 과일의 갯수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] tanghuru = new int[N];
        for (int i = 0; i < N; i++) {
            tanghuru[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;

        int[] fruitCnt = new int[10];
        fruitCnt[tanghuru[0]]++;
        int fruitTypes = 1;
        int answer = 1;
        while (true) {

            if (fruitTypes <= 2) { // 과일 종류가 두 종류 이하
                answer = Math.max(answer, end - start + 1);
                end++;
                if (end == N) break;

                fruitCnt[tanghuru[end]]++;
                if (fruitCnt[tanghuru[end]] == 1) {
                    fruitTypes++;
                }

            } else { // 과일 종류가 두 종류 초과
                fruitCnt[tanghuru[start]]--;
                if (fruitCnt[tanghuru[start]] == 0) {
                    fruitTypes--;
                }
                start++;
            }
        }

        System.out.println(answer);
    }
}