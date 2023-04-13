import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input;
        StringBuilder formula = new StringBuilder();
        int sum = 0;
        while((input = sc.nextInt()) != -1) {
            for (int i = 1; i < input; i++) {
                if (input % i == 0) {
                    formula.append(i).append(" + ");
                    sum += i;
                }
            }


            if (sum == input) {
                System.out.println(input + " = " + formula.substring(0, formula.length()-3));
            } else {
                System.out.println(input + " is NOT perfect.");
            }
            formula.setLength(0);
            sum = 0;
        };
    }
}