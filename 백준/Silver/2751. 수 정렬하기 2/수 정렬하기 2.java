import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        int[] answer = mergeSort(numbers);
        for(int num : answer) {
            sb.append(num + "\n");
        }
        System.out.println(sb);
    }

    public static int[] mergeSort(int[] numbers) {
        if (numbers.length == 1) {
            return numbers;
        }

        int mid = (numbers.length % 2 == 0) ? numbers.length/2 - 1 : numbers.length/2;
        int[] left = new int[mid+1];
        int[] right = new int[numbers.length-(mid+1)];

        for (int i = 0; i <= mid; i++) {
            left[i] = numbers[i];
        }

        for (int i = 0; i <= numbers.length-(mid+1)-1; i++) {
            right[i] = numbers[mid+1+i];
        }

        return merge(mergeSort(left), mergeSort(right));
    }

    public static int[] merge(int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] answer = new int[left.length+right.length];

        // left, right이 정렬됐다고 가정하고 값 비교하면 작은 순으로 answer 에 추가
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                answer[k++] = left[i++];
            } else {
                answer[k++] = right[j++];
            }
        }

        // left 배열에 남은 숫자 있으면 answer 에 순서대로 추가
        while (i < left.length) {
            answer[k++] = left[i++];
        }

        // right 배열에 남은 숫자 있으면 answer 에 순서대로 추가
        while (j < right.length) {
            answer[k++] = right[j++];
        }

        return answer;
    }
}