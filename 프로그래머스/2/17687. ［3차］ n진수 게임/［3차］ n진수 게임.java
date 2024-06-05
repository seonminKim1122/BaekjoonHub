class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        int turn = 1;
        int tube = p;
        
        int num = 0;
        while (t > 0) {
            char[] digits = Integer.toString(num, n).toUpperCase().toCharArray();
            
            for (int i = 0; i < digits.length; i++) {
                if (turn == tube) {
                    answer += digits[i];
                    tube += m;
                    t--;
                    if (t == 0) break;
                }
                turn++;
            }
            
            num++;
        }
        
        return answer;
    }
    
    
}

/*
1. 10진수를 n진수로 변환
2. 변환된 n진수를 한 명씩 말하기
3. 현재 턴이 튜브의 턴이면 answer 에 +
4. 아니면 pass
*/