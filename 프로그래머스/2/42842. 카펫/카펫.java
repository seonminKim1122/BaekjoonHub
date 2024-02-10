class Solution {
    public int[] solution(int brown, int yellow) {
        
        int a = brown / 2;
        int b = yellow;
        
        int temp = (int)Math.sqrt(a * (a - 4) - 4 * (b - 1));

        int N = (a + 2 - temp) / 2;
        int M = a + 2 - N;
        
        int[] answer = {M, N};
        
        return answer;
    }
}