package chap03.p5;

public interface Chargeable {

    void setChargeLevel(int amount);

    default void charge(int amount) {
        setChargeLevel(getChargeLevel() + amount);
    }

    int getChargeLevel();

    static void showChargingTips() {
        System.out.println("에너지를 효율적으로 충전하려면 마법사의 기분이 좋아야 합니다.");
    }
}
