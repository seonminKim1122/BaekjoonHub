import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        // 선택 정렬
        for (int i = 0; i < 4; i++) {
            int minIdx = i;
            for (int j = i+1; j < 5; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
            sum += temp;
        }
        sum+=arr[arr.length-1];
        System.out.println(sum / 5);
        if (arr.length % 2 == 0) {
            System.out.println((arr[arr.length/2] + arr[arr.length/2 + 1])/2);
        } else {
            System.out.println(arr[arr.length/2]);
        }
    }
}