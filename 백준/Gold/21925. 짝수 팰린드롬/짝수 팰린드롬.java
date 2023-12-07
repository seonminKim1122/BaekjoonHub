import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> subSequence = new Stack<>();

        int cntOfSubSequence = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            subSequence.add(number);

            if (isPalindrome(subSequence)) {
                subSequence.clear();
                cntOfSubSequence++;
            }
        }

        System.out.println(subSequence.isEmpty() ? cntOfSubSequence : -1);
    }

    public static boolean isPalindrome(List<Integer> subSequence) {
        if (subSequence.size() % 2 != 0) return false;

        int startIdx = 0;
        int endIdx = subSequence.size() - 1;

        while (startIdx < endIdx) {
            if (subSequence.get(startIdx).equals(subSequence.get(endIdx))) {
                startIdx++;
                endIdx--;
            } else {
                return false;
            }
        }

        return true;
    }
}