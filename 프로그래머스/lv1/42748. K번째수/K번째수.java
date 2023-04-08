class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int len = commands.length;
        int[] answer = new int[len];

        int i;
        int j;
        int k;
        int idx = 0;

        for(int[] command : commands) {
            i = command[0]-1;
            j = command[1]-1;
            k = command[2]-1;
            int[] temp = new int[j-i+1];

            for (int l = i; l <= j; l++) {
                temp[l-i] = array[l];
            }

            int tempNum = 0;
            for (int l = 0; l < j-i; l++) {
                for (int m = 0; m < j-i; m++) {
                    tempNum = temp[m];
                    if (tempNum > temp[m+1]) {
                        temp[m] = temp[m+1];
                        temp[m+1] = tempNum;
                    }
                }
            }
            answer[idx++] = temp[k];
        }

        return answer;
    }
}