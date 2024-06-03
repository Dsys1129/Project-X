package chap06.p5;

public class RunBiodome05 {

    public static void main(String[] args) {
        Sensor temperatureSensor = new Sensor("온도", -5.0, 32.5);
        Sensor oxygenSensor = new Sensor("산소 농도", 18.5, 23.5);

        System.out.println("센서 모니터링을 시작합니다");
        temperatureSensor.start();
        oxygenSensor.start();
    }
}
