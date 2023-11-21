import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();

        int N = A.length();
        int[] cntOfAlphabet = new int[26];
        for (int i = 0; i < N; i++) {
            cntOfAlphabet[A.charAt(i) - 'A']++;
            cntOfAlphabet[B.charAt(i) - 'A']--;
        }

        if (!canChange(cntOfAlphabet)) {
            System.out.println(-1);
            return;
        }
        
        int idx = A.length() - 1;
        int targetIdx = B.length() - 1;

        int result = 0;
        while (idx >= 0) {
            if (B.charAt(targetIdx) != A.charAt(idx)) {
                result++;
            } else {
                targetIdx--;
            }
            idx--;
        }

        System.out.println(result);
    }

    public static boolean canChange(int[] cntOfAlphabet) {
        for (int i = 0; i < 26; i++) {
            if (cntOfAlphabet[i] != 0) return false;
        }
        return true;
    }
}