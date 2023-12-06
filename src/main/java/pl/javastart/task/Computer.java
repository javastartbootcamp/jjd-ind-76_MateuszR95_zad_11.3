package pl.javastart.task;

public class Computer {

    protected Processor processor;
    protected HardDrive hardDrive;
    protected Memory memory;

    public Computer(Processor processor, HardDrive hardDrive, Memory memory) {
        setProcessor(processor);
        setHardDrive(hardDrive);
        setMemory(memory);
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        if (processor == null) {
            throw new NullPointerException("Komponent nie może być null");
        }
        this.processor = processor;
    }

    public HardDrive getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(HardDrive hardDrive) {
        if (hardDrive == null) {
            throw new NullPointerException("Komponent nie może być null");
        }
        this.hardDrive = hardDrive;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        if (memory == null) {
            throw new NullPointerException("Komponent nie może być null");
        }
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "processor=" + processor.toString() +
                ", hardDrive=" + hardDrive.toString() +
                "\n, memory=" + memory.toString() +
                '}';
    }
}
