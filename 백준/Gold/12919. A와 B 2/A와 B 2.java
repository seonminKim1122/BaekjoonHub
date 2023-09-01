import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        operate(S, T);

        System.out.println(result);

    }
    
    public static void operate(String S, String T) {
        if (S.length() == T.length()) {
            if (S.equals(T)) {
                result = 1;
            }
            return;
        }

        String next1 = T.substring(0, T.length() - 1);
        String next2 = new StringBuilder(T.substring(1)).reverse().toString();


        if (T.endsWith("A")) {
            operate(S, next1);
        }

        if (T.startsWith("B")) {
            operate(S, next2);
        }
    }
}