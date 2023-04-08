class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        // 그리디 문제
        // 가장 적은 금액을 요청한 부서부터 예산 주면 최대한 많은 부서 가능
        int len = d.length;
        // 버블 정렬 사용
        int temp = 0;
        for (int i = 0; i < len-1; i++) {
            for (int j = 0; j < len-1; j++) {
                temp = d[j];
                if (temp > d[j+1]) {
                    d[j] = d[j+1];
                    d[j+1] = temp;
                }
            }
        }

        for (int n : d) {
            budget -= n;
            if (budget < 0) break;
            answer++;
        }
        return answer;
    }
}