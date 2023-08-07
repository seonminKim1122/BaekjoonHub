import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] cranes = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cranes[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        List<Integer> boxes = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(cranes);
        boxes.sort(Collections.reverseOrder());


        int minute = 0;
        int crandIdx = N-1;
        int boxIdx = 0;
        
        if (boxes.get(boxIdx) > cranes[crandIdx]) {
            System.out.println(-1);
            return;
        }
        
        while (!boxes.isEmpty()) {
            if (crandIdx < 0 || boxIdx >= boxes.size()) {
                minute++;
                crandIdx = N-1;
                boxIdx = 0;
            }

            if (cranes[crandIdx] >= boxes.get(boxIdx)) {
                crandIdx--;
                boxes.remove(boxIdx);
            } else {
                boxIdx++;
            }
        }

        System.out.println(minute + 1);
    }
}