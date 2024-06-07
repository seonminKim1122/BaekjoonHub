class Solution {
    public int solution(int[] toppings) {
        int answer = 0;
        
        int[] left = new int[10001];
        int[] right = new int[10001];
        
        int leftKind = 0;
        int rightKind = 0;
        for (int topping : toppings) {
            if (right[topping] == 0) {
                rightKind++;
            }
            right[topping]++;
        }
        
        for (int i = 0; i < toppings.length; i++) {
            int topping = toppings[i];
            if (left[topping] == 0) leftKind++;
            left[topping]++;
            right[topping]--;
            if (right[topping] == 0) rightKind--;
            
            if (leftKind == rightKind) answer++;
        }
        
        return answer;
    }
}