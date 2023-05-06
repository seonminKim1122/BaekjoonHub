import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringTokenizer st3 = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st1.nextToken());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st2.nextToken()));
        }

        int M = Integer.parseInt(st1.nextToken());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st3.nextToken());
            if (set.contains(num)) {
                set.remove(num);
                continue;
            }
            set.add(num);
        }

        System.out.println(set.size());
    }
}