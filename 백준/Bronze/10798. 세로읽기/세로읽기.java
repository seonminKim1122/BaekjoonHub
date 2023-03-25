import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] arr = new String[5][15];
        for (int i = 0; i < 5; i++) {
            String[] word = br.readLine().split("");
            for (int j = 0; j < word.length; j++) {
                arr[i][j] = word[j];
            }
        }

        String result = "";
        for (int j = 0; j < 15; j++) {
            for (int i = 0; i < 5; i++) {
                if (arr[i][j] != null) {
                    result += arr[i][j];
                }
            }
        }

        System.out.println(result);
    }
}