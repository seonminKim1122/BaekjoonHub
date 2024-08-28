class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = solve(picks, minerals, 0);
        return answer;
    }
    
    
    
    public int solve(int[] picks, String[] minerals, int round) {
        // 더 캘 광물이 없거나
        if ((minerals.length - 1) / 5 + 1 <= round) {
            return 0;
        }
        // 사용할 곡갱이가 없으면 끝
        if (picks[0] + picks[1] + picks[2] <= 0) return 0;
        
        int result = 25 * minerals.length + 1;
        
        for (int i = 0; i < 3; i++) {
            if (picks[i] <= 0) continue;
            picks[i]--;
            int temp = solve(picks, minerals, round + 1) + calc(i, minerals, round);
            result = Math.min(result, temp);
            picks[i]++;
        }
        
        return result;
    }
    
    public int calc(int pick, String[] minerals, int round) {
        int result = 0;
        for (int i = round * 5; i < (round + 1) * 5; i++) {
            if (i >= minerals.length) break;
            
            switch (pick) {
                case 0:
                    result++;
                    break;
                case 1:
                    if (minerals[i].equals("diamond")) {
                        result += 5;
                    } else {
                        result++;
                    }
                    break;
                default:
                    if (minerals[i].equals("diamond")) {
                        result += 25;
                    } else if (minerals[i].equals("iron")) {
                        result += 5;
                    } else {
                        result++;
                    }
            }
        }
                    
        return result;
    }
}