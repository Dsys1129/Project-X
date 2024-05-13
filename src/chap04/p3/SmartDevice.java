package chap04.p3;

public class SmartDevice extends Device implements FeatureActivatable {

    private String feature;

    public SmartDevice(String name, String feature) {
        super(name);
        this.feature = feature;

        System.out.print("스마트 기기가 생성되었습니다. : ");
        displayInfo();
    }

    @Override
    public void displayInfo() {
        System.out.println(this.name + ", " + this.brand + ", " + this.feature);
    }

    @Override
    public void activateFeature() {
        if (!this.isPowerOn) {
            System.out.println(this.name + "의 전원이 꺼져있습니다. 전원을 키고 활성화 해주세요");
            return;
        }
        System.out.println(this.name + " 고급 기능을 활성화 시켰습니다.");
    }
}
