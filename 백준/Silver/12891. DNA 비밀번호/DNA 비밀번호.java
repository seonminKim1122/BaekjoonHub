import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
public class Main
{

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int str_len = Integer.parseInt(st.nextToken()); // DNA 문자열 길이
        int password_len = Integer.parseInt(st.nextToken()); // 비밀번호로 사용할 부분 문자열 길이
        
        String input = br.readLine(); // DNA 문자열
        
        char[] arr = new char[str_len]; // DNA 문자열 각 자리가 담긴 배열
        for (int i = 0; i < str_len; i++)
        {
            arr[i] = input.charAt(i);
        }
        
        st = new StringTokenizer(br.readLine());

        int A_count = Integer.parseInt(st.nextToken());
        int C_count = Integer.parseInt(st.nextToken());
        int G_count = Integer.parseInt(st.nextToken());
        int T_count = Integer.parseInt(st.nextToken());



        HashMap<Character, Integer> counts = new HashMap<>();
        counts.put('A', 0);
        counts.put('C', 0);
        counts.put('G', 0);
        counts.put('T', 0);

        int result = 0;
        String password = input.substring(0, password_len);
        for (int i = 0; i < password_len; i++) {
            counts.put(password.charAt(i), counts.get(password.charAt(i)) + 1);
        }
        if (isValid(counts, A_count, C_count, G_count, T_count)) result++;

        int ex = str_len - password_len + 1;
        for (int j = 1; j < ex; j++)
        {
            char sub = input.charAt(j - 1);
            char add = input.charAt(j + password_len - 1);
            counts.put(sub, counts.get(sub) - 1);
            counts.put(add, counts.get(add) + 1);

            if (isValid(counts, A_count, C_count, G_count, T_count)) result++;
        }

        System.out.println(result);
    }

    public static boolean isValid(HashMap<Character, Integer> counts, int a, int c, int g, int t) { // 매번 다시 계산
        return counts.get('A') >= a && counts.get('C') >= c && counts.get('G') >= g && counts.get('T') >= t;
    }
}
