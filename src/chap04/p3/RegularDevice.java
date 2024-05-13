package chap04.p3;

public class RegularDevice extends Device implements Powerable {
    public RegularDevice(String name) {
        super(name);
        System.out.print("일반 기기가 생성되었습니다 : ");
        displayInfo();
    }


}
