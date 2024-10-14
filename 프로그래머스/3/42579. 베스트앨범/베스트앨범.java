import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Genre> map = new HashMap<>();
        for (String genre : genres) {
            map.put(genre, new Genre(genre, 0));
        }
        
        int N = plays.length;
        for (int i = 0; i < N; i++) {
            Song song = new Song(i, plays[i]);
            map.get(genres[i]).addSong(song);
        }
        
        PriorityQueue<Genre> pq = new PriorityQueue<>((g1, g2) -> g2.play - g1.play);
        for (Genre genre: map.values()) {
            pq.add(genre);
        }
        
        List<Integer> temp = new ArrayList<>();
        while (!pq.isEmpty()) {
            Genre genre = pq.poll();
            
            List<Song> songs = genre.songs;
            Collections.sort(songs, (s1, s2) -> {
                if (s1.play != s2.play) {
                    return s2.play - s1.play;
                } else {
                    return s1.id - s2.id;
                }
            });
            
            for (int i = 0; i < 2; i++) {
                if (i >= songs.size()) break;
                Song song = songs.get(i);
                temp.add(song.id);
            }
        }
        
        int size = temp.size();
        int[] answer = new int[size];
        for (int i = 0; i < size; i++) {
            answer[i] = temp.get(i);
        }
        
        return answer;
    }
}

class Genre {
    String genre;
    int play;
    List<Song> songs = new ArrayList<>();
    
    Genre(String genre, int play) {
        this.genre = genre;
        this.play = play;
    }
    
    void addSong(Song song) {
        songs.add(song);
        this.play += song.play;
    }
}

class Song {
    int id;
    int play;
    
    Song(int id, int play) {
        this.id = id;
        this.play = play;
    }
}
/*
필요한 정보
1. 장르별 재생횟수
2. 고유번호별 재생회수
*/