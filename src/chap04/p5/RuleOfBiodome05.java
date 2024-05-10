package chap04.p5;

// TODO 기본, 보너스 완료
public class RuleOfBiodome05 {

    public static void main(String[] args) {
        PlantHashMap<String, String> plantHashMap = new PlantHashMap<>();
        plantHashMap.put("장미", "장미는 관상용으로 많이 재배되는 화초 중 하나이다.");
        plantHashMap.put("해바라기", "해바라기는 태양을 따라 움직이는 것으로 알려져 있다.");
        plantHashMap.put("민들레", "민들레는 약용으로도 사용되는 풀이다.");
        plantHashMap.put("라벤더", "라벤더는 향기가 좋아 아로마 테라피에 사용된다.");
        plantHashMap.put("튤립", "튤립은 다양한 색상이 있는 봄꽃이다.");
        plantHashMap.put("선인장", "선인장은 건조한 환경에서도 잘 자란다.");
        plantHashMap.put("백합", "백합은 순결의 상징으로 여겨진다.");
        plantHashMap.put("알로에", "알로에는 피부 진정과 치유에 좋다고 알려져 있다.");
        plantHashMap.put("금잔화", "금잔화는 정원에서 흔히 볼 수 있는 꽃이다.");
        plantHashMap.put("팬지", "팬지는 작고 다양한 색을 가진 꽃이다.");

        System.out.println();

        plantHashMap.get("장미");
        plantHashMap.get("해바라기");

        System.out.println();
        plantHashMap.remove("민들레");

        plantHashMap.getIndex("장미");
        plantHashMap.getIndex("해바라기");

        System.out.println("\n===================== Bonus =================");
        BonusPlantHashMap<String, String> bonusPlantHashMap = new BonusPlantHashMap<>();
        String str1 = "0-42L";
        String str2 = "0-43-";
        bonusPlantHashMap.put(str1, "String1");
        bonusPlantHashMap.put(str2, "String2");
        bonusPlantHashMap.get(str1);
        bonusPlantHashMap.get(str2);
        bonusPlantHashMap.remove(str1);
        System.out.println();
    }
}
