import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<Integer, TreeSet<QuestionV2>> questionsByAlgorithm = new HashMap<>();
        TreeSet<QuestionV2> questions = new TreeSet<>();
        Map<Integer, Integer> difficultyMap = new HashMap<>();
        Map<Integer, Integer> algorithmMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(st.nextToken());
            int difficulty = Integer.parseInt(st.nextToken());
            int algorithm = Integer.parseInt(st.nextToken());

            QuestionV2 question = new QuestionV2(number, difficulty);
            questions.add(question);
            if (!questionsByAlgorithm.containsKey(algorithm)) {
                questionsByAlgorithm.put(algorithm, new TreeSet<>());
            }
            questionsByAlgorithm.get(algorithm).add(question);
            difficultyMap.put(number, difficulty);
            algorithmMap.put(number, algorithm);
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String order = st.nextToken();

            switch (order) {
                case "recommend":
                    int G = Integer.parseInt(st.nextToken());
                    int x = Integer.parseInt(st.nextToken());

                    if (x == 1) {
                        sb.append(questionsByAlgorithm.get(G).last().number).append("\n");
                    } else {
                        sb.append(questionsByAlgorithm.get(G).first().number).append("\n");
                    }

                    break;
                case "recommend2":
                    int x2 = Integer.parseInt(st.nextToken());
                    if (x2 == 1) {
                        sb.append(questions.last().number).append("\n");
                    } else {
                        sb.append(questions.first().number).append("\n");
                    }
                    break;
                case "recommend3":
                    int x3 = Integer.parseInt(st.nextToken());
                    int L = Integer.parseInt(st.nextToken());

                    if (x3 == 1) {
                        SortedSet<QuestionV2> subset = questions.tailSet(new QuestionV2(0, L));
                        if (subset.isEmpty()) {
                            sb.append(-1).append("\n");
                        } else {
                            sb.append(subset.first().number).append("\n");
                        }
                    } else {
                        SortedSet<QuestionV2> subset = questions.headSet(new QuestionV2(0, L));
                        if (subset.isEmpty()) {
                            sb.append(-1).append("\n");
                        } else {
                            sb.append(subset.last().number).append("\n");
                        }
                    }

                    break;
                case "add":
                    int number = Integer.parseInt(st.nextToken());
                    int difficulty = Integer.parseInt(st.nextToken());
                    int algorithm = Integer.parseInt(st.nextToken());

                    QuestionV2 question = new QuestionV2(number, difficulty);
                    questions.add(question);
                    if (!questionsByAlgorithm.containsKey(algorithm)) {
                        questionsByAlgorithm.put(algorithm, new TreeSet<>());
                    }
                    questionsByAlgorithm.get(algorithm).add(question);
                    difficultyMap.put(number, difficulty);
                    algorithmMap.put(number, algorithm);

                    break;
                case "solved":
                    int P = Integer.parseInt(st.nextToken());
                    QuestionV2 q = new QuestionV2(P, difficultyMap.get(P));
                    questionsByAlgorithm.get(algorithmMap.get(P)).remove(q);
                    questions.remove(q);
                    difficultyMap.remove(P);
                    algorithmMap.remove(P);
                    break;
            }
        }

        System.out.println(sb);
    }
}

class QuestionV2 implements Comparable<QuestionV2> {
    int number;
    int difficulty;

    QuestionV2(int number, int difficulty) {
        this.number = number;
        this.difficulty = difficulty;
    }

    @Override
    public int compareTo(QuestionV2 o) {
        if (this.difficulty == o.difficulty) {
            return this.number - o.number;
        } else {
            return this.difficulty - o.difficulty;
        }
    }
}