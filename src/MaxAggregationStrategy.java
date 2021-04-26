import java.util.Comparator;
import java.util.List;

public class MaxAggregationStrategy implements AggregationStrategy {

    private static final DailyTemp DEFAULT_DAILY_TEMP = new DailyTemp(0);

    @Override
    public double aggregate(List<DailyTemp> dailyTemps) {
        return dailyTemps
                .stream()
                .max(Comparator.comparing(DailyTemp::getTemperature))
                .orElse(DEFAULT_DAILY_TEMP)
                .getTemperature();
    }

}
