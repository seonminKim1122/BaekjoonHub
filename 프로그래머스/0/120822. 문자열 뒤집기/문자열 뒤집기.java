class Solution {
    public String solution(String my_string) {
        String answer = reverse(my_string);
        return answer;
    }
    
    String reverse(String input) {
        int size = input.length();
        
        char[] output = new char[size];
        for (int i = 0; i < size; i++) {
            output[size - i - 1] = input.charAt(i);
        }
        
        return String.valueOf(output);
    }
}