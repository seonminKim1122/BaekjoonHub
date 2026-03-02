import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Subject> subjects = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            int[] t = new int[k];
            for (int j = 0; j < k; j++) {
                t[j] = Integer.parseInt(st.nextToken());
            }

            subjects.add(new Subject(k, t));
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            Set<Integer> timeSet = new HashSet<>();
            for (int j = 0; j < p; j++) {
                timeSet.add(Integer.parseInt(st.nextToken()));
            }

            int result = 0;
            for (Subject subject: subjects) {
                int[] t = subject.t;
                boolean canTake = true;
                for (int j = 0; j < subject.k; j++) {
                    if (!timeSet.contains(t[j])) {
                        canTake = false;
                        break;
                    }
                }

                if (canTake) result++;
            }

            answer.append(result).append("\n");
        }

        System.out.println(answer);
    }

    static class Subject {
        int[] t;
        int k;

        public Subject(int k, int[] t) {
            this.k = k;
            this.t = t;
        }
    }
}