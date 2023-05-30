import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    static int COUNT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            char[] s = br.readLine().toCharArray();
            sb.append(isPalindrome(s)).append(" ").append(COUNT).append("\n");
            COUNT = 0;
        }

        System.out.println(sb);
    }

    public static int isPalindrome(char[] s) {
        return recursion(s, 0, s.length-1);
    }

    public static int recursion(char[] s, int l, int r) {
        COUNT++;
        if (l >= r) {
            return 1;
        } else if (s[l] != s[r]) {
            return 0;
        } else {
            return recursion(s, l+1, r-1);
        }
    }
}