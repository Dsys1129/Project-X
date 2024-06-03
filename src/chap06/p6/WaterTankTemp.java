package chap06.p6;

public class WaterTankTemp implements Runnable {

    private int idx;
    private int amount;
    private static int nextIdx = 0;
    private static final Object lock = new Object();

    public WaterTankTemp(int idx) {
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
        synchronized (lock) {
            while (idx - 1 != nextIdx) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            amount += 10;
            System.out.println("물 저장소 " + idx + ": " + amount + "리터");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            if (amount == 100) {
                nextIdx++;
                lock.notifyAll();
            }

            if (nextIdx == 5) {
                System.out.println("물 채우기가 끝났습니다.");
            }
        }
    }
}

