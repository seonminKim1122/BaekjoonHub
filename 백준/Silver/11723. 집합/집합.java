import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        Set<Integer> S = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String[] orders = br.readLine().split(" ");
            int x = 0;
            if (orders.length > 1) {
                x = Integer.parseInt(orders[1]);
            }

            switch (orders[0]) {
                case "add":
                    S.add(x);
                    break;
                case "remove":
                    S.remove(x);
                    break;
                case "toggle":
                    if (S.contains(x)) {
                        S.remove(x);
                    } else {
                        S.add(x);
                    }
                    break;
                case "all":
                    S.clear();
                    for (int j = 1; j <= 20; j++) {
                        S.add(j);
                    }
                    break;
                case "empty":
                    S.clear();
                    break;
                default:
                    if (S.contains(x)) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
            }
        }
        System.out.println(sb);
    }
}