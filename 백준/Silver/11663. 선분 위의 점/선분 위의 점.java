import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> numbers = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        
        numbers.sort((i1, i2) -> i1 - i2);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            sb.append(onTheLine(from, to, numbers)).append("\n");
        }

        System.out.println(sb);
    }

    public static int onTheLine(int from, int to, List<Integer> numbers) {
        int start = 0;
        int end = numbers.size()-1;

        boolean a = false;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (from < numbers.get(mid)) {
                end = mid - 1;
            } else if (from > numbers.get(mid)) {
                start = mid + 1;
            } else {
                a = true;
                break;
            }
        }
        int startIdx;
        if (a) {
            startIdx = (start + end) / 2;
        } else {
            startIdx = start;
        }


        start = 0;
        end = numbers.size() - 1;
        boolean b = false;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (to < numbers.get(mid)) {
                end = mid - 1;
            } else if (to > numbers.get(mid)) {
                start = mid + 1;
            } else {
                b = true;
                break;
            }
        }

        int endIdx;
        if (b) {
            endIdx = (start + end) / 2;
        } else {
            endIdx = end;
        }


        return endIdx - startIdx + 1;
    }
}