import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int result = Integer.MAX_VALUE;
    static int[][] synergies;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        synergies = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                synergies[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] visited = new boolean[N];
        dfs(0, visited);

        System.out.println(result);
    }

    public static void dfs(int depth, boolean[] visited) {
        // visited = true -> startTeam, false -> linkTeam
        if (depth == N) {
            calcDiffBetweenTeams(visited);
            return;
        }

        visited[depth] = true;
        dfs(depth + 1, visited);

        visited[depth] = false;
        dfs(depth + 1, visited);
    }
    public static void calcDiffBetweenTeams(boolean[] visited) {
        List<Integer> startTeam = new ArrayList<>();
        List<Integer> linkTeam = new ArrayList<>();

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                startTeam.add(i);
            } else {
                linkTeam.add(i);
            }
        }

        int abilityOfStartTeam = calcTeamAbility(startTeam);
        int abilityOfLinkTeam = calcTeamAbility(linkTeam);

        updateResult(Math.abs(abilityOfStartTeam - abilityOfLinkTeam));
    }

    public static int calcTeamAbility(List<Integer> team) {
        int len = team.size();

        int ability = 0;
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                int member1 = team.get(i);
                int member2 = team.get(j);

                ability += synergies[member1][member2];
                ability += synergies[member2][member1];
            }
        }

        return ability;
    }

    public static void updateResult(int diff) {
        if (result > diff) {
            result = diff;
        }
    }
}