import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        // lost : 체육복을 잃어버린 학생
        // reserve : 여분 체육복이 있는 학생
        // lost && reserve : 여분을 분실해서 자기가 입을 것밖에 없는 학생

        // 1. lost && reserve 처리(-1)
        int reserveLength = reserve.length;
        int lostLength = lost.length;
        for (int i = 0; i < reserveLength; i++) {
            for (int j = 0; j < lostLength; j++) {
                if (reserve[i] == lost[j]) {
                    reserve[i] = -1;
                    lost[j] = -1;
                    break;
                }
            }
        }

        // 2. reserve에서 lost에 옷 빌려주기(reserve는 바로 앞 또는 바로 뒷 번호한테만 빌려줄 수 있음)
        Arrays.sort(reserve);
        Arrays.sort(lost);
        int cnt = 0;
        for (int i = 0; i < lostLength; i++) {
            for (int j = 0; j < reserveLength; j++) {
                if(lost[i] == reserve[j]-1 || lost[i] == reserve[j]+1) {
                    cnt++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        // 3. 정답 도출(lost 에서 -1인 애들은 제외)
        int lostAndReserveCnt = 0;
        for (int num : lost) {
            if (num == -1) {
                lostAndReserveCnt++;
            }
        }
        answer = n - (lost.length - lostAndReserveCnt) + cnt;
        return answer;
    }
}