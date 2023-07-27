import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main { // 시간 초과(정렬하는 부분에서 뭔가 문제가 있을까?, 아니면 last 값을 조회하는 게 O(N)이라서?)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        TreeSet<Question> questions = new TreeSet<>(new Comparator<Question>() {
            @Override
            public int compare(Question q1, Question q2) {
                if (q1.difficulty == q2.difficulty) {
                    return q1.number - q2.number;
                } else {
                    return q1.difficulty - q2.difficulty;
                }
            }
        });

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

                case "solved":
                    // Question => number, difficulty 로 구성... number 만 가지고 어캐 찾지
                    int num = Integer.parseInt(inputs[1]);
                    Question q = new Question(num, map.get(num));
                    questions.remove(q);
                    break;
            }
        }

        System.out.println(sb);
    }
}

class Question {
    int number;
    int difficulty;

    Question(int number, int difficulty) {
        this.number = number;
        this.difficulty = difficulty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        Question q = (Question) o;
        return this.number == q.number;
    }

    @Override
    public int hashCode() {
        return this.number + this.difficulty;
    }
}