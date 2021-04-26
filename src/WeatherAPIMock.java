import java.util.*;

public class WeatherAPIMock implements WeatherAPI {

    private static final int MAX_TEMPERATURE = 50;
    private static final int DAYS_IN_YEAR = 365;
    private Random random = new Random();
    private int counter = 0;

    @Override
    public Set<City> getAllCitiesByIds(Set<String> ids) {

        HashSet<City> cities = new HashSet<>();

        for (String id : ids) {
            int population = 50000 - 2 + ++counter;
            City city = new City(id, "dummyName", population);
            cities.add(city);
        }

        return cities;
    }

    @Override
    public List<DailyTemp> getLastYearTemperature(String cityId) {
        List<DailyTemp> dailyTemps = new ArrayList<>(DAYS_IN_YEAR);

        for (int i = 0; i < DAYS_IN_YEAR; i++) {
            DailyTemp dailyTemp = new DailyTemp(random.nextInt(MAX_TEMPERATURE));
            dailyTemps.add(dailyTemp);
        }

        return dailyTemps;
    }

}
