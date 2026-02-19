import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int groupIdx = 0;
        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) break;

            String[] names = new String[n];
            Map<Integer, List<Integer>> resultMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String name = st.nextToken();
                names[i] = name;
                resultMap.put(i, new ArrayList<>());
                for (int j = 1; j < n; j++) {
                    String message = st.nextToken();

                    if (message.equals("N")) {
                        int badIdx = (i - j + n) % n;
                        resultMap.get(i).add(badIdx);
                    }
                }
            }

            // 출력
            groupIdx++;
            bw.write("Group " + groupIdx);
            bw.write("\n");
            boolean badExists = false;
            for (int i = 0; i < n; i++) {
                String B = names[i];
                List<Integer> badIdxs = resultMap.get(i);
                for (int badIdx: badIdxs) {
                    badExists = true;
                    String A = names[badIdx];
                    bw.write(A + " was nasty about " + B);
                    bw.write("\n");
                }
            }

            if (!badExists) {
                bw.write("Nobody was nasty");
                bw.write("\n");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
