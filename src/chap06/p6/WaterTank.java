package chap06.p6;

public class WaterTank implements Runnable {

    private int idx;
    private int amount;
    private static final int MAX_CAPACITY = 100;
    private static int currentNumber = 1;
    private static final Object lock = new Object();

    public WaterTank(int idx) {
        this.idx = idx;
        this.amount = 0;
    }

    @Override
    public void run() {
        while (amount < 100) {
            fillWater();
        }
    }

    private void fillWater() {
        while (amount < MAX_CAPACITY) {
            synchronized (lock) {
                while (idx != currentNumber) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                amount += 10;
                System.out.println("물 저장소 " + idx + ": " + amount + "리터");

                if (amount >= 100) {
                    currentNumber++;
                    lock.notifyAll();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}