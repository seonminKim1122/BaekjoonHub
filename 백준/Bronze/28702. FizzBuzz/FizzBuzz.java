import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input1 = br.readLine();
        String input2 = br.readLine();
        String input3 = br.readLine();

        int num1 = fizzbuzzToInt(input1);
        int num2 = fizzbuzzToInt(input2);
        int num3 = fizzbuzzToInt(input3);
        int max = Math.max(Math.max(num1, num2), num3);

        int target = 0;
        if (max == num1) {
            target = num1 + 3;
        } else if (max == num2) {
            target = num2 + 2;
        } else {
            target = num3 + 1;
        }

        System.out.println(intToFizzBuzz(target));
    }

    private static String intToFizzBuzz(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "FizzBuzz";
        } else if (number % 3 == 0) {
            return "Fizz";
        } else if (number % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(number);
        }
    }

    private static int fizzbuzzToInt(String input) {
        switch (input) {
            case "FizzBuzz":
            case "Fizz":
            case "Buzz":
                return 0;
            default:
                return Integer.parseInt(input);
        }
    }


}