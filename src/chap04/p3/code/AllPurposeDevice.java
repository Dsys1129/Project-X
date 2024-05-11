package chap04.p3.code;

class AllPurposeDevice implements Device {
    DeviceDetails details;
    String feature;

    AllPurposeDevice(String model, String feature) {
        this.details = new DeviceDetails(model);
        this.feature = feature;
    }

    @Override
    public void powerOn() {
        details.displayAndPowerOn();
    }



    @Override
    public void activateFeature() {
        System.out.println(feature + " 기능을 활성화 시켰습니다.");
    }

    @Override
    public void powerOff() {
        details.displayAndPowerOff();
    }
}
