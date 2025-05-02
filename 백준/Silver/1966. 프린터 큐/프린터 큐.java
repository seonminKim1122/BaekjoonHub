import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            T--;

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            Queue<Document> queue = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                int importance = Integer.parseInt(st.nextToken());
                queue.add(new Document(i, importance));
            }


            int sequence = 0;
            int result = 0;
            while (!queue.isEmpty()) {
                Document front = queue.poll();

                if (isBiggerExist(queue, front)) {
                    queue.add(front);
                } else {
                    sequence++;
                    if (front.startIdx == M) {
                        result = sequence;
                        break;
                    }
                }
            }

            sb.append(result);
            sb.append('\n');
        }


        System.out.println(sb);
    }

    // queue 에서 doc 보다 더 중요도가 높은 문서가 존재하는지 확인하는 메서드
    private static boolean isBiggerExist(Queue<Document> queue, Document doc) {
        for (Document other: queue) {
            if (doc.compareTo(other) > 0) return true;
        }
        return false;
    }


    static class Document implements Comparable<Document> {

        int startIdx = -1;
        int importance = 0;

        Document(int startIdx, int importance) {
            this.startIdx = startIdx;
            this.importance = importance;
        }

        @Override
        public int compareTo(Document other) {
            return other.importance - this.importance;
        }
    }
}