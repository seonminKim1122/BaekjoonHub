import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int plus;
    static int multiple;

    static int[] numbers;
    static boolean[] chosen;
    static boolean[] isMultiple;

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        chosen = new boolean[N];
        isMultiple = new boolean[N-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        plus = Integer.parseInt(st.nextToken());
        multiple = Integer.parseInt(st.nextToken());

        outComes(0, new ArrayList<>());

        System.out.println(result);
    }

    public static void outComes(int depth, List<Integer> numberList) {
        if (depth == N) {
            dfs(0, 0, numberList);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (chosen[i]) continue;
            chosen[i] = true;
            numberList.add(numbers[i]);
            outComes(depth + 1, numberList);
            chosen[i] = false;
            numberList.remove(numberList.size() - 1);
        }
    }

    public static void dfs(int start, int depth, List<Integer> numberList) {
        if (depth == multiple) {
            int max = 1;
            int temp = numberList.get(0);
            for (int i = 0; i < N-1; i++) {
                if (isMultiple[i]) {
                    max *= temp;
                    temp = numberList.get(i + 1);
                } else {
                    temp += numberList.get(i + 1);
                }
            }
            max *= temp;

            result = Math.max(result, max);
            return;
        }

        for (int i = start; i < N-1; i++) {
            isMultiple[i] = true;
            dfs(i + 1, depth + 1, numberList);
            isMultiple[i] = false;
        }
    }
}