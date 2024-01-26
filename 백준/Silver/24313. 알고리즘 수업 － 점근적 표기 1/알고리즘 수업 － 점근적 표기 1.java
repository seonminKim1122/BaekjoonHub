import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int n0 = Integer.parseInt(st.nextToken());

            if (T + (N) * Math.abs(n0) <= Math.abs(c) * Math.abs(n0)) {
                if (N<=c) {
                    System.out.println(1);
                }
                else System.out.println(0);
            } else System.out.println(0);





    }
}
