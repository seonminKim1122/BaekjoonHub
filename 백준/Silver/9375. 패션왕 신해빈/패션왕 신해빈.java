import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트케이스
        StringBuilder answer = new StringBuilder();
        while (T > 0) {
            T--;

            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> clothMap = new HashMap<>(); // 카테고리별 옷의 수
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String cloth = st.nextToken();
                String category = st.nextToken();

                clothMap.put(category, clothMap.getOrDefault(category, 0) + 1);
            }

            // 각 카테고리에서 선택할 수 있는 경우의 수 : clothMap.get(category) + 1
            // 아무것도 안 입는 것은 불가능하므로 최종적으로 1 빼면 된다.

            int result = 1;
            Set<String> categories = clothMap.keySet();
            for (String category : categories) {
                result *= (clothMap.get(category) + 1);
            }
            result--;

            answer.append(result).append("\n");
        }

        System.out.println(answer);
    }
}