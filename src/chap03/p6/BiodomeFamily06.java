package chap03.p6;

import java.util.*;

public class BiodomeFamily06 {

    public static void main(String[] args) {
        Animal monkey = new Animal("제니", "원숭이", 4);
        Animal elephant = new Animal("고먀", "코끼리", 4);
        Animal tiger = new Animal("타이", "호랑이", 9);
        Animal rhinoceros = new Animal("로아", "코뿔소", 5);
        Animal deer = new Animal("바비", "사슴",7);

        List<Animal> animals = new ArrayList<>();
        animals.add(monkey);
        animals.add(elephant);
        animals.add(tiger);
        animals.add(rhinoceros);
        animals.add(deer);

        sort(animals);

        for (Animal animal : animals) {
            animal.displayInfo();
        }

        System.out.println("\n==================== Bonus ================");
        System.out.println("동물 추가 : 늑대 (원숭이를 포식한다. 원숭이는 늑대 앞에 올 수 없음)");

        List<BonusAnimal> bonusAnimals = new ArrayList<>();
        BonusAnimal wolf = new BonusAnimal("울프", AnimalType.WOLF, 5);
        BonusAnimal monkey2 = new BonusAnimal("제니", AnimalType.MONKEY, 4);
        BonusAnimal elephant2 = new BonusAnimal("고먀", AnimalType.ELEPHANT, 4);
        BonusAnimal tiger2 = new BonusAnimal("타이", AnimalType.TIGER, 9);
        BonusAnimal rhinoceros2 = new BonusAnimal("로아", AnimalType.RHINOCEROS, 5);
        BonusAnimal deer2 = new BonusAnimal("바비", AnimalType.DEER,7);


        bonusAnimals.add(monkey2);
        bonusAnimals.add(wolf);
        bonusAnimals.add(elephant2);
        bonusAnimals.add(tiger2);
        bonusAnimals.add(rhinoceros2);
        bonusAnimals.add(deer2);

        bonusSort(bonusAnimals);

        for (BonusAnimal bonusAnimal : bonusAnimals) {
            bonusAnimal.displayInfo();
        }
    }

    private static void sort(List<Animal> animals) {
        // -1 : o1이 o2보다 작다. 즉, o1이 o2보다 앞에 온다.
        // 0 : o1과 o2가 같다. 즉, 위치 변동이 없다.
        // 1 : o1가 o2보다 크다. 즉, o1가 o2뒤에 위치하게 된다.
        Collections.sort(animals, new Comparator<Animal>() {
            @Override
            public int compare(Animal o1, Animal o2) {
                if (o1.getType().equals("호랑이") && o2.getType().equals("사슴")) {
                    return -1;
                } else if (o1.getType().equals("사슴") && o2.getType().equals("호랑이")) {
                    return 1;
                } else if (o1.getType().equals("코끼리") && o1.getAge() <= 5 && o2.getType().equals("호랑이")) {
                    return 1;
                } else if (o1.getType().equals("호랑이") && o2.getType().equals("코끼리") && o2.getAge() <= 5) {
                    return -1;
                }
                return 0;
            }
        });
    }

    public static void bonusSort(List<BonusAnimal> bonusAnimals) {
        Collections.sort(bonusAnimals, new Comparator<BonusAnimal>() {
            @Override
            public int compare(BonusAnimal o1, BonusAnimal o2) {
                AnimalType type1 = o1.getType();
                AnimalType type2 = o2.getType();

                if (type1 == AnimalType.TIGER && type2 == AnimalType.DEER) {
                    return -1;
                } else if (type1 == AnimalType.DEER && type2 == AnimalType.TIGER) {
                    return 1;
                } else if (type1 == AnimalType.ELEPHANT && o1.getAge() <= 5 && type2 == AnimalType.TIGER) {
                    return 1;
                } else if (type1 == AnimalType.TIGER && type2 == AnimalType.ELEPHANT && o2.getAge() <= 5) {
                    return -1;
                } else if (type1 == AnimalType.MONKEY && type2 == AnimalType.WOLF) {
                    return 1;
                } else if (type1 == AnimalType.WOLF && type2 == AnimalType.MONKEY) {
                    return -1;
                }
                return 0;
            }
        });
    }
}
