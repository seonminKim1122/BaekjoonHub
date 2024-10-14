class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int len = stations.length;
        int cover = 2 * w + 1;
        for (int i = 1; i < len; i++) {
            int start = stations[i - 1] + w + 1;
            int end = stations[i] - w;
            answer += calc(end - start, cover);
        }
        
        // 시작 ~ stations[0] - w
        answer += calc(stations[0] - w - 1, cover);
        // stations[len - 1] + w + 1 ~ 끝
        answer += calc(n + 1 - (stations[len - 1] + w + 1), cover);

        return answer;
    }
    
    int calc(int numOfStations, int coverPerUnit) {
        if (numOfStations <= 0) return 0;
        int result = numOfStations / coverPerUnit;
        if (numOfStations % coverPerUnit != 0) result++;
        return result;
    }
}
/*
1 <= ... < stations[0] - w
stations[0] + w + 1 <= ... < stations[1] - w
stations[1] + w + 1 <= ... < stations[2] - w
...
stations[n - 1] + w + 1 <= ...< stations[n] - w

stations[n] + w + 1 <= ... < n + 1
*/