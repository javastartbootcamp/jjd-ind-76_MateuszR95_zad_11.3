package pl.javastart.task;

public class Main {

    public static void main(String[] args) {

        try {
            Processor processor = new Processor("LG", "Ultra", "A1", 3000, 30, 90);
            HardDrive hardDrive = new HardDrive("AMD", "G300", "P1", 600);
            Memory memory = new Memory("Samsung", "GTV", "M1", 12, 4000, 25, 95);
            Computer computer = new Computer(processor, hardDrive, memory);
            computer.processor.overClock();
            computer.memory.overClock();
            System.out.println(computer);
        } catch (IllegalArgumentException | ComputerParametersExceeded | NullPointerException e) {
            System.out.println(e.getMessage());
        }

    }
}
