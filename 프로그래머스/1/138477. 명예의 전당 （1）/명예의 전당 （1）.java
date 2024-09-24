import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        int[] jeondang = new int[k];
        Arrays.fill(jeondang, -1);
        
        for (int i = 0; i < score.length; i++) {
            int value = score[i];
            boolean inserted = false;
            for (int j = k - 1; j >= 0; j--) {
                if (jeondang[j] > value) {
                    insert(jeondang, j + 1, value);
                    inserted = true;
                    break;
                }
            }
            if (!inserted) insert(jeondang, 0, value);
            answer[i] = minOfToday(jeondang);
        }
        
        return answer;
    }
    
    int minOfToday(int[] jeondang) {
        for (int i = jeondang.length - 1; i >= 0; i--) {
            if (jeondang[i] >= 0) return jeondang[i];
        }
        return jeondang[0];
    }

    void insert(int[] score, int idx, int value) {
        if (idx >= score.length) return;
        for (int i = score.length - 1; i > idx; i--) {
            score[i] = score[i - 1];
        }
        score[idx] = value;
    }
}