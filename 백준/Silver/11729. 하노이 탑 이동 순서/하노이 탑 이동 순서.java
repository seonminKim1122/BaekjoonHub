import java.io.*;
public class Main {
    
    static int count = 0;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        hanoi(N, 1, 2, 3);
        
        System.out.println(count);
        System.out.println(sb);
        br.close();
    }

    public static void hanoi(int num, int from, int mid, int to) {
        if (num == 1) {
            sb.append(from + " " + to + "\n");
            count++;
            return;
        }

        hanoi(num-1, from, to, mid);
        sb.append(from + " " + to + "\n");
        count++;
        hanoi(num-1, mid, from, to);
    }
}