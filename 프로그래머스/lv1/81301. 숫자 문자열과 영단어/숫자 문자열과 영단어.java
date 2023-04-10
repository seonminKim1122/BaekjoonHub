class Solution {
    public int solution(String s) {
        String[] nums = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] engNums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        int len = engNums.length;
        for (int i = 0; i < len; i++) {
            s = s.replaceAll(engNums[i], nums[i]);
        }

        return Integer.parseInt(s);
    }
}