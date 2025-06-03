import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meetings.add(new Meeting(start, end));
        }

        Collections.sort(meetings);

        int beforeEnd = 0;
        int answer = 0;
        for (int i = 0; i < N; i++) {
            Meeting meeting = meetings.get(i);

            if (meeting.canStart(beforeEnd)) {
                beforeEnd = meeting.end;
                answer++;
            }
        }

        System.out.println(answer);
    }


    static class Meeting implements Comparable<Meeting> {

        int start;
        int end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Meeting other) {
            return this.end - other.end == 0 ? this.start - other.start : this.end - other.end;
        }

        boolean canStart(int beforeEnd) {
            return start >= beforeEnd;
        }
    }
}