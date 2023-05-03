import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] coordinates = new int[N][2];
        for (int i = 0; i < N; i++) {
            coordinates[i][0] = sc.nextInt();
            coordinates[i][1] = sc.nextInt();
        }

        List<int[]> sortedCoordinates = Arrays.stream(coordinates).sorted(
                (o1, o2) -> o1[0]!=o2[0] ? o1[0]-o2[0] : o1[1]-o2[1]
        ).collect(Collectors.toList());

        sortedCoordinates.forEach(coordinate -> System.out.println(coordinate[0] + " " + coordinate[1]));
    }
}