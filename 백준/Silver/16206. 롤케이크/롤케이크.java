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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 롤케이크의 개수
        int M = Integer.parseInt(st.nextToken()); // 자를 수 있는 최대 횟수

        st = new StringTokenizer(br.readLine());
        List<Integer> priorities = new ArrayList<>();
        List<Integer> roleCakes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int roleCake = Integer.parseInt(st.nextToken());
            if (roleCake % 10 == 0) {
                priorities.add(roleCake);
            } else {
                roleCakes.add(roleCake);
            }
        }

        Collections.sort(priorities);

        int result = 0;
        for (int i = 0; i < priorities.size(); i++) {
            if (M <= 0) break;

            int roleCake = priorities.get(i);
            int cut = (roleCake / 10) - 1;
            int get = roleCake / 10;

            if (cut <= M) {
                result += get;
                M -= cut;
            } else {
                result += M;
                M = 0;
            }
        }

        for (int i = 0; i < roleCakes.size(); i++) {
            if (M <= 0) break;

            int roleCake = roleCakes.get(i);
            int cut = (roleCake / 10);
            int get = (roleCake / 10);

            if (cut <= M) {
                result += get;
                M -= cut;
            } else {
                result += M;
                M = 0;
            }
        }

        System.out.println(result);
    }
}