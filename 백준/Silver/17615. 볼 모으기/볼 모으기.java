import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int cntOfRed1 = 0;
        int cntOfBlue1 = 0;

        int redBeforeLastBlue = 0;
        int blueBeforeLastRed = 0;

        int cntOfRed2 = 0;
        int cntOfBlue2 = 0;

        int redAfterFirstBlue = 0;
        int blueAfterFirstRed = 0;

        for (int i = 0; i < N; i++) {
            char ball = input.charAt(i);
            if (ball == 'R') {
                cntOfRed1++;
                blueBeforeLastRed = cntOfBlue1;
            } else {
                cntOfBlue1++;
                redBeforeLastBlue = cntOfRed1;
            }

            ball = input.charAt(N - 1 - i);
            if (ball == 'R') {
                cntOfRed2++;
                blueAfterFirstRed = cntOfBlue2;
            } else {
                cntOfBlue2++;
                redAfterFirstBlue = cntOfRed2;
            }
        }

        System.out.println(Math.min(Math.min(Math.min(redAfterFirstBlue, blueAfterFirstRed), redBeforeLastBlue), blueBeforeLastRed));
    }
}