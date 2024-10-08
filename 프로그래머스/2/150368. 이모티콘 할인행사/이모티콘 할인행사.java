class Solution {
    
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = solve(0, emoticons, new int[emoticons.length], users);
        return answer;
    }
    
    int[] solve(int depth, int[] emoticons, int[] path, int[][] users) {
        if (depth == path.length) {
            int plusService = 0;
            int sales = 0;
            
            for (int i = 0; i < users.length; i++) {
                int[] user = users[i];
                int temp = 0;
                for (int j = 0; j < path.length; j++) {
                    if (path[j] < user[0]) continue;
                    int discount = emoticons[j] * path[j] / 100;
                    temp += (emoticons[j] - discount);
                }
                
                if (temp >= user[1]) {
                    plusService++;
                } else {
                    sales += temp;
                }
            }
            
            return new int[]{plusService, sales};
        }
        
        int[] result = new int[2];
        for (int i = 1; i <= 4; i++) {
            path[depth] = i * 10;
            result = max(result, solve(depth + 1, emoticons, path, users));
            path[depth] = 0;
        }
        
        return result;
    }
    
    int[] max(int[] case1, int[] case2) {
        if (case1[0] > case2[0]) return case1;
        else if (case1[0] < case2[0]) return case2;
        else {
            if (case1[1] >= case2[1]) return case1;
            else return case2;
        }
    }
}

/*
가능한 할인율: 10%, 20%, 30%, 40%

가장 간단한 방법
1. 브루트포스 -> 4^7 가지 수 => 2^14 enough
2. 각 경우의 수에 대해 user 수만큼 연산 => * 100

*/