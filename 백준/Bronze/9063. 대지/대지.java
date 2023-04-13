import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arrX = new int[N];
        int[] arrY = new int[N];
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            arrX[i] = x;
            arrY[i] = y;
        }

        int minX = arrX[0];
        int maxX = arrX[0];
        int minY = arrY[0];
        int maxY = arrY[0];

        for (int i = 1; i < N; i++) {
            if (arrX[i] < minX) {
                minX = arrX[i];
            }

            if (arrX[i] > maxX) {
                maxX = arrX[i];
            }

            if (arrY[i] < minY) {
                minY = arrY[i];
            }

            if (arrY[i] > maxY) {
                maxY = arrY[i];
            }
        }

        System.out.println((maxX - minX) * (maxY - minY));

    }
}