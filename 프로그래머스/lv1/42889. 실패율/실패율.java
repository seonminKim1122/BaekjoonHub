class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        // 스테이지 n 도달한 플레이어 수 : n 이상인 값의 갯수
        // 스테이지 n 도달했으나 아직 클리어 못한 플레이어 수 : n 의 갯수
        int notClear;
        int stageArrival;
        double[] failRates = new double[N];

        for (int i = 1; i <= N; i++) {
            notClear = 0;
            stageArrival = 0;
            for(int stage : stages) {
                if (stage > i) {
                    stageArrival++;
                } else if (stage == i) {
                    notClear++;
                }
            }
            stageArrival += notClear;
            
            if (stageArrival == 0) {
                failRates[i-1] = 0;
            } else {
                failRates[i-1] = (double)notClear/stageArrival;
            }
        }

        double[] sortedFailRates = failRates.clone();
        int len = sortedFailRates.length;
        double temp = -1;
        for (int i = 0; i < len-1; i++) {
            for (int j = 0; j < len-1; j++) {
                temp = sortedFailRates[j];
                if (Double.compare(temp, sortedFailRates[j+1]) < 0) {
                    sortedFailRates[j] = sortedFailRates[j+1];
                    sortedFailRates[j+1] = temp;
                }
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if(Double.compare(sortedFailRates[i], failRates[j])==0) {
                    answer[i] = (j+1);
                    failRates[j] = -1;
                    break;
                }
            }
        }

        return answer;
    }
}