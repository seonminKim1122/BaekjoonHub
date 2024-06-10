import java.util.*;

class Solution {
    
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        int size = 'Z' - 'A' + 1;
        int[] originInfo = new int[size];
        boolean[][] graph = new boolean[size][size];
        for (int i = 1; i < skill.length(); i++) {
            char beforeSk = skill.charAt(i - 1);
            char nowSk = skill.charAt(i);
            
            originInfo[nowSk - 'A'] = 1;
            graph[beforeSk - 'A'][nowSk - 'A'] = true;
        }
        
        
        for (String skill_tree : skill_trees) {
            int[] beforeLearn = copyOrigin(originInfo);
            if (isOkay(beforeLearn, graph, skill_tree)) {
                answer++;
            }
        }
        
        return answer;
    }

    boolean isOkay(int[] beforeLearn, boolean[][] graph, String skill_tree) {
        int N = skill_tree.length();
        for (int i = 0; i < N; i++) {
            char skill = skill_tree.charAt(i);
            
            if (beforeLearn[skill - 'A'] > 0) return false;
            for(int j = 0; j < 26; j++) {
                if (graph[skill - 'A'][j]) {
                    beforeLearn[j]--;
                }
            }
        }
        return true;
    }
    
    int[] copyOrigin(int[] origin) {
        int[] copy = new int[origin.length];
        for (int i = 0; i < origin.length; i++) {
            copy[i] = origin[i];
        }
        return copy;
    }
}

/*
before -> 사전에 배워야 하는 스킬 수

CBD

A : 0
B : 1
C : 0
D : 2
...

C -> B : 그래프 잇으니까 -1 처리
*/