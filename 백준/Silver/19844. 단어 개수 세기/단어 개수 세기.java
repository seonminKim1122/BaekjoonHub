import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] frontWord = {"c", "j", "n", "m", "t", "s", "l", "d", "qu"};
        String[] backWord = {"a", "e", "i", "o", "u", "h"};

        int answer = 0;

        String sentence = br.readLine();

        // 띄어쓰기와 하이픈으로 분리
        String[] strList = sentence.split("[\\s-]");
        answer += strList.length;

        // 단어에 frontWord 에 해당하는 것이 들어있다면 ? ' 기준으로 나눈다
        for (String s : strList) {
            for (String front : frontWord) {
                if (s.startsWith(front+"'")) {
                    String[] str = s.split("'");
                    for (String back : backWord) {
                        if (str[1].startsWith(back)) {
                            answer += 1;
                            continue;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}