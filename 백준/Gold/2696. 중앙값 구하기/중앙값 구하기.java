import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int M = Integer.parseInt(br.readLine());
            List<Integer> numbers = new ArrayList<>();
            List<Integer> medians = new ArrayList<>();

            for (int j = 0; j <= (M-1) / 10; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    int number = Integer.parseInt(st.nextToken());
                    numbers.add(number);

                    if (numbers.size() % 2 != 0) {
                        numbers.sort((o1, o2) -> o1 - o2);
                        int median = numbers.get(numbers.size() / 2);
                        medians.add(median);
                    }
                }
            }

            int count = medians.size();
            sb.append(count).append("\n");

            for (int j = 0; j < count; j++) {
                sb.append(medians.get(j)).append(" ");
                if (j % 10 == 9 && j != count-1) {
                    sb.append("\n");
                }
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}