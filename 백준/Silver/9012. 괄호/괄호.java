import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            Stack<String> stack = new Stack<>();
            String ps = br.readLine();
            String ans = "YES";

            for(String s : ps.split("")) {
                if (s.equals("(")) {
                    stack.push(s);
                } else { // ) 가 들어오면
                    if (stack.isEmpty()) {
                        ans = "NO";
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (!stack.isEmpty()) {
                ans = "NO";
            }
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}