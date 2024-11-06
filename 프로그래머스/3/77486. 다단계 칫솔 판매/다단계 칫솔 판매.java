import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        
        int total = enroll.length;
        Map<String, String> parent = new HashMap<>();
        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < total; i++) {
            parent.put(enroll[i], referral[i]);
            result.put(enroll[i], 0);
        }
        
        int[] answer = new int[total];
        int N = seller.length;
        for (int i = 0; i < N; i++) {
            solve(seller[i], amount[i] * 100, parent, result);
        }
        
        for (int i = 0; i < total; i++) {
            answer[i] = result.get(enroll[i]);
        }
        
        return answer;
    }
    
    public void solve(String seller, int amount, 
                      Map<String, String> parent, Map<String, Integer> result) {
        if (amount == 0) return;
        if (seller.equals("-")) return;
        
        solve(parent.get(seller), amount / 10, parent, result);
        result.put(seller, result.get(seller) + amount - amount / 10);
    }
}
/*
referral[i] : enroll[i] 를 가입시킨 사람
*/