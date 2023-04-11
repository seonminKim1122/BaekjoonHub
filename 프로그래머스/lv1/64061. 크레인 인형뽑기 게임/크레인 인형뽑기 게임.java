import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> result = new Stack<>();

        for(int move : moves) {
            for(int[] i : board) {
                if(i[move-1] != 0) {
                    if(!result.isEmpty() && result.peek() == i[move-1]) {
                        answer += 2;
                        result.pop();
                    } else {
                        result.push(i[move-1]);
                    }
                    i[move-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}