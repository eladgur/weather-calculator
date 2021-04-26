import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class WeatherCalculator {

    private static final int MIN_POPULATION = 50000;
    private WeatherAPI weatherAPI;
    private AggregationStrategy aggregationStrategy;

    WeatherCalculator(WeatherAPI weatherAPI, AggregationStrategy aggregationStrategy) {
        this.weatherAPI = weatherAPI;
        this.aggregationStrategy = aggregationStrategy;
    }

    Set<CityDetails> getTopCities(Set<String> cityIds, int limit) {
        Set<City> cities = weatherAPI.getAllCitiesByIds(cityIds);
        Set<City> validCities = filterCitiesByPopulation(cities); // Todo: to think if I want to do this for every city
        return validCities
                .parallelStream()
                .map(this::createCityDetails)
                .sorted(Comparator.comparing(CityDetails::getAggregatedValue).reversed())
                .limit(limit)
                .collect(Collectors.toSet());
    }

    private CityDetails createCityDetails(City city) {
        String cityId = city.getId();
        List<DailyTemp> dailyTemps = weatherAPI.getLastYearTemperature(cityId);
        double aggregateValue = aggregationStrategy.aggregate(dailyTemps);

        return new CityDetails(city, aggregateValue);
    }

    private Set<City> filterCitiesByPopulation(Set<City> cities) {
        return cities
                .stream()
                .filter(this::isValidPopulation)
                .collect(Collectors.toSet());
    }

    private boolean isValidPopulation(City city) {
        return city.getPopulation() > MIN_POPULATION;
    }

    public void setAggregationStrategy(AggregationStrategy aggregationStrategy) {
        this.aggregationStrategy = aggregationStrategy;
    }

}
