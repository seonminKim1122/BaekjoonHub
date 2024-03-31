import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());
        int l = 1;
        int r = G;

        List<Integer> answers = new ArrayList<>();
        while (l < r) {
            if (l * r == G) {
                l++;
                r--;

                if ((l + r) % 2 == 0) {
                    answers.add((l + r) / 2);
                }
            } else if (l * r < G) {
                l++;
            } else {
                r--;
            }
        }

        if (answers.size() == 0) {
            System.out.println(-1);
        } else {
            Collections.sort(answers);
            for (int i = 0; i < answers.size(); i++) {
                System.out.println(answers.get(i));
            }
        }
    }
}