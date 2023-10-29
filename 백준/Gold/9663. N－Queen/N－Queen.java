import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N;
    static List<Integer> putRows = new ArrayList<>();
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        putQueen(0);
        System.out.println(result);
    }

    public static void putQueen(int col) {
        if (col == N) {
            result++;
            return;
        }

        for (int row = 0; row < N; row++) {
            if (isPossible(row, col)) {
                putRows.add(row);
                putQueen(col + 1);
                putRows.remove(putRows.size() - 1);
            }
        }
    }

    public static boolean isPossible(int row, int col) {
        int len = putRows.size();
        for (int i = 0; i < len; i++) {
            int putRow = putRows.get(i);
            if (putRow == row || putRow + (col - i) == row || putRow - (col - i) == row) return false;
        }

        return true;
    }
}