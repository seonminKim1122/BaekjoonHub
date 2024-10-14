import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, (o1, o2) -> {
            if (o1[1] < o2[1]) {
                return -1;
            } else if (o1[1] > o2[1]) {
                return 1;
            } else {
                if (o1[0] < o2[0]) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        
        int end = routes[0][1];
        answer++;
        
        for (int i = 0; i < routes.length; i++) {
            if (routes[i][0] <= end) continue;
            answer++;
            end = routes[i][1];
        }
        
        return answer;
    }
}
/*
끝나는 지점 기준 정렬

-20, -15
-18, -13
-14, -5
-5, -3

-15 >= -18 이니까 -15 에 설치해서 처리 가능 pass
-15 < -14 이니까 추가 설치 필요
-5 >= -5
*/