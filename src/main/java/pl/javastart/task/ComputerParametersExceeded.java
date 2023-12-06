package pl.javastart.task;

public class ComputerParametersExceeded extends RuntimeException {

    public ComputerParametersExceeded(String message) {
        super("Zwiększenie taktowania może skutkować uszkodzeniem urządzenia");
    }
}
