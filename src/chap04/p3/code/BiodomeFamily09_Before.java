package chap04.p3.code;

public class BiodomeFamily09_Before {
    public static void main(String[] args) {
        Device allPurposeDevice1 = new AllPurposeDevice("�ㅻ쭏�� �쇱씠��", "�먮룞 鍮� �됱긽 議곗젅");
        DeviceController controller = new DeviceController();
        controller.controlDevice(allPurposeDevice1);

        Device allPurposeDevice2 = new AllPurposeDevice("�됱옣怨�", null);
        controller.controlDevice(allPurposeDevice2);

        controller.powerOffAllDevices(allPurposeDevice1, allPurposeDevice2);
    }
}