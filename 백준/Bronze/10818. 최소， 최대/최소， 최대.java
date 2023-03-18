import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr.add(x);
        }
        int max = Collections.max(arr);
        int min = Collections.min(arr);

        System.out.println(min + " " + max);
    }
}