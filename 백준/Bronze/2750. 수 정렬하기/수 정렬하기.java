import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        int[] sortedNumbers = selectionSort(numbers);
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < N; i++) {
            answer.append(sortedNumbers[i]).append("\n");
        }

        System.out.println(answer);
    }

    public static int[] selectionSort(int[] numbers) {
        int N = numbers.length;
        for (int i = 0; i < N - 1; i++) {
            int min = numbers[i];
            for (int j = i + 1; j < N; j++) {
                if (numbers[j] < min) {
                    min = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = min;
                }
            }
        }

        return numbers;
    }
}
/*
우선순위큐를 사용하면 삽입할 때 O(logN)이므로 N개의 자료를 삽입하면서
O(NlogN), 출력할 때도 O(logN)이니 N 개의 자료를 출력하면서 O(NlogN)

선택정렬은 O(N^2)
 */