import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] greenOnions = new int[S];
        long greenOnionForRamen = 0;
        for (int i = 0; i < S; i++) {
            greenOnions[i] = Integer.parseInt(br.readLine());
            greenOnionForRamen += greenOnions[i];
        }

        int start = 1;
        int end = 1_000_000_000;

        while (start <= end) {
            int greenOnion = (start + end) / 2;

            int cnt = 0;
            for (int i = 0; i < S; i++) {
                cnt += (greenOnions[i] / greenOnion);
            }

            if (cnt >= C) {
                start = greenOnion + 1;
            } else {
                end = greenOnion - 1;
            }
        }

        greenOnionForRamen -= ((long) end * C);
        System.out.println(greenOnionForRamen);
    }
}