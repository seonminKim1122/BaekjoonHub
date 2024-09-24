class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        
        int[] temp1 = new int[10];
        for (int i = 0; i < X.length(); i++) {
            temp1[X.charAt(i) - '0']++;
        }
        
        int[] temp2 = new int[10];
        for (int i = 0; i < Y.length(); i++) {
            temp2[Y.charAt(i) - '0']++;
        }
        
        int[] bucket = new int[10];
        for (int i = 0; i < 10; i++) {
            bucket[i] = Math.min(temp1[i], temp2[i]);
        }
        
        boolean hasPair = false;
        for (int i = 0; i < 10; i++) {
            if (bucket[i] > 0) {
                hasPair = true;
                break;
            }
        }
        
        if (!hasPair) return "-1";
        
        for (int i = 9; i > 0; i--) {
            int cnt = bucket[i];
            while (cnt > 0){
                answer.append(i);
                cnt--;
            }
        }
        
        int cnt = bucket[0];
        if (cnt > 0 && answer.length() == 0) {
            answer.append("0");
        } else {
            while(cnt > 0) {
                answer.append("0");
                cnt--;
            }
        }
        
        
        return answer.toString();
    }
}