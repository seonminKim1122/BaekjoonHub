import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 배열 A 에 숫자 N 이 있다 없다를 나타내는 boolean 배열
        // isExist[N] -> N이 있는지 여부 배열의 크기가 2^32 메모리 낭비
        // HashSet 이용해서 해결!
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Set<Integer> numberSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            numberSet.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            if (numberSet.contains(Integer.parseInt(st.nextToken()))) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

    }

}