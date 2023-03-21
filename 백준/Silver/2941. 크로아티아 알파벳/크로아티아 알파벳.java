import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        String[] croatians = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        int result = 0;
        for (int i = 0; i < 8; i++) {
            String croatian = croatians[i];
            int idx = S.indexOf(croatian);
            while (idx != -1) {
                result++;
                S = S.substring(0,idx) + "/" +S.substring(idx+croatian.length(),S.length());
                idx = S.indexOf(croatian);
            }
        }
        result = result + S.replace("/", "").length();
        System.out.println(result);
    }
}