package chap04.p3;

public abstract class Device implements Powerable, EnergySavable {
    protected String name;
    protected String brand;
    protected boolean isPowerOn;
    protected boolean isEnergySavingMode;

    public Device(String name) {
        this.name = name;
        this.brand = "DOMETech";
    }

    public void displayInfo() {
        System.out.println(this.name + ", " + this.brand);
    }

    @Override
    public void powerOn() {
        System.out.println(this.name + " 전원을 켰습니다.");
        this.isPowerOn = true;
    }

    @Override
    public void powerOff() {
        System.out.println(this.name + " 전원을 껐습니다.");
        this.isPowerOn = false;
    }

    @Override
    public void activateEnergySavingMode() {
        System.out.println(this.name + "의 절약 모드를 켰습니다.");
        this.isEnergySavingMode = true;
    }

    @Override
    public void deactivateEnergySavingMode() {
        System.out.println(this.name + "의 절약 모드를 껐습니다.");
        this.isEnergySavingMode = false;
    }

    public String getName() {
        return name;
    }
}
