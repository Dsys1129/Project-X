package chap03.p3;

public class BiodomeFamily03 {

    public static void main(String[] args) {
        // 2가지 동물 객체와 2가지 식물 객체를 생성한다.
        Organism penguin = new Animal("펭귄", "동물", "남극", "육식", "물고기");
        Organism koala = new Animal("코알라", "동물", "호주", "초식", "유칼립투스");
        Organism cactus = new Plant("선인장", "식물", "사막" , "11월", "열매 있음");
        Organism peppermint = new Plant("페퍼민트", "식물", "정원", "7월", "열매 없음");

        // 생성된 동식물을 저장소 목록에 저장한다.
        LifeNest lifeNest = new LifeNest();
        lifeNest.addOrganism(penguin);
        lifeNest.addOrganism(koala);
        lifeNest.addOrganism(cactus);
        lifeNest.addOrganism(peppermint);

        // 모든 동식물을 출력한다.
        lifeNest.displayAll();

        // 1가지 동물과 1가지 식물을 삭제한다.
        lifeNest.removeOrganism(koala);
        lifeNest.removeOrganism(cactus);

        // 모든 동식물을 출력한다.
        lifeNest.displayAll();

        System.out.println("========================== Bonus ======================");

        //Bonus
        Mammal mammal = new Mammal("포유류", "동물", "서식지", "소화 방식", "먹이", "온열");
        lifeNest.addOrganism(mammal);
        mammal.giveBirth();

        Bird bird = new Bird("새", "동물", "서식지", "소화 방식", "먹이", "날개 길이");
        lifeNest.addOrganism(bird);
        bird.fly();

        Fish fish = new Fish("물고기", "동물", "서식지", "소화 방식", "먹이", "지느러미 수");
        lifeNest.addOrganism(fish);
        fish.swim();
    }
}
