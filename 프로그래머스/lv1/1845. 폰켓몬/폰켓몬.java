class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        int max = 0;
        for(int num : nums) {
            if(num > max) {
                max = num;
            }
        }

        int[] poketmons = new int[max+1];
        for(int num : nums) {
            poketmons[num]++;
        }

        for(int poketmon : poketmons) {
            if (poketmon != 0) {
                answer++;
                if (answer >= nums.length/2) {
                    break;
                }
            }
        }

        return answer;
    }
}