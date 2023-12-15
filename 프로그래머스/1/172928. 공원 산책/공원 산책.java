class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        int H = park.length;
        int W = park[0].length();
        
        char[][] newPark = new char[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                newPark[i][j] = park[i].charAt(j);
                if (newPark[i][j] == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        
        loop : for (String route : routes) {
            char direction = route.charAt(0);
            int distance = route.charAt(2) - '0';
            
            switch (direction) {
                case 'N':
                    if (answer[0] - distance < 0) continue loop;
                    for (int i = 1; i <= distance; i++) {
                        if (newPark[answer[0] - i][answer[1]] == 'X') continue loop;
                    }
                    answer[0] -= distance;
                    break;
                case 'S':
                    if (answer[0] + distance >= H) continue loop;
                    for (int i = 1; i <= distance; i++) {
                        if (newPark[answer[0] + i][answer[1]] == 'X') continue loop;
                    }
                    answer[0] += distance;
                    break;
                case 'W':
                    if (answer[1] - distance < 0) continue loop;
                    for (int i = 1; i <= distance; i++) {
                        if (newPark[answer[0]][answer[1] - i] == 'X') continue loop;
                    }
                    answer[1] -= distance;
                    break;
                case 'E':
                    if (answer[1] + distance >= W) continue loop;
                    for (int i = 1; i <= distance; i++) {
                        if (newPark[answer[0]][answer[1] + i] == 'X') continue loop;
                    }
                    answer[1] += distance;
            }
        }
        
        return answer;
    }
}