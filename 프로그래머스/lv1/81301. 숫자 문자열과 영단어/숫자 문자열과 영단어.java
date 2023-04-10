class Solution {
    public int solution(String s) {
        int answer = 0;
        
        StringBuilder tempAnswer = new StringBuilder();
        StringBuilder tempNum = new StringBuilder();

        for(char n : s.toCharArray()) {
            if(n - '0' >= 0 && n - '0' <= 9) {
                tempAnswer.append(n);
                tempNum = new StringBuilder();
            } else {
                tempNum.append(n);
                switch (tempNum.toString()) {
                    case "one":
                        tempAnswer.append("1");
                        tempNum.setLength(0);
                        break;
                    case "two":
                        tempAnswer.append("2");
                        tempNum.setLength(0);
                        break;
                    case "three":
                        tempAnswer.append("3");
                        tempNum.setLength(0);
                        break;
                    case "four":
                        tempAnswer.append("4");
                        tempNum.setLength(0);
                        break;
                    case "five":
                        tempAnswer.append("5");
                        tempNum.setLength(0);
                        break;
                    case "six":
                        tempAnswer.append("6");
                        tempNum.setLength(0);
                        break;
                    case "seven":
                        tempAnswer.append("7");
                        tempNum.setLength(0);
                        break;
                    case "eight":
                        tempAnswer.append("8");
                        tempNum.setLength(0);
                        break;
                    case "nine":
                        tempAnswer.append("9");
                        tempNum.setLength(0);
                        break;
                    case "zero":
                        tempAnswer.append("0");
                        tempNum.setLength(0);
                        break;
                }
            }
        }

        answer = Integer.parseInt(tempAnswer.toString());

        return answer;
    }
}