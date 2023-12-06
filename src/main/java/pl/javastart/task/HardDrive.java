package pl.javastart.task;

public class HardDrive extends Component {

    private int driveCapacity;

    public HardDrive(String producer, String model, String serialNumber, int driveCapacity) {
        super(producer, model, serialNumber);
        setDriveCapacity(driveCapacity);
    }

    public int getDriveCapacity() {
        return driveCapacity;
    }

    public void setDriveCapacity(int driveCapacity) {
        if (driveCapacity < 0) {
            throw new IllegalArgumentException("Pojemność dysku nie może być ujemna");
        }
        this.driveCapacity = driveCapacity;
    }

    @Override
    public String toString() {
        return "HardDrive{" +
                "driveCapacity=" + driveCapacity +
                '}';
    }
}
