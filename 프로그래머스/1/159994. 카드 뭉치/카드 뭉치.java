class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        int idx1 = 0;
        int idx2 = 0;
        
        int size1 = cards1.length;
        int size2 = cards2.length;
        
        int target = 0;
        int size = goal.length;
        while (target < size ) {
            if (idx1 < size1 && cards1[idx1].equals(goal[target])) {
                idx1++;
                target++;
            } else if (idx2 < size2 && cards2[idx2].equals(goal[target])) {
                idx2++;
                target++;
            } else {
                answer = "No";
                break;
            }
        }
        
        return answer;
    }
}