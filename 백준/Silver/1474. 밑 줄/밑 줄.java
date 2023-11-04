import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 단어의 개수
        int M = Integer.parseInt(st.nextToken()); // 만들 단어의 길이

        String[] words = new String[N];
        int sumOfWords = 0;
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
            sumOfWords += words[i].length();
        }

        int underBarBetweenWords = (M - sumOfWords) / (N - 1);
        int remain = (M - sumOfWords) % (N - 1); // 남는 건 소문자 단어 앞에 먼저 붙이고, 그래도 남으면 대문자 단어 앞에

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            result.append(words[i]);

            if (i != N - 1) {
                for (int j = 0; j < underBarBetweenWords; j++) {
                    result.append("_");
                }

                if ('a' <= words[i + 1].charAt(0) && words[i + 1].charAt(0) <= 'z') { // 대문자일 경우
                    if (remain > 0) {
                        result.append("_");
                        remain--;
                    }
                } else if (N - 1 - i <= remain){ // 대문자일 경우
                    result.append("_");
                    remain--;
                }
            }
        }

        System.out.println(result);
    }
}