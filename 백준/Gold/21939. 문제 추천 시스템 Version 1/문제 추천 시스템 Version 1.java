import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main { // 시간 초과(정렬하는 부분에서 뭔가 문제가 있을까?, 아니면 last 값을 조회하는 게 O(N)이라서?)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        TreeSet<Question> questions = new TreeSet<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");

            int number = Integer.parseInt(inputs[0]);
            int difficulty = Integer.parseInt(inputs[1]);

            Question question = new Question(number, difficulty);
            questions.add(question);
            map.put(number, difficulty);
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String[] inputs = br.readLine().split(" ");

            switch (inputs[0]) {
                case "recommend":
                    if (inputs[1].equals("1")) {
                        sb.append(questions.last().number).append("\n");
                    } else {
                        sb.append(questions.first().number).append("\n");
                    }
                    break;

                case "add":
                    int number = Integer.parseInt(inputs[1]);
                    int difficulty = Integer.parseInt(inputs[2]);
                    Question question = new Question(number, difficulty);

                    questions.add(question);
                    map.put(number, difficulty);
                    break;
                    /*
                    추천 문제 리스트에 없는 문제 번호 P만 입력으로 주어진다. 이전에 추천 문제 리스트에 있던 문제 번호가 다른 난이도로 다시 들어 올 수 있다.
                    추가 -> 삭제 -> 다른 난이도로 재추가 될 수 있다는 것을 의미
                    안 푼 문제 리스트에 동일한 번호의 문제가 동시에 여러 개 존재는 X!!
                     */
                case "solved":
                    int num = Integer.parseInt(inputs[1]);
                    Question q = new Question(num, map.get(num));
                    questions.remove(q);
                    break;
            }
        }

        System.out.println(sb);
    }
}

class Question implements Comparable<Question> {
    int number;
    int difficulty;

    Question(int number, int difficulty) {
        this.number = number;
        this.difficulty = difficulty;
    }

    @Override
    public int compareTo(Question o) {
        if (this.difficulty == o.difficulty) {
            return this.number - o.number;
        } else {
            return this.difficulty - o.difficulty;
        }
    }
}