import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            int x = Integer.parseInt(br.readLine());
            arr.add(x);
        }
        int max = Collections.max(arr);
        int idx = arr.indexOf(max);
        System.out.println(max);
        System.out.println(idx+1);
    }
}