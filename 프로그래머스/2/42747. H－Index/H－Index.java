class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        int start = 0;
        int end = 10000;
        
        while (start <= end) {
            int h = (start + end) / 2;
            
            int cnt = 0;
            for (int citation : citations) {
                if (citation >= h) {
                    cnt++;
                }
            }
            
            if (cnt >= h) {
                // h 번 이상 인용된 논문이 h 편 이상
                answer = h;
                start = h + 1;
            } else {
                // h 번 이상 인용된 논문이 h 편 미만
                end = h - 1;
            }
        }
        
        return answer;
    }
}