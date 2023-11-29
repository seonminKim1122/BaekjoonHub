import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<RoomNumber> roomNumbers = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int minPrice = 51;
        int minNumber = -1;
        for (int number = 0; number < N; number++) {
            int price = Integer.parseInt(st.nextToken());
            roomNumbers.add(new RoomNumber(price, number));
            if (price <= minPrice) {
                minPrice = price;
                minNumber = number;
            }
        }
        Collections.sort(roomNumbers);

        int M = Integer.parseInt(br.readLine());

        int len = M / minPrice;
        int remain = M % minPrice;

        int[] result = new int[len];
        Arrays.fill(result, minNumber);

        int start = 0;
        for (int i = 0; i < len; i++) {

            for (int j = N - 1; j >= 0; j--) {
                RoomNumber roomNumber = roomNumbers.get(j);

                if (roomNumber.price <= remain + minPrice) {
                    result[i] = roomNumber.number;
                    remain += (minPrice - roomNumber.price);
                    break;
                }
            }

            if (result[start] == 0) {
                start++;
                remain += minPrice;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = start; i < len; i++) {
            answer.append(result[i]);
        }

        System.out.println(answer.length() == 0 ? 0 : answer);
    }

    private static class RoomNumber implements Comparable<RoomNumber> {
        int price;
        int number;

        RoomNumber(int price, int number) {
            this.price = price;
            this.number = number;
        }

        @Override
        public int compareTo(RoomNumber o) {
                return this.number - o.number;
        }
    }
}