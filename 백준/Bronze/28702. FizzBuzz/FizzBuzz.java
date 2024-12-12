import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        boolean[] isMultipleOfThree = new boolean[3];
        boolean[] isMultipleOfFive = new boolean[3];
        
        int target = 0;
        for (int i = 0; i < 3; i++) {
            String sequence = br.readLine();
            
            switch (sequence) {
                case "FizzBuzz":
                    isMultipleOfThree[i] = true;
                    isMultipleOfFive[i] = true;
                    break;
                case "Fizz":
                    isMultipleOfThree[i] = true;
                    break;
                case "Buzz":
                    isMultipleOfFive[i] = true;
                    break;
                default:
                    target = Integer.parseInt(sequence) - i;
            }
        }
        
        if (target == 0) {
            target++;
            while (!isAnswer(target, isMultipleOfThree, isMultipleOfFive)) {
                target++;
            }
        }
        
        // 연속된 세 개의 문자열 다음
        target += 3;
        
        if (target % 3 == 0 && target % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (target % 3 == 0 && target % 5 != 0) {
            System.out.println("Fizz");
        } else if (target % 3 != 0 && target % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(target);
        }
    }
    
    public static boolean isAnswer(int i, boolean[] isMultipleOfThree, boolean[] isMultipleOfFive) {
        for (int k = 0; k < 3; k++) {
            if (((i + k) % 3 == 0) != isMultipleOfThree[k]) return false;
            if (((i + k) % 5 == 0) != isMultipleOfFive[k]) return false;
        }
        return true;
    }
}