import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K =  Integer.parseInt(st.nextToken());

        int[] tastes = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tastes[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tastes);
        long taste = 0;
        int l = 0;
        int r = N - 1;

        // 첫 잔
        taste += tastes[r];
        r--;

        int count = 1;
        if (count == K) {
            System.out.println(taste);
            return;
        }

        while (count + 2 <= K && l <= r) {
            taste += (tastes[r] - tastes[l]);
            r--;
            l++;
            count += 2;
        }

        System.out.println(taste);
    }
}