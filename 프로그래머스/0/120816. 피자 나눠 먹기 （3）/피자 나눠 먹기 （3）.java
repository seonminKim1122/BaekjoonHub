class Solution {
    public int solution(int slice, int n) {
        int answer = 0;
        answer = (n / slice) + (n % slice == 0 ? 0 : 1);
        return answer;
    }
    
}

/*
slice * x >= n 을 만족하는 최소 x 구하기
x >= (n / slice) + (n % slice == 0 ? 0 : 1);
*/