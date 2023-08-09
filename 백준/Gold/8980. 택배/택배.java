import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());

        List<int[]> parcels = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int[] parcel = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            parcels.add(parcel);
        }

        parcels.sort((o1, o2) -> o1[1] - o2[1]);

        int[] temp = new int[N-1];
        for (int i = 0; i < N-1; i++) {
            temp[i] = C;
        }

        int result = 0;
        for (int i = 0; i < parcels.size(); i++) {
            int[] parcel = parcels.get(i);
            int onTruck = parcel[2];

            for (int j = parcel[0]-1; j < parcel[1]-1; j++) {
                if (temp[j] < onTruck) {
                    onTruck = temp[j];
                }
            }

            for (int j = parcel[0]-1; j < parcel[1]-1; j++) {
                temp[j] -= onTruck;
            }

            result += onTruck;
        }

        System.out.println(result);
    }
}