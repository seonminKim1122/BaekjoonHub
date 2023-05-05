import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String[] S = br.readLine().split(" ");
            if (S[1].equals("enter")) {
                set.add(S[0]);
            } else {
                set.remove(S[0]);
            }
        }

        List<String> names = set.stream().sorted((s1, s2) -> s2.compareTo(s1)).collect(Collectors.toList());
        for(String name : names) {
            System.out.println(name);
        }
    }
}