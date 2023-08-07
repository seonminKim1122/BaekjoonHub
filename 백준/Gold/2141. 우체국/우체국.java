import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Town> towns = new ArrayList<>();

        StringTokenizer st;
        long totalPopulation = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Town town = new Town(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            totalPopulation += town.population;
            towns.add(town);
        }

        towns.sort((t1, t2) -> t1.location - t2.location);

        long median = (totalPopulation + 1) / 2;
        int result = 0;
        long temp = 0;
        for (int i = 0; i < N; i++) {
            temp += towns.get(i).population;
            if (temp >= median) {
                result = towns.get(i).location;
                break;
            }
        }

        System.out.println(result);
    }
}

class Town {
    int location;
    int population;
    
    Town (int location, int population) {
        this.location = location;
        this.population = population;
    }
}