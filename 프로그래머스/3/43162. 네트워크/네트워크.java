class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] connected = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (connected[i]) continue;
            connect(computers, i, connected, n);
            answer++;
        }
        
        return answer;
    }
    
    public void connect(int[][] computers, int computer, boolean[] connected, int n) {
        connected[computer] = true;
        
        for (int next = 0; next < n; next++) {
            if (next == computer || connected[next] || computers[computer][next] == 0) continue;
            connect(computers, next, connected, n);
        }
    }
}