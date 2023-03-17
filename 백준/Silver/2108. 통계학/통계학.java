import java.util.*;
import java.io.*;

public class Main {
    /*
    1. 산술평균 : 1차원 배열에 값 담기(담을 때 바로 합 계산해서 평균 계산)
    2. 중앙값 : 배열 정렬한 후 배열의 길이/2 index에 위치한 값
    3. 최빈값
     - 중복된 값이 없는 배열 하나 만들기(정렬된 배열 순회하면서 이전과 같은 값이면 넘어가고 아니면 배열에 담음)
     - counting 배열 선언
     - 중복된 값이 없는 배열과, 원래 배열을 순회하면서 각각의 값이 몇 번 나오는지 카운팅해서 counting 배열에 추가
     - counting 배열의 max값과 일치하는 index를 찾고, 중복된 값이 없는 배열에서 해당 index의 값들을 가져옴
     - 여러 개면 그 중에 2번째로 작은 값 출력

     아니면 중복된 배열은 만들지 말고, counting배열을 2차원으로 만들어서 1차원에는 value, 2차원에는 count가 들어가게 해도 될 것 같아요.
     index번호가 곧 value가 되게 그렇게 해도 돼요.
    4. 범위 : 정렬된 배열의 마지막 값 - 첫 번째 값
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        double sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        //산술평균
        bw.write((int) Math.round(sum / n) + "\n");

        Arrays.sort(arr);

        //중앙값
        bw.write(arr[n / 2] + "\n");

        //최빈값 - 카운팅 정렬
        int[] count = new int[8001]; // -4000 ~ 4000
        int maxCount = 0;

        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] + 4000; //7이 4007
            count[index]++;
            maxCount = Math.max(count[index], maxCount);
        }

        List<Integer> maxIndex = new ArrayList<>(); //최대빈도수와 같은 빈도수의 요소 리스트
        for (int i = 0; i < count.length; i++) {
            if (maxCount == count[i]) {
                maxIndex.add(i - 4000); //4007 -> 7
            }
        }
        if (maxIndex.size() > 1) {
            bw.write(maxIndex.get(1) + "\n");
        } else {
            bw.write(maxIndex.get(0) + "\n");
        }



        //범위
        int last = arr[n - 1];
        int first = arr[0];
        bw.write(Math.abs(last - first) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}    