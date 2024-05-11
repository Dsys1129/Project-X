package chap04.p3.code;

import chap04.p3.Device;

public class RegularDevice extends Device {
    public RegularDevice(String name) {
        super(name);
        System.out.print("일반 기기가 생성되었습니다. : ");
        displayInfo();
    }
}
