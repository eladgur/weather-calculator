import java.util.Date;

class DailyTemp {
    private Date date;
    private double temperature;

    DailyTemp(double temperature) {
        this.temperature = temperature;
    }

    double getTemperature() {
        return temperature;
    }
}
