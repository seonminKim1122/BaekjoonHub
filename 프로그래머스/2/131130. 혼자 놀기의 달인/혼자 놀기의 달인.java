class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        
        int N = cards.length;
        boolean[] isOpen = new boolean[N];
        
        int[] largeGroups = new int[2];
        
        for (int i = 0; i < N; i++) {
            if (isOpen[i]) continue;
            int target = i;
            int group = 0;
            while (!isOpen[target]) {
                group++;
                isOpen[target] = true;
                target = cards[target] - 1;
            }
            
            if (largeGroups[0] < largeGroups[1] && group > largeGroups[0]) {
                largeGroups[0] = group;
            } else if (largeGroups[0] >= largeGroups[1] && group > largeGroups[1]){
                largeGroups[1] = group;
            }
        }
        
        answer = largeGroups[0] * largeGroups[1];
        return answer;
    }
}