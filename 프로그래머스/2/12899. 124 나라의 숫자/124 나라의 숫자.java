class Solution {
    public String solution(int n) {
        String answer = "";
        
        int digit = 1;
        while (n > 3 * (Math.pow(3, digit) - 1) / 2) {
            digit++;
        }
        
        int diff = n - (int)(3 * (Math.pow(3, digit - 1) - 1) / 2 + 1);
        
        while (digit > 0) {
            int temp = (int)(Math.pow(3, digit - 1));
            if (diff >= 2 * temp) {
                answer += "4";
                diff -= 2 * temp;
            } else if (diff >= temp) {
                answer += "2";
                diff -= temp;
            } else {
                answer += "1";
            }
            digit--;
        }
        
        return answer;
    }
}

/*
digit = 2
diff = 5

diff - 6 >= 0? no
diff - 3 >= 0? yes -> 현재 자리 2

digit = 1
diff = 2

diff - 2 >= 0? yes -> 자리 4

digit = 0
diff = 0
*/