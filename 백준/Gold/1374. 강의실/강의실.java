import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Lecture> lectures = new PriorityQueue<>((l1, l2) -> (l1.start - l2.start));
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lectures.add(new Lecture(start, end));
        }

        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        while (!lectures.isEmpty()) {
            Lecture temp = lectures.poll();

            if (!rooms.isEmpty() && rooms.peek() <= temp.start) {
                rooms.poll();
            }
            rooms.add(temp.end);
        }

        System.out.println(rooms.size());
    }
}

class Lecture {
    int start;
    int end;

    Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }
}