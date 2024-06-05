class Solution {
    public int solution(String dirs) {
        int answer = 0;
        Position p = new Position(5, 5);
        
        boolean[][][][] visited = new boolean[11][11][11][11];
        for (char dir : dirs.toCharArray()) {
            if (!p.isValid(dir)) continue;
            
            int[] before = new int[]{p.x, p.y};
            p.move(dir);
            int[] now = new int[]{p.x, p.y};
            
            if (!visited[before[0]][before[1]][now[0]][now[1]] && !visited[now[0]][now[1]][before[0]][before[1]]) {
                visited[before[0]][before[1]][now[0]][now[1]] = true;
                visited[now[0]][now[1]][before[0]][before[1]] = true;
                answer++;
            }
        }
        
        return answer;
    }
    
    class Position {
        int x;
        int y;
        
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        boolean isValid(char dir) {
            switch (dir) {
                case 'U':
                    return this.x > 0;
                case 'D':
                    return this.x < 10;
                case 'L':
                    return this.y > 0;
                default:
                    return this.y < 10;
            }
        }
        
        void move(char dir) {
            switch (dir) {
                case 'U':
                    this.x--;
                    break;
                case 'D':
                    this.x++;
                    break;
                case 'L':
                    this.y--;
                    break;
                default:
                    this.y++;
            }
        }
    }
}