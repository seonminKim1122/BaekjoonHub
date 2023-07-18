import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        char before = '(';
        int cutByLazer = 0;
        int result = 0;
        for(char parenthesis : input.toCharArray()) {
            if (parenthesis == '(') {
                cutByLazer++;
                before = '(';
            } else {
                cutByLazer--;
                if (before == '(') {
                    result += cutByLazer;
                } else {
                    result += 1;
                }
                before = ')';
            }
        }

        System.out.println(result);
    }
}