import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] S1 = {"a", "e", "i", "o", "u", "h"};
        String[] S2 = {"c", "j", "n", "m", "t", "s", "l", "d", "qu"};

        Set<String> set1 = new HashSet<>(Arrays.asList("a", "e", "i", "o", "u", "h"));
        Set<String> set2 = new HashSet<>(Arrays.asList("c", "j", "n", "m", "t", "s", "l", "d", "qu"));

        String[] S = s.split("");
        int answer = 1;
        for (int i = 0; i < S.length; i++) {
            if (S[i].equals(" ") || S[i].equals("-")) {
                answer++;
                continue;
            }

            if (S[i].equals("'")) {
                if(set1.contains(S[i+1])) {
                    // 앞 단어 확인
                    if (set2.contains(S[i-1])) {
                        if (i < 2){
                            answer++;
                        } else {
                            if(S[i-2].equals("-") || S[i-2].equals(" ")) {
                                answer++;
                            }
                        }
                    } else if (i>=2){
                        if (set2.contains(S[i-2]+S[i-1])) {
                            if (i < 3) {
                                answer++;
                            } else {
                                if (S[i-3].equals("-") || S[i-3].equals(" ")) {
                                    answer++;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}