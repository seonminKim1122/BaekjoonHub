import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] nums = new int[3];
            for (int i = 0; i < 3; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            if (nums[0] + nums[1] + nums[2] == 0) {
                break;
            }

            int max = Arrays.stream(nums).max().orElse(0);
            int sum = 0;

            for (int i = 0; i < 3; i++) {
                if (nums[i] != max) {
                    sum += (nums[i] * nums[i]);
                }
            }

            if (sum == (max * max)) {
                sb.append("right");
            } else {
                sb.append("wrong");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}