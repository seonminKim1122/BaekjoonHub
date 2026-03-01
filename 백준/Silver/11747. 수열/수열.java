import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder input = new StringBuilder();
        int read = 0;

        StringTokenizer st;
        while (read < N) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                input.append(st.nextToken());
                read++;
            }
        }
        String D = input.toString();

        int target = 0;
        while (true) {
            if (D.contains(String.valueOf(target))) {
                target++;
            } else {
                break;
            }
        }

        System.out.println(target);
    }
}