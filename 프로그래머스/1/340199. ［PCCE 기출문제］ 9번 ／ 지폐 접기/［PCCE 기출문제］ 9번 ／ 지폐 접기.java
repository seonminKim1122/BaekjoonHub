class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        while (min(bill) > min(wallet) || max(bill) > max(wallet)) {
            if (bill[0] > bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            answer++;
        }
        
        return answer;
    }
    
    int min(int[] arr) {
        int result = arr[0];
        for (int v : arr) {
            result = Math.min(result, v);
        }
        return result;
    }
    
    int max(int[] arr) {
        int result = arr[0];
        for (int v : arr) {
            result = Math.max(result, v);
        }
        return result;
    }
}