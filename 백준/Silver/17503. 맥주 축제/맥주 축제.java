import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Beer> beers = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            String[] input = br.readLine().split(" ");
            int preference = Integer.parseInt(input[0]);
            int proof = Integer.parseInt(input[1]);
            beers.add(new Beer(preference, proof));
        }
        Collections.sort(beers);

        long start = 0;
        long end = N * (long)(Math.pow(2, 31));

        while (start <= end) {
            long levelOfLiver = (start + end) / 2;

            int cnt = 0;
            int sumOfPreference = 0;
            for (int i = 0; i < K; i++) {
                Beer beer = beers.get(i);
                if (beer.proof <= levelOfLiver) {
                    cnt++;
                    sumOfPreference += beer.preference;
                }
                if (cnt >= N) break;
            }

            if (cnt < N) {
                start = levelOfLiver + 1;
                continue;
            }

            if (sumOfPreference < M) {
                start = levelOfLiver + 1;
            } else {
                end = levelOfLiver - 1;
            }
        }

        System.out.println(start > N * (long)(Math.pow(2, 31)) ? -1 : start);
    }

    private static class Beer implements Comparable<Beer> {
        int preference;
        int proof;

        Beer(int preference, int proof) {
            this.proof = proof;
            this.preference = preference;
        }

        @Override
        public int compareTo(Beer o) {
            return o.preference - this.preference;
        }
    }
}