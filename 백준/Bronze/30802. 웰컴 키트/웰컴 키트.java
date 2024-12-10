import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] shirts = new int[6];
        for (int i = 0; i < 6; i++) {
            shirts[i]= Integer.parseInt(st.nextToken()); 
        }
        
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        // 티셔츠 T장씩 최소 몇 묶음 주문해야하는지 계산
        int ans1 = 0;
        for (int i = 0; i < 6; i++) {
            if (shirts[i] == 0) continue;
            ans1 += (shirts[i] - 1) / T + 1;
        }
        
        System.out.println(ans1);
        
        // 펜을 P자루씩 최대 몇 묶음 주문할 수 있는지, 그 때 펜 한자루 몇 개 주문하는지
        System.out.println(N / P + " " + N % P);
    }
}