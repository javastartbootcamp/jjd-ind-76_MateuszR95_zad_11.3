package pl.javastart.task.model;

public class TemperatureExceededException extends RuntimeException {

    public TemperatureExceededException(String message) {
        super("Zwiększenie taktowania może skutkować uszkodzeniem urządzenia");
    }
}
