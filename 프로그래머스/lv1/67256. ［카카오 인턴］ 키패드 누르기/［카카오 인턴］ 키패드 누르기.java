class Solution {
    public String solution(int[] numbers, String hand) {
        int left = 10;
        int right = 12;
        String answer = "";

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                numbers[i] = 11;
            }
            if (numbers[i]%3 == 1) {
                answer += "L";
                left = numbers[i];
            }
            else if (numbers[i]%3 == 0) {
                answer += "R";
                right= numbers[i];
            }
            else if (numbers[i]%3 == 2) {
                
                int leftDistance = (Math.abs(numbers[i] - left) / 3) + (Math.abs(numbers[i] - left) % 3);
                int rightDistance = (Math.abs(numbers[i] - right) / 3) + ( Math.abs(numbers[i] - right) % 3);
                if (leftDistance == rightDistance){
                    if (hand.equals("right")){
                        answer += "R";
                        right= numbers[i];
                    }
                    else{
                        answer += "L";
                        left = numbers[i];
                    }
                }
                else if (leftDistance < rightDistance) {
                    answer += "L";
                    left = numbers[i];
                }
                else {
                    answer += "R";
                    right= numbers[i];
                }
            }
        }

        return answer;
    }
}