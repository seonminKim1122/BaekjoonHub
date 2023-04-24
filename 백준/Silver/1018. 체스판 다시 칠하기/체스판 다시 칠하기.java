import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            char[] charArray = line.toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                board[i][j] = charArray[j];
            }
        }

        int min = 64;

        for (int i = 0; i < N-7; i++) {
            for (int j = 0; j < M-7; j++) {
                char[][] chessBoard = chessBoard(board, i, j);
                int cnt = countChange(chessBoard);
                if (min > cnt) {
                    min = cnt;
                }
            }
        }

        System.out.println(min);
    }

    public static char[][] chessBoard(char[][] board, int i, int j) {
        char[][] miniBoard = new char[8][8];
        for (int row = i; row < i+8; row++) {
            for (int column = j; column < j+8; column++) {
                miniBoard[row-i][column-j] = board[row][column];
            }
        }
        return miniBoard;
    }

    public static int countChange(char[][] chessBoard) {
        int startWithWhite = 0;
        int startWithBlack = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        if (chessBoard[i][j] != 'W') {
                            startWithWhite++;
                        } else {
                            startWithBlack++;
                        }
                    } else {
                        if (chessBoard[i][j] != 'B') {
                            startWithWhite++;
                        } else {
                            startWithBlack++;
                        }
                    }
                } else {
                    if (j % 2 == 0) {
                        if (chessBoard[i][j] != 'B') {
                            startWithWhite++;
                        } else {
                            startWithBlack++;
                        }
                    } else {
                        if (chessBoard[i][j] != 'W') {
                            startWithWhite++;
                        } else {
                            startWithBlack++;
                        }
                    }
                }
            }
        }
        return Math.min(startWithBlack, startWithWhite);
    }
}