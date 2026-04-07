import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[] alphabets = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alphabets[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alphabets);

        char[] password = new char[L];
        solve(alphabets, 0, 0, L, password);

        System.out.println(answer);
    }

    public static void solve(char[] alphabets, int start, int depth, int L, char[] password) {
        if (depth == L) {
            // 최소 한 개의 모음과 최소 두 개의 자음인지 확인
            if (check(password)) {
                answer.append(String.valueOf(password)).append("\n");
            }
            return;
        }

        for (int i = start; i < alphabets.length; i++) {
            password[depth] = alphabets[i];
            solve(alphabets, i + 1, depth + 1, L, password);
            password[depth] = ' ';
        }
    }

    public static boolean check(char[] password) {
        int cnt = 0;
        for (char c : password) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                cnt++;
            }
        }

        return cnt >= 1 && (password.length - cnt) >= 2;
    }
}