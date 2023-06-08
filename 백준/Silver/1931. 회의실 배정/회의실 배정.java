import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /*
    회의 종료 시간이 빠른 순으로 회의실 사용하면 최대로 사용할 수 있음
    시작과 동시에 종료 가능한 회의가 존재하기에 시작 시간 순 정렬도 필요
    ex)
    10 10
    7 10
    => 정답 2
    => 종료 시간 기준으로만 정렬 시 : 1
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] meetings = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meetings[i][0] = start;
            meetings[i][1] = end;
        }

        Arrays.sort(meetings, (meeting1, meeting2) -> {
            return meeting1[1] - meeting2[1] != 0 ? meeting1[1] - meeting2[1] : meeting1[0] - meeting2[0];
        });

        int result = 1;
        int doneIdx = 0;
        for (int i = 1; i < N; i++) {
            if (meetings[i][0] >= meetings[doneIdx][1]) {
                result++;
                doneIdx = i;
            }
        }
        System.out.println(result);
    }
}