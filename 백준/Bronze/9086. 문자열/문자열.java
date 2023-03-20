import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String S = br.readLine();
            String result = String.valueOf(S.charAt(0)) + String.valueOf(S.charAt(S.length()-1));
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}