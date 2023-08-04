import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String formula = br.readLine();
        String[] temp =formula.split("-");

        int result = 0;
        for (int i = 0; i < temp.length; i++) {
            if (i == 0) {
                result += calculator(temp[i]);
            } else {
                result -= calculator(temp[i]);
            }
        }

        System.out.println(result);
    }

    public static int calculator(String input) {
        String[] numbers = input.split("\\+");
        int result = 0;
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }

        return result;
    }
}