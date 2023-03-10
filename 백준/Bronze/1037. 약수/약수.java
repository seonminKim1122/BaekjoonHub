import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int[] divisors = new int[size];

        for (int i = 0; i < size; i++) {
            divisors[i] = Integer.parseInt(tk.nextToken());
        }

        Arrays.sort(divisors);

        if (size % 2 == 0) {
            int lastIdx = divisors.length - 1;
            System.out.println(divisors[0] * divisors[lastIdx]);
        } else {
            int idx = size / 2;
            System.out.println((int) Math.pow(divisors[idx],2));
        }
    }
}