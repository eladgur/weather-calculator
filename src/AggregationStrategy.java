import java.util.List;

public interface AggregationStrategy {
    double aggregate(List<DailyTemp> dailyTemps);
}
