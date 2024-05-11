package chap04.p3.code;

class DeviceController {
    public void controlDevice(Device device) {
        device.powerOn();
        device.activateFeature();
    }

    public void powerOffAllDevices(Device... devices) {
        for (Device device : devices) {
            device.powerOff();
        }
    }
}
