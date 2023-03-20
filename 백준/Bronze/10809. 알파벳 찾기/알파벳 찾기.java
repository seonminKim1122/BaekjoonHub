import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String S = br.readLine();


        for (int i = 0; i < 26; i++) {
            String c = String.valueOf((char) (97+i));
            if (S.contains(c)) {
                sb.append(S.indexOf(c)).append(" ");
            } else {
                sb.append(-1).append(" ");
            }
        }

        System.out.println(sb);
    }
}