import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        // n : 전체 학생 수
        // lost : 체육복을 분실한 학생들
        // reserve : 체육복 여분이 있는 학생들

        int[] students = new int[n+2];
        // -1 인 애들은 체육복 빌려야 하는 애들, 0은 체육복 입은 애들, 1 여분 체육복 있는 애들
        // students[0] 은 제외
        for(int num : lost) {
            students[num]--;
        }

        for(int num : reserve) {
            students[num]++;
        }

        // 체육복 없는 애들은 빌리기 시도(실패하면 answer에서 빼주기)
        for (int i = 1; i < students.length; i++) {
            if (students[i] == -1) {
                if (students[i-1] == 1) {
                    students[i-1]--;
                    students[i]++;
                } else if (students[i+1] == 1) {
                    students[i+1]--;
                    students[i]++;
                } else {
                    answer--;
                }
            }
        }
        return answer;
    }
}