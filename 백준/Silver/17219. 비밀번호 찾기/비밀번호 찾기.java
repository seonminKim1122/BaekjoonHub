import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: 저장된 사이트 주소 수
        // M: 비밀번호를 찾으려는 사이트 주소 수
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> infoMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String uri = st.nextToken();
            String password = st.nextToken();

            infoMap.put(uri, password);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < M; i++) {
            String uri = br.readLine();
            bw.write(infoMap.get(uri));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}