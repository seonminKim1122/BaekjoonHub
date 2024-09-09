class Solution {
    public String[] solution(String[] quiz) {
        int size = quiz.length;
        
        String[] answer = new String[size];
        for (int i = 0; i < size; i++) {
            String[] arr = quiz[i].split(" ");
            
            int X = Integer.parseInt(arr[0]);
            int Y = Integer.parseInt(arr[2]);
            int Z = Integer.parseInt(arr[4]); 
            
            String operator = arr[1];
            if (Z == operate(operator, X, Y)) {
                answer[i] = "O";
            } else {
                answer[i] = "X";
            }
        }
        
        return answer;
    }
    
    int operate(String operator, int A, int B) {
        int result = 0;
        switch (operator) {
            case "+":
                result = A + B;
                break;
            default:
                result = A - B;
        }
        return result;
    }
}