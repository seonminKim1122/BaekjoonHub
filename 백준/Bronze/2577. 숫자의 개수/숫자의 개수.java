import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 1;
        for (int i = 0; i < 3; i++) {
            result *= Integer.parseInt(br.readLine());
        }

        String[] nums = String.valueOf(result).split("");
        int size = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < size; i++) {
            int num = Integer.parseInt(nums[i]);
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for (int i = 0; i <= 9; i++) {
            System.out.println(map.getOrDefault(i, 0));
        }
    }
}