import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < testcase; tc++){
            String[] inputValue = br.readLine().split(" ");
            int H = Integer.parseInt(inputValue[0]);
            int W = Integer.parseInt(inputValue[1]);
            int N = Integer.parseInt(inputValue[2]);

            int result = 0;

            if (N % H != 0) {
                result = N % H * 100;
                result += N / H + 1;
            } else {
                result = H * 100;
                result += N / H;
            }


            System.out.println(result);
        }
    }
}