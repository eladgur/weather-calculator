import java.util.List;
import java.util.Set;

public interface WeatherAPI {
    Set<City> getAllCitiesByIds(Set<String> ids);
    List<DailyTemp> getLastYearTemperature(String cityId);
}
