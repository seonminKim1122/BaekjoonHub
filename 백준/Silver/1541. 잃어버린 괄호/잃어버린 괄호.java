import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String temp ="";
        int result = 0;
        int outOfParenthesis =1;

        String[] formula = br.readLine().split(""); // ex [1 0 + 1 0 + 1 0]


        for (int i = 0; i < formula.length ; i++) {

            if(!formula[i].equals("+") && !formula[i].equals("-")){

                temp += formula[i]; //10

            }else {

                result += Integer.parseInt(temp) * outOfParenthesis;
                temp="";
                if(formula[i].equals("-")){
                    outOfParenthesis = -1;
                }
            }

        }
        result += Integer.parseInt(temp) * outOfParenthesis;
        System.out.println(result);
    }
}