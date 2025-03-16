import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int numOftwo = 0;
        int numOfFive = 0;
        while (N >= 0) {
            numOftwo += calc(N, 2);
            numOfFive += calc(N, 5);
            N--;
        }

        System.out.println(Math.min(numOftwo, numOfFive));
    }

    public static int calc(int N, int target) {
        if (N == 0) return 0;

        int result = 0;
        while (N % target == 0) {
            result++;
            N /= target;
        }
        return result;
    }
}
/*
0의 개수 -> 소인수분해 했을 때 2^x * 5^y * ...?
min(x, y) 가 0의 개수

 */
