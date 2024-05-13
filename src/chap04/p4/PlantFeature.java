package chap04.p4;

public class PlantFeature {

    private String flowerColor;
    private boolean hasFruit;
    private String floweringSeason;

    public PlantFeature(String flowerColor, boolean hasFruit, String floweringSeason) {
        this.flowerColor = flowerColor;
        this.hasFruit = hasFruit;
        this.floweringSeason = floweringSeason;
    }

    @Override
    public String toString() {
        String hasFruitString = hasFruit == true ? "열매 있음" : "열매 없음";
        return flowerColor + ", " + hasFruitString + ", " + floweringSeason;
    }
}
