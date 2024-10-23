import java.util.*;

class Solution {
    
    static String[] answer;
    static boolean findAnswer = false;
    
    public String[] solution(String[][] tickets) {
        int N = tickets.length;
        answer = new String[N + 1];
        Arrays.sort(tickets, (t1, t2) -> t1[1].compareTo(t2[1]));
        solve(tickets, new boolean[N], new int[N], "ICN", 0, N);
        return answer;
    }

    public void solve(String[][] tickets, boolean[] used, int[] path,
                      String from, int depth, int N) {
        if (findAnswer) return;
        if (depth == N) {
            // 정답!
            for (int i = 0; i < N; i++) {
                String[] ticket = tickets[path[i]];
                answer[i] = ticket[0];
            }
            answer[N] = tickets[path[N - 1]][1];
            findAnswer = true;
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (used[i] || !tickets[i][0].equals(from)) continue;
            used[i] = true;
            path[depth] = i;
            solve(tickets, used, path, tickets[i][1], depth + 1, N);
            used[i] = false;
            path[depth] = -1;
        }
    }
}
/*
ICN : ATL, SFO
SFO : ATL
ATL : ICN, SFO

ICN -> ATL -> ICN -> SFO -> ATL -> SFO
*/