import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashSet<String> phoneNumbers = new HashSet<>();
        for (String phoneNumber : phone_book) {
            phoneNumbers.add(phoneNumber);
        }
        
        for (String phoneNumber : phone_book) {
            StringBuilder prefix = new StringBuilder();
            
            int N = phoneNumber.length();
            for (int i = 0; i < N - 1; i++) {
                prefix.append(phoneNumber.charAt(i));
                if (phoneNumbers.contains(prefix.toString())) return false;
            }
            
        }
        
        return answer;
    }
}

/*
브루트포스 방식 -> 시간초과

12, 88, 123, 567, 1235

12: 0, 88: 1, 123: 2, 567: 3, 1234: 4

1,000,000 * 1,000,001 / 2


1,000,000 * 19
*/