import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] city = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<House> houses = new ArrayList<>();
        List<ChickenStore> chickenStores = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (city[i][j] == 2) {
                    chickenStores.add(new ChickenStore(i, j));
                } else if (city[i][j] == 1) {
                    houses.add(new House(i, j));
                }
            }
        }

        int totalSize = chickenStores.size();
        solve(houses, chickenStores, 0, totalSize - M, totalSize, 0);
        System.out.println(answer);
    }

    static void solve(List<House> houses, List<ChickenStore> chickenStores, int depth, int target, int totalSize, int start) {
        if (calcChickenDistance(houses, chickenStores) > answer) {
            return;
        }

        if (depth == target) {
            answer = Math.min(answer, calcChickenDistance(houses, chickenStores));
            return;
        }


        for (int i = start; i < totalSize; i++) {
            ChickenStore chickenStore = chickenStores.get(i);
            if (chickenStore.isClose) continue;
            chickenStore.isClose = true;
            solve(houses, chickenStores, depth + 1, target, totalSize, i + 1);
            chickenStore.isClose = false;
        }

    }

    static int calcChickenDistance(List<House> houses, List<ChickenStore> chickenStores) {
        int result = 0;
        for (House house: houses) {
            int distance = Integer.MAX_VALUE;
            for (ChickenStore chickenStore: chickenStores) {
                if (chickenStore.isClose) continue;
                distance = Math.min(distance, Math.abs(house.y - chickenStore.y) + Math.abs(house.x - chickenStore.x));
            }
            result += distance;
        }
        return result;
    }

    static class House {
        int y;
        int x;

         House(int y, int x) {
             this.y = y;
             this.x = x;
         }
    }

    static class ChickenStore {
        int y;
        int x;
        boolean isClose;

        ChickenStore(int y, int x) {
            this.y = y;
            this.x = x;
            isClose = false;
        }
    }
}