import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] colors = br.readLine().toCharArray();

        int blueCount = 0;
        int redCount = 0;
        for (int i = 0; i < N; i++) {
            if (colors[i] == 'B') { // BLUE
                if (i == 0 || colors[i-1] == 'R') {
                    blueCount++;
                }
            } else { // RED
                if (i == 0 || colors[i-1] == 'B') {
                    redCount++;
                }
            }
        }
        
        System.out.println(Math.min(blueCount, redCount) + 1);
    }
}