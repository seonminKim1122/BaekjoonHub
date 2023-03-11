import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int title = 666;
        int seriesNumber = 1;

        while(seriesNumber != N) {
            if (String.valueOf(++title).contains("666")) {
                seriesNumber++;
            }
        }
        System.out.println(title);
    }
}