import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        
        // 풀이
        int[] SA = new int[n]; // SA[i]: 0 ~ i 까지의 합
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                SA[i] = A[i];
            } else {
                SA[i] = SA[i - 1] + A[i];
            }
        }

        int[] SB = new int[m];  // SB[i]: 0 ~ i 까지의 합
        for (int i = 0; i < m; i++) {
            if (i == 0) {
                SB[i] = B[i];
            } else {
                SB[i] = SB[i - 1] + B[i];
            }
        }

        Map<Integer, Integer> sumA = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // A배열 i ~ j 까지의 합
                int v = SA[j] - SA[i] + A[i];
                sumA.put(v, sumA.getOrDefault(v, 0) + 1);
            }
        }

        Map<Integer, Integer> sumB = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                // B배열 i ~ j 까지의 합
                int v = SB[j] - SB[i] + B[i];
                sumB.put(v, sumB.getOrDefault(v, 0) + 1);
            }
        }

        long answer = 0;
        for (int a : sumA.keySet()) {
            int keyOfB = T - a;
            if (!sumB.containsKey(keyOfB)) continue;

            answer += ((long)sumA.get(a) * (long)sumB.get(keyOfB));
        }

        System.out.println(answer);
    }

}