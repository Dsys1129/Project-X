package chap04.p3.code;

// SRP 위배
// Device의 정보를 관리하는 것 뿐만 아니라 Device의 전원을 켜고 끄는 기능도 가지고
class DeviceDetails {
    String model;
    static final String BRAND = "DOMETech";

    DeviceDetails(String model) {
        this.model = model;
    }

    public void displayAndPowerOn() {
        System.out.println("Model: " + model);
        System.out.println("Brand: " + BRAND);
        powerOn();
    }

    public void displayAndPowerOff() {
        System.out.println("Model: " + model);
        System.out.println("Brand: " + BRAND);
        powerOff();
    }

    public void powerOn() {
        System.out.println(model + " 전원을 켰습니다.");
    }
    public void powerOff() {
        System.out.println(model + " 전원을 껐습니다.");
    }
}

