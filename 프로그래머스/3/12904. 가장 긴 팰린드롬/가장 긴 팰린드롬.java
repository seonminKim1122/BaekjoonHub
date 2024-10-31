class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        for (char c : s.toCharArray()) {
                sb.append(c).append('#');
        }

        String str = sb.toString();
        int N = str.length();

        char[] alpha = str.toCharArray();
        int[] P = new int[N]; // P[i] : i 를 중심으로 한 팰린드롬의 반지름

        int C = 0;
        int R = 0;
        int answer = 0;
        for (int i = 0; i < N; i++) {
            // 재활용 가능한 부분은 재활용
            if (i <= R) {
                P[i] = Math.min(P[2 * C - i], R - i);
            }
            
            // 재활용 한 부분 다음부터 팰린드롬 계산
            while (i - P[i] - 1 >= 0 && i + P[i] + 1 < N) {
                    if (alpha[i - P[i] - 1] != alpha[i + P[i] + 1]) break;
                    P[i]++;
            }

            if (i + P[i] > R) {
                    C = i;
                    R = i + P[i];
            }
            answer = Math.max(answer, P[i]);
        }

        return answer;
    }
}