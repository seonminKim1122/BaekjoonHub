import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            answer.append('#').append(t).append(' ');

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] board = new int[K + N + K][K + M + K];
            Queue<Cell> cells = new LinkedList<>();
            for (int i = K; i < N + K; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = K; j < M + K; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    if (board[i][j] != 0) {
                        cells.add(new Cell(i, j, board[i][j]));
                    }
                }
            }

            int totalCells = cells.size();
            int deadCells = 0;
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            PriorityQueue<Cell> activatedCells = new PriorityQueue<>();
            for (int i = 0; i < K; i++) {
                // activatedCells 번식!
                while (!activatedCells.isEmpty()) {
                    Cell cell = activatedCells.poll();

                    for (int k = 0; k < 4; k++) {
                        int nx = cell.x + dx[k];
                        int ny = cell.y + dy[k];

                        if (nx < 0 || ny < 0 || nx >= 2*K+N || ny >= 2*K+M) continue;
                        if (board[nx][ny] != 0) continue;

                        Cell newCell = new Cell(nx, ny, cell.life);
                        newCell.isNew = true;
                        cells.add(newCell);
                        board[nx][ny] = newCell.life;
                        totalCells++;
                    }
                }

                // cells 중에서 activate 될 애들 확인하기
                int size = cells.size();
                for (int j = 0; j < size; j++) {
                    Cell cell = cells.poll();
                    if (cell.isNew) {
                        cell.isNew = false;
                        cells.add(cell);
                        continue;
                    }

                    cell.life--;

                    if (cell.life == 0) {
                        if (cell.isActivated) {
                            // dead
                            deadCells++;
                        } else {
                            // activate
                            cell.isActivated = true;
                            cell.life = board[cell.x][cell.y];
                            activatedCells.add(new Cell(cell.x, cell.y, board[cell.x][cell.y]));
                            cells.add(cell);
                        }
                    } else {
                        cells.add(cell);
                    }
                }
            }

            answer.append(totalCells - deadCells).append('\n');
        }

        System.out.println(answer);
    }

    static class Cell implements Comparable<Cell> {
        int x;
        int y;
        int life;
        boolean isActivated = false;
        boolean isNew = false;

        Cell(int x, int y, int life) {
            this.x = x;
            this.y = y;
            this.life = life;
        }

        @Override
        public int compareTo(Cell other) {
            return other.life - this.life;
        }
    }
}