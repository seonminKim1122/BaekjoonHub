import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int result = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if ("ABC".contains(String.valueOf(c))) {
                result += 3;
            } else if ("DEF".contains(String.valueOf(c))) {
                result += 4;
            } else if ("GHI".contains(String.valueOf(c))) {
                result += 5;
            } else if ("JKL".contains(String.valueOf(c))) {
                result += 6;
            } else if ("MNO".contains(String.valueOf(c))) {
                result += 7;
            } else if ("PQRS".contains(String.valueOf(c))) {
                result += 8;
            } else if ("TUV".contains(String.valueOf(c))) {
                result += 9;
            } else if ("WXYZ".contains(String.valueOf(c))) {
                result += 10;
            } else {
                result += 0;
            }
        }

        System.out.println(result);
    }
}