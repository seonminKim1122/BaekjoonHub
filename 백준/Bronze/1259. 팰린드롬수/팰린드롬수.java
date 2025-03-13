import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        loop: while (!(input = br.readLine()).equals("0")) {
            int left = 0;
            int right = input.length() - 1;

            while (left <= right) {
                if (input.charAt(left) != input.charAt(right)) {
                    bw.write("no\n");
                    continue loop;
                }
                left++;
                right--;
            }

            bw.write("yes\n");
        }

        bw.flush();
        bw.close();
    }

}
