import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine();

        int count = 0;
        for (String word : words.split(" ")){
            if(word.isEmpty()) {
                continue;
            }else{
                count++;
            }
        }

        System.out.println(count);

    }

}