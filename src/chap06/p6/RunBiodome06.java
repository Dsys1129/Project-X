package chap06.p6;

//TODO 일반 문제 완료
// 보너스 X
public class RunBiodome06 {
    public static void main(String[] args) {
        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            WaterTank tank = new WaterTank(i + 1);
            threads[i] = new Thread(tank);
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("물 채우기가 완료되었습니다.");
    }
}