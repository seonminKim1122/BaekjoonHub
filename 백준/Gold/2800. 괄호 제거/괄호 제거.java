import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String formula = br.readLine();

        Stack<Integer> stack = new Stack<>();
        ArrayList<int[]> parenthesisList = new ArrayList<>();
        for (int i = 0; i < formula.length(); i++) {
            char ch = formula.charAt(i);
            if (ch == '(') {
                stack.add(i);
            } else if (ch == ')') {
                int j = stack.pop();
                parenthesisList.add(new int[]{j, i});
            }
        }

        Set<boolean[]> cases = new HashSet<>();
        int n = parenthesisList.size();
        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n];
            combination(visited, 0, n, i, cases);
        }

        Set<String> resultSet = new HashSet<>();
        for (boolean[] Case : cases) {
            char[] formulaArray = formula.toCharArray();
            for (int i = 0; i < n; i++) {
                if (Case[i]) {
                    int[] target = parenthesisList.get(i);
                    formulaArray[target[0]] = ' ';
                    formulaArray[target[1]] = ' ';
                }
            }
            String result = new String(formulaArray);
            resultSet.add(result.replace(" ", ""));
        }

        List<String> resultList = new ArrayList<>(resultSet);
        resultList.sort(String::compareTo);
        for (String result : resultList) {
            System.out.println(result);
        }


    }

    static void combination(boolean[] visited, int start, int n, int r, Set<boolean[]> cases) {
        if (r == 0) {
            // 그냥 visited 를 집어넣으면 combination 메서드에서 지속적으로 참조하는 원본 visited 값이 들어가므로
            // 가장 상위 그 때 그 때 원하는 visited 가 저장되기 보단 가장 상위 combination 이 끝났을 때 visited 를 참조하게 됌
            cases.add(visited.clone());
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(visited, i+1, n, r-1, cases);
            visited[i] = false;
        }
    }
}