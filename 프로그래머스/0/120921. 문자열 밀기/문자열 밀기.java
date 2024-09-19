class Solution {
    public int solution(String A, String B) {
        int answer = -1;
        
        int len = A.length();
        for (int i = 0; i < len; i++) {
            if (A.equals(B)) {
                answer = i;
                break;
            }
            A = push(A);
        }
        
        return answer;
    }
    
    String push(String origin) {
        char[] arr = origin.toCharArray();
        char last = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = last;
        
        return String.valueOf(arr);
    }
}