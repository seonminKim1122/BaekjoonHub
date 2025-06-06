import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] equations = input.split("-");
        int len = equations.length;

        int result = 0;
        for (String number : equations[0].split("\\+")) {
            result += Integer.parseInt(number);
        }

        for (int i = 1; i < len; i++) {
            String equation = equations[i];
            for (String number : equation.split("\\+")) {
                result -= Integer.parseInt(number);
            }
        }

        System.out.println(result);
    }


}