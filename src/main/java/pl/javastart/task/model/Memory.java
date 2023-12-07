package pl.javastart.task.model;

public class Memory extends OverclockableComponent {

    private int memory;

    public Memory(String producer, String model, String serialNumber, int frequency, double currentTemperature,
                  double maxSafeTemperature, int memory) {
        super(producer, model, serialNumber, frequency, currentTemperature, maxSafeTemperature);
        this.memory = memory;
        this.temperatureIncreasePer100Mhz = 15;
    }

    @Override
    public void overClock(double additionalFrequency) {
        super.overClock(additionalFrequency);
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        if (memory < 0) {
            throw new IllegalArgumentException("Ilość pamięci nie może być ujemna");
        }
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "memory=" + memory +
                ", frequency=" + frequency +
                ", currentTemperature=" + currentTemperature +
                ", maxSafeTemperature=" + maxSafeTemperature +
                ", temperatureIncreasePer100Mhz=" + temperatureIncreasePer100Mhz +
                '}';
    }
}
