package pl.javastart.task.model;

public abstract class Component {

    private String producer;
    private String model;
    private String serialNumber;

    public Component(String producer, String model, String serialNumber) {
        this.producer = producer;
        this.model = model;
        this.serialNumber = serialNumber;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public String toString() {
        return "Component{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                '}';
    }
}
