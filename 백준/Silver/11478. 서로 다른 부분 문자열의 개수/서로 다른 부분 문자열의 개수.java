import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        int N = S.length();

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N+1; i++) {
            for (int j = i+1; j < N+1; j++) {
                set.add(S.substring(i, j));
            }
        }
        System.out.println(set.size());
    }
}