package chap03.p5;

public class BiodomeFamily05 {
    public static void main(String[] args) {
        Sorcerer sorcerer = new Sorcerer("아리엘");
        SolarStone solarStone = new SolarStone("태양의 돌");
        WindAmulet windAmulet = new WindAmulet("바람의 부적");
        WaterMirror waterMirror = new WaterMirror("물의 거울");

        System.out.println();

        sorcerer.addAncientArtifact(solarStone);
        sorcerer.addAncientArtifact(windAmulet);
        sorcerer.addAncientArtifact(waterMirror);

        System.out.println();

        sorcerer.checkArtifactDescribe(solarStone);

        sorcerer.useArtifact(waterMirror);

        System.out.println("====================== Bonus =====================");

        solarStone.charge(50);
        waterMirror.charge(30);
        solarStone.charge(10);

        solarStone.getChargeLevel();
        waterMirror.getChargeLevel();
        Chargeable.showChargingTips();
    }
}
