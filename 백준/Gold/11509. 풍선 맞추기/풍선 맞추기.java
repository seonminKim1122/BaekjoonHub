import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] ballons = new int[N];
        int size = 0;
        for (int i = 0; i < N; i++) {
            int ballon = Integer.parseInt(st.nextToken());
            size = Math.max(size, ballon);
            ballons[i] = ballon;
        }
        
        int[] arrows = new int[size + 1];
        int result = 0;
        for (int i = 0; i < N; i++) {
            int h = ballons[i];
            if (arrows[h] > 0) {
                arrows[h]--;
            } else {
                result++;
            }
            arrows[h - 1]++;
        }

        System.out.println(result);
    }
}