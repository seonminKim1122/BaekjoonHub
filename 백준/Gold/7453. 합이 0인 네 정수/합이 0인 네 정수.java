import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int[] AB = new int[n * n];
        int[] CD = new int[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                AB[n * i + j] = A[i] + B[j];
                CD[n * i + j] = C[i] + D[j];
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        long answer = 0;
        for (int i = 0; i < n * n; i++) {

            int lb = lowerBound(-AB[i], CD);
            int ub = upperBound(-AB[i], CD);

            answer += (ub - lb);
        }

        System.out.println(answer);
    }
    
    /*
    타겟이 나올 수 있는 최초 위치
    => 결과값 위치보다 더 작은 index 에는 target 보다 작은 값만 존재한다
     */
    static int lowerBound(int target, int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    /*
    타겟보다 큰 값이 나올 수 있는 최초 위치
    => 결과값 위치보다 더 작은 index 에는 target 보다 작거나 같은 값만 존재한다
     */
    static int upperBound(int target, int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }
}