import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Class> classes = new PriorityQueue<>((o1, o2) -> o1.start - o2.start);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            classes.add(new Class(start, end));
        }

        PriorityQueue<Class> appended = new PriorityQueue<>((o1, o2) -> o1.end - o2.end);
        appended.add(classes.poll());

        while (!classes.isEmpty()) {
            Class c = classes.poll();

            if (c.start >= appended.peek().end) {
                appended.poll();
            }

            appended.add(c);
        }

        System.out.println(appended.size());
    }
}

class Class {
    int start;
    int end;

    Class (int start, int end) {
        this.start = start;
        this.end = end;
    }
}