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

            switch (orders[0]) {
                case "add":
                    S.add(Integer.parseInt(orders[1]));
                    break;
                case "remove":
                    S.remove(Integer.parseInt(orders[1]));
                    break;
                case "toggle":
                    if (S.contains(Integer.parseInt(orders[1]))) {
                        S.remove(Integer.parseInt(orders[1]));
                    } else {
                        S.add(Integer.parseInt(orders[1]));
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
                    if (S.contains(Integer.parseInt(orders[1]))) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
            }
        }
        System.out.println(sb);
    }
}