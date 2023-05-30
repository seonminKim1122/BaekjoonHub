import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int COUNT = 0;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        String[] numbers = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(numbers[i]);
        }

        merge_sort(arr, 0, N-1, K);

        if (COUNT < K) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    public static void merge_sort(int[] arr, int p, int r, int K) {
        if (p < r) { // 더 쪼갤 수 있는 경우
            int q = (p + r) / 2;
            merge_sort(arr, p, q, K);
            merge_sort(arr, q+1, r, K);
            merge(arr, p, q, r, K);
        }
    }

    public static void merge(int[] arr, int p, int q, int r, int K) { // arr 은 heap memory 에 저장되는 객체이므로 따로 함수 실행 후 arr 을 출력하면 정렬된 arr 이 나옴
        /*
        arr : 배열
        p ~ q : 전반부 배열(정렬됌)
        q+1 ~ r : 후반부 배열(정렬됌)
         */

        int i = p;
        int j = q+1;
        int t = 0;

        int[] temp = new int[r-p+1]; // 전반부 배열과 후반부 배열을 병합해서 정렬된 배열

        while (i <= q && j <= r) {
            if (arr[i] < arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }

        while (i <= q) {
            temp[t++] = arr[i++];
        }

        while (j <= r) {
            temp[t++] = arr[j++];
        }

        // 전반부 배열과 후반부 배열의 병합 정렬 결과를 원본 배열 arr 에 반영하기
        i = p;
        t = 0;
        while (i <= r) {
            arr[i++] = temp[t++];
            COUNT++;
            if (COUNT == K) { // 재귀함수의 호출을 중단해야 함..
                result = arr[i-1];
            }
        }
    }
}