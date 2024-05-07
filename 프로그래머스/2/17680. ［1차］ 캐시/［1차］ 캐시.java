class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return 5 * cities.length;
        }
        
        int answer = 0;

        String[] cache = new String[cacheSize];
        
        init(cache);
        
        for (String city: cities) {
            city = city.toUpperCase();
            int idx = isHit(cache, city);
            if (idx == -1) {
                // cache miss
                insertInfo(cache, city);
                answer += 5;
            } else {
                // cache hit
                modifyInfo(cache, city, idx);
                answer += 1;
            }
        }
        
        return answer;
    }
    
    void init(String[] cache) {
        for (int i = 0; i < cache.length; i++) {
            cache[i] = "";
        }
    }
    
    int isHit(String[] cache, String city) {
        for (int i = 0; i < cache.length; i++) {
            if (cache[i].equals(city)) return i;
        }
        return -1;
    }
    
    void modifyInfo(String[] cache, String city, int idx) {
        for (int i = idx; i > 0; i--) {
            cache[i] = cache[i - 1];
        }
        cache[0] = city;
    }
    
    void insertInfo(String[] cache, String city) {
        for (int i = cache.length - 1; i > 0; i--) {
            cache[i] = cache[i - 1];
        }
        cache[0] = city;
    }
}