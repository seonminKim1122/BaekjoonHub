import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static List<int[]> houses;
    static List<int[]> chickenRestaurants;
    static boolean[] isOpen;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        houses = new ArrayList<>();
        chickenRestaurants = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 1) {
                    houses.add(new int[]{i, j});
                } else if (input == 2) {
                    chickenRestaurants.add(new int[]{i, j});
                }
            }
        }

        isOpen = new boolean[chickenRestaurants.size()];
        dfs(0, 0);

        System.out.println(result);
    }

    public static void dfs(int start, int cnt) {
        if (cnt == M) {
            int temp = 0;
            for (int[] house : houses) {
                int min = 2 * N;
                for (int i = 0; i < chickenRestaurants.size(); i++) {
                    if (!isOpen[i]) continue;

                    int[] chickenRestaurant = chickenRestaurants.get(i);
                    int distance = Math.abs(house[0] - chickenRestaurant[0]) + Math.abs(house[1] - chickenRestaurant[1]);

                    if (distance < min) {
                        min = distance;
                    }
                }
                temp += min;
            }

            result = Math.min(result, temp);
            return;
        }

        for (int i = start; i < chickenRestaurants.size(); i++) {
            isOpen[i] = true;
            dfs(i + 1, cnt + 1);
            isOpen[i] = false;
        }
    }
}