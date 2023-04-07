class Solution {
    public int[] solution(long n) {
        // step1. 배열의 크기 정하기
        int size = 0;
        long divisor = 1;

        while ((n % divisor) != n) {
            divisor *= 10;
            size += 1;
        }
        int[] answer = new int[size];

        // step2. 마지막 자리부터 answer 배열에 넣어주기
        int idx = 0;
        divisor = 1;
        long i = 0;
        while ((n % divisor) != n) {
            i = ((n % (divisor*10)) - (n % divisor)) / divisor;
            divisor *= 10;
            answer[idx++] = (int) i;
        }

        return answer;
    }
}