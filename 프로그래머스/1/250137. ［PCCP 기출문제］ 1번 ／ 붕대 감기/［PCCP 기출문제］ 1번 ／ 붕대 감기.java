class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int max = health;
        int N = attacks.length;
        int time = 0;
        for (int i = 0; i < N; i++) {
            int attackTime = attacks[i][0];
            int damage = attacks[i][1];
            
            health += (attackTime - time) * bandage[1];
            health += (attackTime - time) / bandage[0] * bandage[2];
            
            health = Math.min(max, health);
            health -= damage;
            if (health <= 0) return -1;
            time = attackTime + 1;
        }
        
        answer = health;
        return answer;
    }
}

/*
0 ~ attacks[0][0] - 1 까지는 아무일도 일어나지 않음
attacks[0][0] 초에 health - attacks[0][1]

attacks[0][0] + 1 초 ~ attacks[1][0] 까지 체력회복

*/