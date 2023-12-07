import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sequence = br.readLine();

        int origin = sequence.length();
        int idx = 0;
        while (!isPalindrome(sequence)) {
            sequence = sequence.substring(0, origin) + sequence.charAt(idx++) + sequence.substring(origin);
        }

        System.out.println(sequence.length());
    }

    public static boolean isPalindrome(String sequence) {
        int start = 0;
        int end = sequence.length() - 1;

        while (start <= end) {
            if (sequence.charAt(start) == sequence.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }

        return true;
    }
}