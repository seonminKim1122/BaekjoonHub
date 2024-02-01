import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int[][] dices;
    static int result = 0;
    static int N;

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dices = new int[N][6];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                dices[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int j = 0; j < 6; j++) {
            int lower = dices[0][j];
            int upper = findCouple(0, j);

            solve(0, upper, findLargest(upper, lower));
        }

        System.out.println(result);
    }

    static void solve(int depth, int upper, int sum) {
        if (depth == N - 1) {
            result = Math.max(result, sum);
            return;
        }

        int idx = -1;
        for (int j = 0; j < 6; j++) {
            if (dices[depth + 1][j] == upper) {
                idx = j;
                break;
            }
        }

        int newUpper = findCouple(depth + 1, idx);
        solve(depth + 1, newUpper, sum + findLargest(newUpper, upper));
    }

    static int findCouple(int i, int j) {
        if (j == 0) {
            return dices[i][5];
        } else if (j == 1) {
            return dices[i][3];
        } else if (j == 2) {
            return dices[i][4];
        } else if (j == 3) {
            return dices[i][1];
        } else if (j == 4) {
            return dices[i][2];
        } else {
            return dices[i][0];
        }
    }

    static int findLargest(int upper, int lower) {
        for (int i = 6; i >= 1; i--) {
            if (i != upper && i != lower) return i;
        }
        return -1;
    }
}
/*
1번 주사위의 '위'를 결정하면 그 다음 주사위들은 순차적으로 결정이 된다.

1번 주사위의 각 면이 '위' 일 때 6가지 케이스에 대해서 나머지 주사위들이 옆면이 되지 못 하는 숫자를 결정
 */