package chap04.p3;


public class RuleOfBodome03 {
    public static void main(String[] args) {
        RegularDevice doorOpener = new RegularDevice("도어 오프너");
        SmartDevice autoMirror = new SmartDevice("자동 거울", "기분을 인식해 옷을 추천하는 기능");

        DeviceController deviceController = new DeviceController();
        System.out.println();
        deviceController.connectDevice(doorOpener);
        deviceController.connectDevice(autoMirror);

        System.out.println();
        deviceController.powerOn(autoMirror);
        deviceController.activateFeature(autoMirror);


        System.out.println();
        deviceController.powerOn(doorOpener);

        System.out.println();
        deviceController.powerOffAllDevices();

        System.out.println("================== Bonus ==================");
        deviceController.activateEnergySavingMode(doorOpener);
        deviceController.deactivateEnergySavingMode(doorOpener);

        System.out.println();
        deviceController.activateEnergySavingModeAllDevices();

        System.out.println();
        deviceController.deactivateEnergySavingModeAllDevices();
    }
}