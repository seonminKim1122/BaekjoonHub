import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 가로수 간격들의 최대공약수 => 균등하게 심을 수 있는 거리 중 최대치
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] trees = new int[N];
        int[] diffs = new int[N-1];
        for (int i = 0; i < N; i++) {
            trees[i] = sc.nextInt();
            if (i < 1) {
                continue;
            }
            diffs[i-1] = trees[i]-trees[i-1];
        }

        int gcd = diffs[N-2];
        for (int i = N-3; i >= 0; i--) {
            gcd = gcd(gcd, diffs[i]);
        }

        int i = 0;
        int j = 1;
        int answer = 0;

        while(i < N-1) {
            if (trees[i] + (gcd * j) != trees[i+1]) {
                answer++;
                j++;
                continue;
            }
            j=1;
            i++;
        }
        System.out.println(answer);

    }

    public static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}