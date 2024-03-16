import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nameOfVariable = br.readLine();
        
        boolean isJava = isJavaStyle(nameOfVariable);
        boolean is_c = is_c_style(nameOfVariable);

        StringBuilder answer = new StringBuilder();
        if (isJava) {
            // change to c style
            int N = nameOfVariable.length();
            for (int i = 0; i < N; i++) {
                char now = nameOfVariable.charAt(i);
                if (('A' <= now && now <= 'Z')) {
                    answer.append('_');
                    answer.append((char)(now + ('a' - 'A')));
                } else {
                    answer.append(now);
                }
            }
        } else if (is_c) {
            // change to java style
            int N = nameOfVariable.length();
            for (int i = 0; i < N; i++) {
                char now = nameOfVariable.charAt(i);
                char before = i >= 1 ? nameOfVariable.charAt(i - 1) : '\0';

                if (now == '_') continue;
                if (before == '_') {
                    answer.append((char)(now - ('a' - 'A')));
                } else {
                    answer.append(now);
                }
            }
        } else {
            answer.append("Error!");
        }

        System.out.println(answer);
    }

    static boolean isJavaStyle(String variableName) {
        // 소문자와 대문자로만 이루어져야 함
        char start = variableName.charAt(0);
        if (!('a' <= start && start <= 'z')) return false;

        int N = variableName.length();

        for (int i = 1; i < N; i++) {
            char temp = variableName.charAt(i);
            if (('a' <= temp && temp <= 'z') || ('A' <= temp && temp <= 'Z')) continue;
            return false;
        }

        return true;
    }

    static boolean is_c_style(String variableName) {
        // 소문자와 '_' 로만 이루어져야 함
        char start = variableName.charAt(0);
        if (!('a' <= start && start <= 'z')) return false;

        int N = variableName.length();
        if (variableName.charAt(N - 1) == '_') return false;

        for (int i = 1; i < N; i++) {
            char now = variableName.charAt(i);
            if ('a' <= now && now <= 'z') continue;
            if (now == '_'){
                char before = variableName.charAt(i - 1);
                if (before != '_') continue;
            }
            return false;
        }

        return true;
    }
}