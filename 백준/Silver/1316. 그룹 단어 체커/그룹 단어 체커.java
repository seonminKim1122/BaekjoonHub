import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < N; i++) { // N개의 테스트케이스
            String word = br.readLine();
            boolean isGroupWord = true;

            for (int j = 0; j < word.length(); j++) {
                int start = word.indexOf(word.charAt(j));
                int end = word.lastIndexOf(word.charAt(j));

                if (start != end) {
                    for (int k = start+1; k < end; k++) {
                        if (word.charAt(start) != word.charAt(k)) {
                            isGroupWord = false;
                            break;
                        }
                    }
                }
            }

            if (isGroupWord) {
                result++;
            }
        }

        System.out.println(result);
    }
}