import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // AAAA, BB
        String result = br.readLine().replaceAll("XXXX", "AAAA").replaceAll("XX", "BB");
        if (result.contains("X")) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}