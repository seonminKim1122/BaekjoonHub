import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> divs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int x = Integer.parseInt(br.readLine());
            int div = x % 42;

            if (!divs.contains(div)) {
                divs.add(div);
            }
        }
        System.out.println(divs.size());
    }
}