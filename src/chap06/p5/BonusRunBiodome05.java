package chap06.p5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BonusRunBiodome05 {
    public static void main(String[] args) {
        int poolSize = 3;
        ExecutorService executor = Executors.newFixedThreadPool(poolSize);

        Sensor co2Sensor = new Sensor("이산화탄소 농도", 350, 1000);
        Sensor humiditySensor = new Sensor("습도", 30, 70);
        Sensor ozoneSensor = new Sensor("오존", 0.02, 0.1);
        executor.execute(co2Sensor);
        executor.execute(humiditySensor);
        executor.execute(ozoneSensor);

        executor.shutdown();
    }
}
