import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] coordinates = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            coordinates[i][0] = Integer.parseInt(st.nextToken());
            coordinates[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(coordinates, (coordinate1, coordinate2) -> coordinate1[1] == coordinate2[1] ? coordinate1[0] - coordinate2[0] : coordinate1[1] - coordinate2[1]);


        for (int i = 0; i < N; i++) {
            System.out.println(coordinates[i][0] + " " + coordinates[i][1]);
        }
    }
}