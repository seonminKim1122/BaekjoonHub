class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        boolean[] isNotPainted = new boolean[n + 1];
        for (int sec : section) {
            isNotPainted[sec] = true;
        }
        
        for (int sec : section) {
            if (isNotPainted[sec]) {
                for (int i = 0; i < m; i++) {
                    if (sec + i > n) break;
                    isNotPainted[sec + i] = false;
                }
                answer++;
            }
        }
        
        return answer;
    }
}