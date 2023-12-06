package pl.javastart.task;

import java.util.Scanner;

public class Memory extends Component implements Overclockable {

    private int memory;
    private int frequency;
    private double currentTemperature;
    private double maxSafeTemperature;
    private static final int TEMPERATURE_INCREASE_PER_100_MHZ = 15;

    public Memory(String producer, String model, String serialNumber, int memory, int frequency, double currentTemperature, double maxSafeTemperature) {
        super(producer, model, serialNumber);
        setMemory(memory);
        setFrequency(frequency);
        setCurrentTemperature(currentTemperature);
        setMaxSafeTemperature(maxSafeTemperature);
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

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        if (frequency < 0) {
            throw new IllegalArgumentException("Taktowanie nie może być wartością ujemną");
        }
        this.frequency = frequency;
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(double currentTemperature) {
        if (currentTemperature < 0) {
            throw new IllegalArgumentException("Aktualna temperatura nie może być ujemna");
        }
        this.currentTemperature = currentTemperature;
    }

    public double getMaxSafeTemperature() {
        return maxSafeTemperature;
    }

    public void setMaxSafeTemperature(double maxSafeTemperature) {
        if (maxSafeTemperature < 0 || maxSafeTemperature < currentTemperature) {
            throw new IllegalArgumentException("Maksymalna temperatura nie może być mniejsza od 0 i mniejsza od aktualnej");
        }
        this.maxSafeTemperature = maxSafeTemperature;
    }

    @Override
    public void overClock() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj o ile chcesz zwiększyć taktowanie pamięci ram");
        int additionalFrequency = scanner.nextInt();
        if (additionalFrequency < 0) {
            throw new IllegalArgumentException("Nie można zwiększyć parametru o liczbę ujemną");
        }
        scanner.nextLine();
        double temperatureIncrease = additionalFrequency / 100.0 * TEMPERATURE_INCREASE_PER_100_MHZ;
        if (temperatureIncrease + currentTemperature > maxSafeTemperature) {
            throw new ComputerParametersExceeded("Zwiększenie taktowania może skutkować uszkodzeniem urządzenia");
        }
        this.frequency += additionalFrequency;
        this.currentTemperature += additionalFrequency / 100.0 * TEMPERATURE_INCREASE_PER_100_MHZ;
        System.out.println("Zwiększenie taktowania pamięci ram o " + additionalFrequency + "MHz");
    }

    @Override
    public String toString() {
        return "Memory{" +
                "memory=" + memory +
                ", frequency=" + frequency +
                String.format(", currentTemperature= %.1f", currentTemperature) +
                String.format(", maxSafeTemperature= %.1f", maxSafeTemperature) +
                '}';
    }
}
