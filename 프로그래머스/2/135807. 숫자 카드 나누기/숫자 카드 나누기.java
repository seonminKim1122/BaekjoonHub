class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int gcdA = arrayA[0];
        for (int i = 1;i < arrayA.length; i++) {
            gcdA = GCD(arrayA[i], gcdA);
        }
        
        int gcdB = arrayB[0];
        for (int i = 1;i < arrayB.length; i++) {
            gcdB = GCD(arrayB[i], gcdB);
        }
        
        boolean gcdAValid = true;
        for (int i = 0; i < arrayB.length; i++) {
            if (arrayB[i] % gcdA == 0) {
                gcdAValid = false;
                break;
            }
        }
        
        boolean gcdBValid = true;
        for (int i = 0; i < arrayA.length; i++) {
            if (arrayA[i] % gcdB == 0) {
                gcdBValid = false;
                break;
            }
        }
        
        if (gcdAValid && gcdBValid) {
            answer = Math.max(gcdA, gcdB);
        } else if (gcdAValid) {
            answer = gcdA;
        } else if (gcdBValid) {
            answer = gcdB;
        } else {
            answer = 0;
        }
        
        
        
        return answer;
    }
    
    int GCD(int A, int B) {
        if (B > A) {
            int temp = A;
            A = B;
            B = temp;
        }
        
        if (B == 0) return A;
        int R = A % B;
        return GCD(B, R);
    }
}
/*
arrayA의 최대공약수이면서 arrayB 와는 서로소..
arrayB의 최대공약수이면서 arrayA 와는 서로소..

최대 공약수 구하기 GCD

A = B * Q + R
B = R * Q + R2
R2 가 0이 되면 

*/