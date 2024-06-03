package chap06.p6;

public class BonusWaterTank implements Runnable, Comparable<BonusWaterTank> {

    private int idx;
    private int amount;
    private int priority;
    private static final Object lock = new Object();

    public BonusWaterTank(int idx) {
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
            amount += 10;
            System.out.println("물 저장소 " + idx + ": " + amount + "리터");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            if (amount == 100) {
                lock.notifyAll();
            }
        }
    }

    @Override
    public int compareTo(BonusWaterTank o) {
        if (this.priority == o.priority) {
            return Integer.compare(this.idx, o.idx);
        }
        return Integer.compare(o.priority, this.priority);
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
