import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Meeting> meetings = new PriorityQueue<>((m1, m2) -> m1.start - m2.start);
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            Meeting meeting = new Meeting(input[0], input[1]);
            meetings.add(meeting);
        }

        PriorityQueue<Meeting> reserved = new PriorityQueue<>((m1, m2) -> m1.end - m2.end);
        reserved.add(meetings.poll());
        while (!meetings.isEmpty()) {
            Meeting meeting = meetings.poll();
            if (reserved.peek().end <= meeting.start) {
                reserved.poll();
            }
            reserved.add(meeting);
        }

        System.out.println(reserved.size());
    }
}

class Meeting {
    int start;
    int end;

    Meeting(String start, String end) {
        this.start = Integer.parseInt(start);
        this.end = Integer.parseInt(end);
    }
}