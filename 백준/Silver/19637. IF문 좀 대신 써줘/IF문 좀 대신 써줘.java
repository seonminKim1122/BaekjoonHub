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

        List<Title> titles = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int power = Integer.parseInt(st.nextToken());
            titles.add(new Title(name, power));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int power = Integer.parseInt(br.readLine());
            int start = 0;
            int end = titles.size()-1;
            while (start <= end) {
                int mid = (start + end) / 2;

                if (mid-1 >= 0 && power <= titles.get(mid-1).power) {
                    end = mid - 1;
                } else if (power > titles.get(mid).power) {
                    start = mid + 1;
                } else {
                    sb.append(titles.get(mid).name).append("\n");
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}

class Title {
    String name;
    int power;
    
    Title(String name, int power) {
        this.name = name;
        this.power = power;
    }
}