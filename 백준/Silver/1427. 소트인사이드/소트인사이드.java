import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String num = br.readLine();
        int[] numbers = new int[num.length()];
        int i = 0;
        for(String n : num.split("")) {
            numbers[i++] = Integer.parseInt(n);
        }

        int[] answer = mergeSort(numbers);
        for(int number : answer) {
            sb.append(number);
        }
        System.out.println(sb);
    }

    public static int[] mergeSort(int[] numbers) {
        if(numbers.length == 1) {
            return numbers;
        }

        int mid = (numbers.length % 2 == 0) ? numbers.length/2 - 1: numbers.length/2;
        int[] left = new int[mid+1];
        int[] right = new int[numbers.length - (mid+1)];

        for (int i = 0; i < mid+1; i++) {
            left[i] = numbers[i];
        }

        for (int i = 0; i < numbers.length-(mid+1); i++) {
            right[i] = numbers[i+mid+1];
        }

        return merge(mergeSort(left), mergeSort(right));
    }

    public static int[] merge(int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] answer = new int[left.length+right.length];

        while(i < left.length && j < right.length) {
            if (left[i] > right[j]) {
                answer[k++] = left[i++];
            } else {
                answer[k++] = right[j++];
            }
        }

        while(i < left.length) {
            answer[k++] = left[i++];
        }

        while(j < right.length) {
            answer[k++] = right[j++];
        }

        return answer;
    }
}