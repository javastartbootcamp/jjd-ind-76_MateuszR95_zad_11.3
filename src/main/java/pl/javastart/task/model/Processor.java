package pl.javastart.task.model;

public class Processor extends OverclockableComponent {

    public Processor(String producer, String model, String serialNumber, int frequency,
                     double currentTemperature, double maxSafeTemperature) {
        super(producer, model, serialNumber, frequency, currentTemperature,
                maxSafeTemperature);
        this.temperatureIncreasePer100Mhz = 10;
    }

    @Override
    public void overClock(double additionalFrequency) {
        super.overClock(additionalFrequency);
    }

    @Override
    public String toString() {
        return "Processor{" +
                "frequency=" + frequency +
                ", currentTemperature=" + currentTemperature +
                ", maxSafeTemperature=" + maxSafeTemperature +
                ", temperatureIncreasePer100Mhz=" + temperatureIncreasePer100Mhz +
                '}';
    }
}