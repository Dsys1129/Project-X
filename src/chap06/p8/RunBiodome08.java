package chap06.p8;

//TODO 기본, 보너스 완료
public class RunBiodome08 {
    public static void main(String[] args) {

        DetectorAnalyzer detectorAnalyzer = new DetectorAnalyzer();
        CalculationAnalyzer calculationAnalyzer = new CalculationAnalyzer();

        Thread threadForDetector = new Thread(detectorAnalyzer);
        Thread threadForCalculation = new Thread(calculationAnalyzer);

        threadForDetector.start();
        threadForCalculation.start();
        ElephantSensor elephantSensor = new ElephantSensor();

        elephantSensor.registerObserver(detectorAnalyzer);
        elephantSensor.registerObserver(calculationAnalyzer);

        elephantSensor.run();
    }
}
