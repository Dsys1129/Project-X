package chap04.p3;

import java.util.ArrayList;
import java.util.List;

public class DeviceController {

    private List<Device> deviceList = new ArrayList<>();

    public void connectDevice(Device device) {
        deviceList.add(device);
        System.out.println("컨트롤러에 기기가 등록되었습니다. : " + device.getName());
    }

    public void powerOn(Device device) {
        device.powerOn();
    }

    public void powerOff(Device device) {
        device.powerOff();
    }

    public void activateFeature(FeatureActivatable device) {
        device.activateFeature();
    }

    public void powerOffAllDevices() {
        System.out.println("모든 기기 전원을 종료합니다.");
        for (Device device : deviceList) {
            device.powerOff();
        }
    }

    public void activateEnergySavingMode(Device device) {
        device.activateEnergySavingMode();
    }

    public void deactivateEnergySavingMode(Device device) {
        device.deactivateEnergySavingMode();
    }

    public void activateEnergySavingModeAllDevices() {
        System.out.println("연결된 모든 기기의 절약 모드를 켭니다.");
        for (Device device : deviceList) {
            device.activateEnergySavingMode();
        }
    }

    public void deactivateEnergySavingModeAllDevices() {
        System.out.println("연결된 모든 기기의 절약 모드를 끕니다.");
        for (Device device : deviceList) {
            device.deactivateEnergySavingMode();
        }
    }
}
