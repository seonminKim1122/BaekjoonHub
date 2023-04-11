import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();

        for (int move : moves) {
            for (int[] line : board) {
                if(line[move-1] != 0) {
                    if(!basket.isEmpty() && basket.peek() == line[move-1]) {
                        answer += 2;
                        basket.pop();
                    } else {
                        basket.push(line[move-1]);
                    }
                    line[move-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}