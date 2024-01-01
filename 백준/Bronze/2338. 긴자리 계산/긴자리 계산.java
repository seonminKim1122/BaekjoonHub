import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger A = new BigInteger(br.readLine());
        BigInteger B = new BigInteger(br.readLine());

        StringBuilder answer = new StringBuilder();
        answer.append(A.add(B)).append("\n");
        answer.append(A.subtract(B)).append("\n");
        answer.append(A.multiply(B)).append("\n");

        System.out.println(answer);
    }
}