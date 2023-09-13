import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static String formula;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        formula = br.readLine();

        dfs(2, formula.charAt(0) - '0');

        System.out.println(result);
    }

    public static void dfs(int idx, int temp) {
        if (idx >= N) {
            result = Math.max(result, temp);
            return;
        }

        // 괄호 X
        dfs(idx + 2, calculator(temp, formula.charAt(idx) - '0', formula.charAt(idx - 1)));

        // 괄호 O
        if (idx + 2 < N) {
            dfs(idx + 4, calculator(temp, calculator(formula.charAt(idx) - '0', formula.charAt(idx + 2) - '0', formula.charAt(idx + 1)), formula.charAt(idx - 1)));
        }
    }

    public static int calculator(int num1, int num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            default:
                return num1 * num2;
        }
    }
}