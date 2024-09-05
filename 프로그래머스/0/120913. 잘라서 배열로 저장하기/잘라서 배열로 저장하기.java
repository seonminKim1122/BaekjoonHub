class Solution {
    public String[] solution(String my_str, int n) {
        int size = my_str.length() / n + (my_str.length() % n == 0 ? 0 : 1);
        String[] answer = new String[size];
        
        for (int i = 0; i < size; i++) {
            if ((i + 1) * n > my_str.length()) {
                answer[i] = my_str.substring(i * n, my_str.length());
            }else {
                answer[i] = my_str.substring(i * n, (i + 1) * n);
            }
        }
        
        return answer;
    }
}