import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        String L = inputs[1];
        int F = Integer.parseInt(inputs[2]);

        long limit = 0;
        String tempDays = L.split("/")[0];
        String tempHour = L.split("/")[1].split(":")[0];
        String tempMinute = L.split(":")[1];

        int days = Integer.parseInt(tempDays);
        int hour = Integer.parseInt(tempHour);
        int minute = Integer.parseInt(tempMinute);

        limit = minute + hour * 60L + (days * 24L * 60L);

        Map<Rent, String> rentalHistory = new HashMap<>();
        Map<String, Long> fines = new HashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");

            String datetime = temp[0] + " " + temp[1];
            String item = temp[2];
            String person = temp[3];

            Rent rent = new Rent(person, item);

            if (rentalHistory.containsKey(rent)) {
                // 벌금 계산
                LocalDateTime start = LocalDateTime.parse(rentalHistory.get(rent), formatter);
                LocalDateTime end = LocalDateTime.parse(datetime, formatter);

                long between = ChronoUnit.MINUTES.between(start, end);

                long fine = (between - limit) * F;
                // 벌금 합산
                if (fine > 0) {
                    fines.put(person, fines.getOrDefault(person, 0L) + fine);
                }
                rentalHistory.remove(rent);
            } else {
                rentalHistory.put(rent, datetime);
            }
        }

        StringBuilder sb = new StringBuilder();
        if (fines.isEmpty()) {
            sb.append(-1).append("\n");
        } else {
            List<String> keys = new ArrayList<>(fines.keySet());
            keys.sort(String::compareTo);

            for (String key : keys) {
                sb.append(key).append(" ").append(fines.get(key)).append("\n");
            }
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}

class Rent {
    String person;
    String item;

    Rent(String person, String item) {
        this.person = person;
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rent)) return false;
        Rent rent = (Rent) o;
        return this.person.equals(rent.person) && this.item.equals(rent.item);
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        for (char c : person.toCharArray()) {
            hashCode += c;
        }
        for (char c : item.toCharArray()) {
            hashCode += c;
        }
        return hashCode;
    }
}