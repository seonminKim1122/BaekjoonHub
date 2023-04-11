class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        int length = arr1.length;
        String[] answer = new String[length];

        for (int i = 0; i < length; i++) {
            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]).replaceAll("1", "#").replaceAll("0", " ");
            while(answer[i].length() < n) {
                answer[i] = " " + answer[i];
            }
        }

        return answer;
    }
}