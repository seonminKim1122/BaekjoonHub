class Solution {
    public int solution(int[] arr) {
        int largestNum = arr[0];
        for (int num : arr) {
            if (largestNum < num) {
                largestNum = num;
            }
        }
        
        int LCM = largestNum;
        while (true) {
            boolean findAnswer = true;
            for (int num : arr) {
                if (LCM % num != 0) {
                    findAnswer = false;
                    break;
                }
            }
            
            if (findAnswer) break;
            LCM += largestNum;
        }
        
        return LCM;
    }
}