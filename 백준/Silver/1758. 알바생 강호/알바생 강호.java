import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Integer[] tips = new Integer[N];
        for (int i = 0; i < N; i++) {
            tips[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(tips, Collections.reverseOrder());

        long tip = 0;
        for (int i = 0; i < N; i++) {
            if (tips[i] - i <= 0) {
                break;
            }

            tip += (tips[i] - i);
        }

        System.out.println(tip);
    }
}