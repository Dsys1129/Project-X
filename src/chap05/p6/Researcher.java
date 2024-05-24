package chap05.p6;

import java.time.LocalDate;
import java.util.Random;

public class Researcher {
    private String id;
    private String name;
    private LocalDate createdAt;
    private String position;

    public Researcher(String name, String position) {
        this.name = name;
        this.createdAt = LocalDate.now();
        this.position = position;
    }

    public void generateId(int count) {
        String year = String.valueOf(this.createdAt.getYear());
        Random random = new Random(System.currentTimeMillis());
        int randomNumber = random.nextInt(1000);
        String randomNumberStr = String.format("%03d", randomNumber);
        String countStr = String.format("%02d", count);
        this.id = "LUMI-" + year + "-" + countStr + ":" +randomNumberStr;
    }

    public void displayInfo() {
        System.out.println(this.id + ", " + this.name + ", " + this.createdAt + ", " + this.position);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public String getPosition() {
        return position;
    }
}
