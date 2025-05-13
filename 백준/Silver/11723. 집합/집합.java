import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        MySet set = new MySet();
        StringBuilder answer = new StringBuilder();
        while (M > 0) {
            M--;

            String[] order = br.readLine().split(" ");

            String operation = order[0];
            int x = -1;
            if (order.length >= 2) {
                x = Integer.parseInt(order[1]);
            }
            switch (operation) {
                case "add":
                    set.add(x);
                    break;
                case "remove":
                    set.remove(x);
                    break;
                case "check":
                    answer.append(set.check(x));
                    answer.append("\n");
                    break;
                case "toggle":
                    set.toggle(x);
                    break;
                case "all":
                    set.all();
                    break;
                default:
                    set.empty();
            }
        }

        System.out.println(answer);
    }

    static class MySet {
        Set<Integer> set = new HashSet<>();

        MySet(){}

        void add(int x) {
            set.add(x);
        }

        void remove(int x) {
            set.remove(x);
        }

        int check(int x) {
            return set.contains(x) ? 1 : 0;
        }

        void toggle(int x) {
            if (!set.contains(x)) {
                set.add(x);
            } else {
                set.remove(x);
            }
        }

        void all() {
            empty();
            for (int i = 1; i <= 20; i++) {
                set.add(i);
            }
        }

        void empty() {
            set.clear();
        }
    }
}