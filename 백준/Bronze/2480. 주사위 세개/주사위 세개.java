import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int reward = 0;
        if (A == B && B == C) {
            reward = 10000 + A*1000;
        } else if (A == B) {
            reward = 1000 + A*100;
        } else if (B == C) {
            reward = 1000 + B*100;
        } else if (C == A) {
            reward = 1000 + C*100;
        } else {
            reward = Math.max(Math.max(A,B),C) * 100;
        }
        System.out.println(reward);
    }
}