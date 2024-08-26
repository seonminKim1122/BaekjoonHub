class Solution {
    public int solution(String s) {
        int N = s.length();
        
        int answer = N;
        
        for (int unit = 1; unit <= N / 2; unit++) {            
            int temp = solve(s, unit);
            answer = Math.min(answer, temp);
        }
            
        return answer;
    }
    
    public int solve(String s, int unit) {
        int N = s.length();
        
        int result = N;
        
        int s1 = 0;
        int s2 = s1 + unit;
        
        while (s2 + unit <= N) {
            String sub1 = s.substring(s1, s1 + unit);
            String sub2 = s.substring(s2, s2 + unit);
            
            int cnt = 0;
            while (sub1.equals(sub2)) {
                cnt++;
                s2 += unit;
                if (s2 + unit > N) break;
                sub2 = s.substring(s2, s2 + unit);
            }
            
            s1 = s2;
            s2 = s1 + unit;
            
            if (cnt == 0) continue;
            
            result = result - (cnt * unit) + String.valueOf(cnt + 1).length();
        }
        
        return result;
    }
}
/*
무조건 앞에서부터 잘라야 하므로 투포인터 방식 활용 가능해보임

substring(i, i + unit) 과 같은 게 몇 개나 되는지 세보기.?

"abcabcabcabcdededededede"

unit = 3

"abc" = substring(0, 3);
cnt = 3
if (cnt == 0) continue;
temp = temp - (cnt * unit) + 1;

*/