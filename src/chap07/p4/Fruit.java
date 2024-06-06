package chap07.p4;

public class Fruit {
    private String name;
    private int price;
    private boolean farmChanged;
    private boolean reserved;
    private int requestCount;

    public Fruit(String name, int price, boolean farmChanged, boolean reserved, int requestCount) {
        this.name = name;
        this.price = price;
        this.farmChanged = farmChanged;
        this.reserved = reserved;
        this.requestCount = requestCount;
    }

    public boolean isFarmChanged() {
        return farmChanged;
    }

    public boolean isReserved() {
        return reserved;
    }

    public int getRequestCount() {
        return requestCount;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void increaseRequestCount() {
        this.requestCount += 1;
    }
}
