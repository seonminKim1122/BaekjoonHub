class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0, 0};

        boolean[] winNumBoolean = new boolean[46];

        for(int win_num : win_nums) {
            winNumBoolean[win_num] = true;
        }

        int correct = 0;
        int zeros = 0;
        for (int num : lottos) {
            if (num == 0) {
                zeros++;
                continue;
            }

            if (winNumBoolean[num]) {
                correct++;
            }
        }

        answer[0] = (correct + zeros) >= 1 ? 7 - (correct + zeros) : 6;
        answer[1] = correct >= 1 ? 7 - correct : 6;

        return answer;
    }
}