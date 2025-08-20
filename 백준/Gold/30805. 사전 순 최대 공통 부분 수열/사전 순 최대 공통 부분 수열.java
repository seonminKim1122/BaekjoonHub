import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<int[]> arr1 = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            arr1.add(new int[]{number, i});
        }

        int M = Integer.parseInt(br.readLine());
        List<int[]> arr2 = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(st.nextToken());
            arr2.add(new int[]{number, i});
        }

        // 값이 큰 순, 인덱스 빠른 순
        arr1.sort((i1, i2) -> (i1[0] - i2[0] == 0 ? i1[1] - i2[1] : i2[0] - i1[0]));
        arr2.sort((i1, i2) -> (i1[0] - i2[0] == 0 ? i1[1] - i2[1] : i2[0] - i1[0]));

        int i = 0;
        int j = 0;
        int beforeI = -1;
        int beforeJ = -1;
        int cnt = 0;
        StringBuilder answer = new StringBuilder();
        while (i < N && j < M) {
            int num1 = arr1.get(i)[0];
            int index1 = arr1.get(i)[1];

            int num2 = arr2.get(j)[0];
            int index2 = arr2.get(j)[1];

            if (num1 > num2) {
                i++;
            } else if (num1 < num2) {
                j++;
            } else {
                if (beforeI > index1 && beforeJ > index2) {
                    i++;
                    j++;
                } else if (beforeI > index1) {
                    i++;
                } else if (beforeJ > index2) {
                    j++;
                } else {
                    answer.append(num1).append(" ");
                    cnt++;
                    beforeI = index1;
                    beforeJ = index2;

                    i++;
                    j++;
                }
            }
        }

        System.out.println(cnt);
        if (cnt > 0) {
            System.out.println(answer);
        }
    }
}