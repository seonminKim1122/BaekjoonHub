import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
    다솜이의 방번호에 각 숫자의 갯수 계산
    - 6이랑 9는 하나로 간주해서 갯수 계산 후 / 2

    count = [0 0 0 0 0 0 0 0 0]
    count[0] = 0이 나온 횟수
    count[1] = 1이 나온 횟수

     */
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        int[] unit= new int[10];
        String[] result = new String[N.length()]; // {'9', '9', '9', '9'}
        result = N.split("");

        for (int i = 0; i < result.length; i++) {
            int number = Integer.parseInt(result[i]);
            if(number == 6 || number == 9){
                unit[6]++;
                continue;
            }
            unit[number]++;
        }
        
        if(unit[6]%2 != 0){
          unit[6]=  unit[6]/2+1;
        }else {
           unit[6]= unit[6]/2;
        }

        int max = 0;

        for (int i = 0; i < unit.length; i++) {
            if(max < unit[i]){
                max = unit[i];
            }
        }
        /*
         */
        System.out.println(max);





    }
}