package pl.javastart.task.model;

public abstract class OverclockableComponent extends Component implements Overclockable {

    protected int frequency;
    protected double currentTemperature;
    protected double maxSafeTemperature;
    protected int temperatureIncreasePer100Mhz;

    public OverclockableComponent(String producer, String model, String serialNumber, int frequency,
                                  double currentTemperature, double maxSafeTemperature) {
        super(producer, model, serialNumber);
        if (frequency < 0) {
            throw new IllegalArgumentException("Taktowanie nie może być wartością ujemną");
        }
        if (currentTemperature < 0) {
            throw new IllegalArgumentException("Aktualna temperatura nie może być ujemna");
        }
        if (maxSafeTemperature < 0 || maxSafeTemperature < currentTemperature) {
            throw new IllegalArgumentException("Maksymalna temperatura nie może być mniejsza od 0 i mniejsza od aktualnej");
        }
        this.frequency = frequency;
        this.currentTemperature = currentTemperature;
        setMaxSafeTemperature(maxSafeTemperature);
    }

    protected int getFrequency() {
        return frequency;
    }

    protected double getCurrentTemperature() {
        return currentTemperature;
    }

    protected double getMaxSafeTemperature() {
        return maxSafeTemperature;
    }

    protected void setMaxSafeTemperature(double maxSafeTemperature) {
        if (maxSafeTemperature < 0 || maxSafeTemperature < currentTemperature) {
            throw new IllegalArgumentException("Maksymalna temperatura nie może być mniejsza od 0 i mniejsza od aktualnej");
        }
        this.maxSafeTemperature = maxSafeTemperature;
    }

    protected int getTemperatureIncreasePer100Mhz() {
        return temperatureIncreasePer100Mhz;
    }

    @Override
    public void overClock(double additionalFrequency) {
        if (additionalFrequency < 0) {
            throw new IllegalArgumentException("Nie można zwiększyć parametru o liczbę ujemną");
        }
        double temperatureIncrease = additionalFrequency / 100.0 * temperatureIncreasePer100Mhz;
        if (temperatureIncrease + currentTemperature > maxSafeTemperature) {
            throw new TemperatureExceededException("Zwiększenie taktowania może skutkować uszkodzeniem urządzenia");
        }
        this.frequency += additionalFrequency;
        this.currentTemperature += temperatureIncrease;

    }

    @Override
    public String toString() {
        return "OverclockableComponent{" +
                "frequency=" + frequency +
                ", currentTemperature=" + currentTemperature +
                ", maxSafeTemperature=" + maxSafeTemperature +
                ", temperatureIncreasePer100Mhz=" + temperatureIncreasePer100Mhz +
                '}';
    }
}
