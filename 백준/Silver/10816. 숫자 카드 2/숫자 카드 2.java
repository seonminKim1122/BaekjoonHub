import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            countMap.put(number, countMap.getOrDefault(number, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (i != 0) bw.write(" ");
            bw.write(String.valueOf(countMap.getOrDefault(number, 0)));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}