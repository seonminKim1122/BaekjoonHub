import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] values = new int[N];
        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(st.nextToken()); // 산성 1 ~ 10억, 알칼리 -1 ~ -10억
        }

        Arrays.sort(values);

        int start = 0;
        int end = N-1;
        int tempValue = values[start] + values[end];
        int[] result = new int[]{values[start], values[end]};

        while (start < end) {
            int mixedValue = values[start] + values[end];

            if (Math.abs(mixedValue) <= Math.abs(tempValue)) {
                tempValue = values[start] + values[end];
                result[0] = values[start];
                result[1] = values[end];
            }
            
            if (Math.abs(values[start+1] + values[end]) < Math.abs(values[start]+values[end-1])) {
                start++;
                continue;
            } else {
                end--;
            }

//            if (mixedValue > 0) {
//                end--;
//            } else {
//                start++;
//            }
        }

        System.out.println(result[0] + " " + result[1]);
    }
}