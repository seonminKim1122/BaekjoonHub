import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();

        sc.nextLine();

        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = sc.nextInt();
        }

        // 삽입 정렬(내림차순)
        for (int i = 1; i < N; i++) {
            int temp = scores[i];
            for (int j = i; j > 0; j--) {
                if (scores[j-1] < scores[j]) {
                    scores[j] = scores[j-1];
                    scores[j-1] = temp;
                } else {
                    break;
                }
            }
        }
        
        System.out.println(scores[k-1]);
    }
}