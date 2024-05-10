package chap03.p5;

public class WindAmulet extends AncientArtifact implements WeatherController {

    public WindAmulet(String name) {
        super(name);
    }

    @Override
    public void describe() {
        System.out.println(this.name + " : " + "주변 공기의 흐름을 이용해 날씨를 조절함(예. 저기압, 고기압, 강풍 등)");

    }

    @Override
    public void controlWeather() {
        System.out.println(this.name + " : " + "주변 공기의 흐름을 이용해 날씨를 조절중");
    }
}
