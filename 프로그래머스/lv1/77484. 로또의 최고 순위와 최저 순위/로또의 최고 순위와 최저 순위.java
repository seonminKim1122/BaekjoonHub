class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0, 0};
        boolean[] lotto;
        lotto = new boolean[47];

        // 맞춘 개수 + 0의 갯수 => 최대 등수
        // 맞춘 개수 => 최소 등수

        int correct = 0;
        int cntZero = 0;
        for(int myNum : win_nums) {
            lotto[myNum] = true;
        }

        for(int myNum : lottos) {
            if (myNum == 0) {
                cntZero++;
                continue;
            }
            if(lotto[myNum]){
                correct++;
            }
        }
        answer[0] = (correct+cntZero) >= 1 ? 7 - (correct+cntZero) : 6;
        answer[1] = (correct) >= 1 ? 7 - (correct) : 6;


        return answer;
    }
}