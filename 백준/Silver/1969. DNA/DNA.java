import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        /*
        각 자리에서 많은 문자들을 취사선택하면 된다
        문자 종류 : A, T, G, C
        M : 8
          0 1 2 3 4 5 6 7
        A
        C
        G
        T
         */

        int[][] counts = new int[4][M];
        for (int i = 0; i < N; i++) {
            char[] dna = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                char nucleotide = dna[j];
                switch (nucleotide) {
                    case 'A':
                        counts[0][j]++;
                        break;
                    case 'C':
                        counts[1][j]++;
                        break;
                    case 'G':
                        counts[2][j]++;
                        break;
                    case 'T':
                        counts[3][j]++;
                        break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int distance = 0;
        for (int i = 0; i < M; i++) {
            int maxIdx = 0;
            for (int j = 1; j < 4; j++) {
                if (counts[j][i] > counts[maxIdx][i]) {
                    maxIdx = j;
                }
            }
            distance += (N - counts[maxIdx][i]);

            switch (maxIdx) {
                case 0:
                    sb.append('A');
                    break;
                case 1:
                    sb.append('C');
                    break;
                case 2:
                    sb.append('G');
                    break;
                case 3:
                    sb.append('T');
                    break;
            }
        }

        System.out.println(sb);
        System.out.println(distance);
    }
}