import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        /*
        for [][0] 몸무게
            [][1] 키
for문안에 포문으로
        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] people = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            people[i][0] = weight;
            people[i][1] = height;
        }

        for (int i = 0; i < N; i++) {
            int rank = 1;
            for (int j = 0; j < N; j++) {
                if (people[i][1] < people[j][1] && people[i][0] < people[j][0]) {
                    rank++;
                }
            }
            bw.write(rank + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}