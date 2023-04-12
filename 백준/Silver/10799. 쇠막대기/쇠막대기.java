import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expr = sc.nextLine();
        
        int answer = 0;
        int cutByLazer = 0;
        boolean isLazer = false;
        
        for (char c : expr.toCharArray()) {
            if (c == '(') {
                cutByLazer++;
                isLazer = true;
            } else {
                cutByLazer--;
                if (isLazer) {
                    answer += cutByLazer;
                    isLazer = false;
                } else {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}