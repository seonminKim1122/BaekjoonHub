import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ascCount = 0;
        int descCount = 0;
        for (int i = 1; i <= 8; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == i) {
                ascCount++;
            } else if (num == 9-i){
                descCount++;
            } else {
                break;
            }
        }

        if (ascCount == 8) {
            System.out.println("ascending");
        } else if (descCount == 8) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}