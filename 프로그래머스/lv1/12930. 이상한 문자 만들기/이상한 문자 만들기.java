class Solution {
    public String solution(String s) {
        String answer = "";

        String[] chars = s.split("");
        int idx = 0;
        for (String c : chars) {
            if (c.equals(" ")) {
                answer += c;
                idx = 0;
                continue;
            }

            if (idx % 2 == 0) {
                answer += c.toUpperCase();
            } else {
                answer += c.toLowerCase();
            }
            idx++;
        }
        return answer;
    }
}