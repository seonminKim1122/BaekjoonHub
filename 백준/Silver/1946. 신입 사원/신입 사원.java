import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); // 지원자 수

            List<Applicant> applicants = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int paper = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());

                Applicant applicant = new Applicant(paper, interview);
                applicants.add(applicant);
            }

            applicants.sort((a1, a2) -> a1.paper - a2.paper);

            int cnt = 1;
            int interview = applicants.get(0).interview;

            for (int j = 1; j < applicants.size(); j++) {
                Applicant now = applicants.get(j);
                if (now.interview < interview) {
                    cnt++;
                    interview = now.interview;
                }
            }

            result.append(cnt).append("\n");
        }

        System.out.println(result);
    }
}

class Applicant {
    int paper;
    int interview;

    Applicant(int paper, int interview) {
        this.paper = paper;
        this.interview = interview;
    }
}