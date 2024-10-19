import java.util.*;

public class Solution {
    
    public int[] solution(int N, int[] stages) {
        int[] info1 = new int[N + 2]; // info1[i] => 지금 i 스테이지에 있는 사람 수
        int[] info2 = new int[N + 2]; // info2[i] => i 스테이지 이상인 사람 수
        
        for (int stage : stages) {
            info1[stage]++;
            for (int i = 1; i <= stage; i++) {
                info2[i]++;
            }
        }
        
        List<Stage> stageList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (info2[i] == 0) {
                stageList.add(new Stage(i, 0));
                continue;
            }
            double failure = (double)(info1[i]) / (info2[i]);
            stageList.add(new Stage(i, failure));
        }
        
        Collections.sort(stageList);
        
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = stageList.get(i).number;
        }
        
        return result;
    }
}

class Stage implements Comparable<Stage> {
    int number;
    double failure;
    
    Stage(int number, double failure) {
        this.number = number;
        this.failure = failure;
    }
    
    public int compareTo(Stage other) {
        if (this.failure < other.failure) {
            return 1;
        } else if (this.failure > other.failure) {
            return -1;
        } else {
            return this.number - other.number;
        }
    }
}

/*
stage X 의 실패율
-> X 인 사람 수 / X 이상인 사람 수

X 이상인 사람 수 계산
-> ?
*/