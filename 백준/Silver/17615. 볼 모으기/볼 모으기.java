import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        char[] balls = new char[N];

        int cntOfRed = 0;
        int cntOfBlue = 0;

        int redBeforeLastBlue = 0;
        int blueBeforeLastRed = 0;

        for (int i = 0; i < N; i++) {
            balls[i] = input.charAt(i);
            if (balls[i] == 'R') {
                cntOfRed++;
                blueBeforeLastRed = cntOfBlue;
            } else {
                cntOfBlue++;
                redBeforeLastBlue = cntOfRed;
            }
        }

        System.out.println(Math.min(redBeforeLastBlue, blueBeforeLastRed));
    }
}