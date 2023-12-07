package pl.javastart.task.app;

import pl.javastart.task.model.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            Processor processor = new Processor("LG", "Ultra", "A1", 3000, 30, 90);
            HardDrive hardDrive = new HardDrive("AMD", "G300", "P1", 600);
            Memory memory = new Memory("Samsung", "GTV", "M1", 4000, 25, 95, 16);
            Computer computer = new Computer(processor, hardDrive, memory);
            System.out.println("Podaj wartość o jaką chcesz zwiększyć taktowanie procesora");
            int additionalProcessorFrequency = scanner.nextInt();
            computer.processor.overClock(additionalProcessorFrequency);
            System.out.println("Podaj wartość o jaką chcesz zwiększyć taktowanie pamięci RAM");
            int additionalMemoryFrequency = scanner.nextInt();
            computer.memory.overClock(additionalMemoryFrequency);
            System.out.println(computer);
        } catch (IllegalArgumentException | TemperatureExceededException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
