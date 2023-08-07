import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

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
        int[] boxes = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cranes);
        Arrays.sort(boxes);

        int craneIdx = N-1;
        int boxIdx = M-1;
        int moved = 0;
        int minute = 0;
        boolean[] isMoved = new boolean[M];
        
        if (cranes[craneIdx] < boxes[boxIdx]) {
            System.out.println(-1);
            return;
        }

        while (moved < M) {
            if (craneIdx < 0 || boxIdx < 0) {
                craneIdx = N-1;
                boxIdx = M-1;
                minute++;
                continue;
            }

            if (isMoved[boxIdx]) {
                boxIdx--;
                continue;
            }

            if (cranes[craneIdx] >= boxes[boxIdx]) {
                isMoved[boxIdx] = true;
                craneIdx--;
                boxIdx--;
                moved++;
            } else {
                boxIdx--;
            }
        }

        System.out.println(minute + 1);
    }
}