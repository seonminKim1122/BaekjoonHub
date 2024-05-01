class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;

        a--;
        b--;
        
        while ((a / 2) != (b / 2)) {
            answer++;
            a /= 2;
            b /= 2;
        }

        return answer;
    }
}