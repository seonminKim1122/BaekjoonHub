import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] sortedNumbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        sortedNumbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(numbers, 0, N - 1);
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < N; i++) {
            answer.append(numbers[i]).append("\n");
        }

        System.out.println(answer);
    }

    public static void mergeSort(int[] numbers, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;
        mergeSort(numbers, left, mid);
        mergeSort(numbers, mid + 1, right);
        merge(numbers, left, mid, right);
    }

    public static void merge(int[] numbers, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (numbers[i] < numbers[j]) {
                sortedNumbers[k++] = numbers[i++];
            } else {
                sortedNumbers[k++] = numbers[j++];
            }
        }

        for (int l = i; l <= mid; l++) {
            sortedNumbers[k++] = numbers[l];
        }

        for (int l = j; l <= right; l++) {
            sortedNumbers[k++] = numbers[l];
        }

        for (int l = left; l <= right; l++) {
            numbers[l] = sortedNumbers[l];
        }
    }
}