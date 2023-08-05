import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();

        StringBuilder maximumSb = new StringBuilder();
        StringBuilder minimumSb = new StringBuilder();

        int mCount = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == 'M') {
                mCount++;
                if (i == input.length - 1) {
                    maximumSb.append(1);
                    minimumSb.append(1);
                    for (int j = 0; j < mCount - 1; j++) {
                        maximumSb.append(1);
                        minimumSb.append(0);
                    }
                }
            } else {
                if (mCount == 0) {
                    minimumSb.append(5);
                    maximumSb.append(5);
                    continue;
                }

                minimumSb.append(1);
                maximumSb.append(5);
                for (int j = 0; j < mCount-1; j++) {
                    minimumSb.append(0);
                    maximumSb.append(0);
                }
                minimumSb.append(5);
                maximumSb.append(0);

                mCount = 0;
            }
        }

        System.out.println(maximumSb);
        System.out.println(minimumSb);
    }
}