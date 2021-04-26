class CityDetails {

    private City city;
    private double aggregatedValue;

    CityDetails(City city, double aggregatedValue) {
        this.city = city;
        this.aggregatedValue = aggregatedValue;
    }

    double getAggregatedValue() {
        return aggregatedValue;
    }

    @Override
    public String toString() {
        return String.format("City Id: %s , Aggregated Temperature: %f", this.city.getId(), this.aggregatedValue);
    }
}
