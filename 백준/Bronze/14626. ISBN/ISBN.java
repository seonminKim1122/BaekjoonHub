import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] isbn = br.readLine().toCharArray();

        int sum = 0;
        int targetIdx = -1;
        for (int i = 0; i < 12; i++) {
            if (isbn[i] == '*') {
                targetIdx = i;
                continue;
            }

            if (i % 2 == 0) {
                sum += isbn[i] - '0';
            } else {
                sum += (isbn[i] - '0') * 3;
            }
        }

        int temp = (10 - (sum % 10 + (isbn[12] - '0')) % 10) % 10;


        int answer = -1;
        int[] remain = {0, 7, 4, 1, 8, 5, 2, 9, 6, 3}; // remain[i] => x * 3 % 10 == i 가 되는 한 자리 수

        if (targetIdx % 2 == 0) {
            answer = temp;
        } else {
            answer = remain[temp];
        }

        System.out.println(answer);
    }

}