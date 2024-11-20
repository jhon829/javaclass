import java.util.HashMap;
import java.util.Scanner;

class Location {
    String name;
    double latitude, longitude;

    public Location(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return String.format("위도: %.2f, 경도: %.2f", latitude, longitude);
    }
}

public class CitySearchProgram {
    public static void main(String[] args) {
        HashMap<String, Location> cities = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            System.out.println("도시 이름, 위도, 경도를 입력하세요:");
            String name = scanner.next();
            double latitude = scanner.nextDouble();
            double longitude = scanner.nextDouble();
            cities.put(name, new Location(name, latitude, longitude));
        }

        System.out.println("\n저장된 도시 정보:");
        for (String cityName : cities.keySet()) {
            System.out.println(cityName + " - " + cities.get(cityName));
        }

        System.out.println("\n검색할 도시 이름을 입력하세요:");
        String searchCity = scanner.next();
        if (cities.containsKey(searchCity)) {
            System.out.println("검색 결과: " + searchCity + " - " + cities.get(searchCity));
        } else {
            System.out.println("해당 도시를 찾을 수 없습니다.");
        }
    }
}
