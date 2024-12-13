import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        // 5 5 5 1 1 1 1 2 1
        // 양쪽에서 더 남은 갯수가 작은 것부터 빼는 그리디 => fail
        // N 은 최대 200,000 이므로 완탐 시간 초과
        // 입력된 수열에서 (과일 종류가 2개 이하인) 가장 긴 연속된 부분 수열 찾기
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] tanghuru = new int[N];
        for (int i = 0; i < N; i++) {
            tanghuru[i] = Integer.parseInt(st.nextToken());
        }
        
        int start = 0;
        int end = 0;
        int[] numOfFruits = new int[10];
        numOfFruits[tanghuru[start]]++;
        int types = 1;
        
        int answer = 1;
        while (start < N && end < N) {
            if (types <= 2) {
                answer = Math.max(answer, end - start + 1);
                
                end++;
                if (end >= N) break;
                
                if (numOfFruits[tanghuru[end]] == 0) {
                    types++;
                }
                numOfFruits[tanghuru[end]]++;
            } else {
                numOfFruits[tanghuru[start]]--;
                if (numOfFruits[tanghuru[start]] == 0) {
                    types--;
                }
                
                start++;
            }
        }
        
        System.out.println(answer);
    }
    
}