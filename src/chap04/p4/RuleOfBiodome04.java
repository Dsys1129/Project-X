package chap04.p4;

public class RuleOfBiodome04 {

    public static void main(String[] args) throws NoSuchFieldException {
        // 동물, 식물, 미생물 객체 생성
        BiologicalEntity cat = new BiologicalEntity<>("고양이", "동물", new AnimalFeature("귀여움", "포유류", 20));
        BiologicalEntity zebra = new BiologicalEntity<>("얼룩말", "동물", new AnimalFeature("잘 달린다", "포유류", 10));
        BiologicalEntity rosemary = new BiologicalEntity<>("로즈마리", "식물", new PlantFeature("보라색", false, "7월"));
        BiologicalEntity cherryBlossom = new BiologicalEntity<>("벚꽃", "식물", new PlantFeature("분홍색", true, "3월"));
        BiologicalEntity eColi = new BiologicalEntity<>("이콜라이", "미생물", new MicrobeFeature("약 산성", "호흡 및 발효"));
        BiologicalEntity bacillus = new BiologicalEntity<>("바실러스", "미생물", new MicrobeFeature("약 산성", "호흡"));

        BiologicalSystem<BiologicalEntity> biologicalSystem = new BiologicalSystem<>();

        // 생물 정보 추가
        biologicalSystem.add(cat);
        biologicalSystem.add(zebra);
        biologicalSystem.add(rosemary);
        biologicalSystem.add(cherryBlossom);
        biologicalSystem.add(eColi);
        biologicalSystem.add(bacillus);

        biologicalSystem.delete();

        biologicalSystem.show();

        biologicalSystem.isEmpty();

        biologicalSystem.clear();

        biologicalSystem.isEmpty();

        System.out.println(" ========================= Bonus =======================");
        biologicalSystem.add(new BiologicalEntity("d", "d", new AnimalFeature("", "", 0)));
        biologicalSystem.add(new BiologicalEntity("b", "d", new AnimalFeature("", "", 0)));
        biologicalSystem.add(new BiologicalEntity("c", "d", new AnimalFeature("", "", 0)));
        biologicalSystem.add(new BiologicalEntity("a", "d", new AnimalFeature("", "", 0)));

        biologicalSystem.sortByNameOrderByASC();
        biologicalSystem.printAllBiologicalEntity();
    }
}
