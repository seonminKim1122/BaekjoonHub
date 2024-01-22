import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int[][] board = new int[9][9];
    static boolean isCompleted = false;

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 9; i++) {
            String input = br.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }

        // 사전순으로 빠르게 되려면 가장 왼쪽위부터 채우고, 가장 작은 값으로 채워야 함
        List<int[]> zeros = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    zeros.add(new int[]{i, j});
                }
            }
        }

        sudoku(0, zeros);
    }

    public static void sudoku(int depth, List<int[]> zeros) {
        if (depth == zeros.size()) {
            isCompleted = true;
            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    answer.append(board[i][j]);
                }
                answer.append("\n");
            }
            System.out.println(answer);
            return;
        }

        int[] now = zeros.get(depth);
        boolean[] isVisited = visited(now[0], now[1]);

        for (int i = 1; i < 10; i++) {
            if (!isVisited[i] && !isCompleted) { // 답이 여러 개일 수 있으니 한 번 찾으면 더 이상 재귀 안 돌게 해야함
                board[now[0]][now[1]] = i;
                sudoku(depth + 1, zeros);
            }
        }
        
        board[now[0]][now[1]] = 0; // 백트래킹으로 돌아올 때 값을 채웠던 부분은 다시 빈칸으로 바꿔야 함
    }

    public static boolean[] visited(int i, int j) {
        boolean[] result = new boolean[10];

        for (int k = 0; k < 9; k++) {
            result[board[i][k]] = true;
            result[board[k][j]] = true;
        }

        int r = 3 * (i / 3);
        int c = 3 * (j / 3);

        for (int x = r; x < r + 3; x++) {
            for (int y = c; y < c + 3; y++) {
                result[board[x][y]] = true;
            }
        }

        return result;
    }
}