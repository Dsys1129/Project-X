package chap03.p1;

public class BiodomeFamily01 {

    public static void main(String[] args) {

        // 2가지 동물 객체와 2가지 식물 객체를 생성한다.
        Organism penguin = new Organism("펭귄", "동물", "남극");
        Organism koala = new Organism("코알라", "동물", "호주");
        Organism  cactus = new Organism("선인장", "식물", "사막");
        Organism  peppermint = new Organism("페퍼민트", "식물", "정원");

        // 생성된 동식물을 저장소 목록에 저장한다.
        LifeNest lifeNest = new LifeNest();
        lifeNest.addOrganism(penguin);
        lifeNest.addOrganism(koala);
        lifeNest.addOrganism(cactus);
        lifeNest.addOrganism(peppermint);

        // 모든 동식물을 출력한다.
        lifeNest.printAllOrganism();

        // 1가지 동물과 1가지 식물을 삭제한다.
        lifeNest.removeOrganism(koala);
        lifeNest.removeOrganism(cactus);

        // 동물의 서식지를 변경한다.
        penguin.updateHabitat("해변");

        // 모든 동식물을 출력한다.
        lifeNest.printAllOrganism();

        System.out.println("========================== Bonus ======================");
        // Bonus
        Organism cat = new Organism("고양이", "동물", "모든 곳");
        lifeNest.addOrganism(cat);

        lifeNest.searchOrganismByName("고양이");
    }
}
