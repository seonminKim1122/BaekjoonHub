import java.io.*;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String sequence;

        Stack<Character> answer = new Stack<>();
        Stack<Character> temp = new Stack<>();

        for (int i = 0; i < N; i++) {
            sequence = br.readLine();
            for(char c : sequence.toCharArray()) {
                if (c == '-') {
                    if (!answer.isEmpty()) {
                        answer.pop();
                    }
                } else if (c == '<') {
                    if (!answer.isEmpty()) {
                        temp.push(answer.pop());
                    }
                } else if (c == '>') {
                    if (!temp.isEmpty()) {
                        answer.push(temp.pop());
                    }
                } else {
                    answer.push(c);
                }
            }

            while(!temp.isEmpty()) {
                answer.push(temp.pop());
            }

            for (char c : answer) {
                bw.write(c);
            }
            bw.write("\n");
            answer.clear();
            temp.clear();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}