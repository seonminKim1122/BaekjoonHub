import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numbers); // 듀얼 퀵 정렬

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < N; i++) {
            answer.append(numbers[i]).append("\n");
        }

        System.out.println(answer);
    }

//    public static void quickSort(int[] numbers, int left, int right) {
//        if (left >= right) return;
//
//        int low = left;
//        int high = right;
//
//        int pivot = numbers[low++];
//        while (low <= high) {
//            while (low < numbers.length && numbers[low] < pivot) {
//                low++;
//            }
//
//            while (high >= 0 && numbers[high] > pivot) {
//                high--;
//            }
//
//            if (low <= high) {
//                int temp = numbers[low];
//                numbers[low] = numbers[high];
//                numbers[high] = temp;
//            }
//        }
//
//        numbers[left] =  numbers[high];
//        numbers[high] = pivot;
//
//        quickSort(numbers, left, high - 1);
//        quickSort(numbers, high + 1, right);
//    }
}
/*
퀵 소트 알고리즘
- 최악의 경우 O(N^2)
- 이상적이면 O(NlogN)

Big-O 표기법은 최악의 상황을 가정하므로 현재 코드의 시간복잡도 = O(N^2)
-> 예제는 N 이 최대 1,000,000 이므로 2초의 제한 시간 내에 통과 못 할 수 있음
-> 실제로 시간초과 발생
 */