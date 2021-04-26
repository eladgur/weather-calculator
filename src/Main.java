import java.util.*;

public class Main {

    public static void main(String[] args) {
        WeatherAPI weatherAPI = new WeatherAPIMock();
        AggregationStrategy aggregationStrategy = new MaxAggregationStrategy();
        WeatherCalculator weatherCalculator = new WeatherCalculator(weatherAPI, aggregationStrategy);
        Set<String> cityIds = new HashSet<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7"));
        Set<CityDetails> topCities = weatherCalculator.getTopCities(cityIds, 3);
        System.out.println(topCities);
    }
}
