public class HelloBiodome02 {

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("입력의 개수가 올바르지 않습니다.");
            return;
        }

        if (!(isPositiveNumber(args[0]) && isPositiveNumber(args[1]) && isPositiveNumber(args[2]))) {
            System.out.println("음수는 입력할 수 없습니다.");
            return;
        }

        int solarPower = Integer.parseInt(args[0]);
        int windEnergy = Integer.parseInt(args[1]);
        int geothermalEnergy = Integer.parseInt(args[2]);
        int totalEnergy = EnergyUtils.calculateTotalEnergies(solarPower, windEnergy, geothermalEnergy);

        double rateOfSolarPower = EnergyUtils.calculateRateEnergy(totalEnergy, solarPower);
        double rateOfWindEnergy = EnergyUtils.calculateRateEnergy(totalEnergy, windEnergy);
        double rateOfGeothermalEnergy = EnergyUtils.calculateRateEnergy(totalEnergy, geothermalEnergy);

        StringBuilder sb = new StringBuilder();
        sb.append("총 에너지 생성량은 ")
                .append(totalEnergy)
                .append("입니다.")
                .append("\n")
                .append("태양광 ")
                .append(rateOfSolarPower)
                .append("%, ")
                .append("풍력 ")
                .append(rateOfWindEnergy)
                .append("%, ")
                .append("지열 ")
                .append(rateOfGeothermalEnergy)
                .append("%");

        System.out.println(sb);
    }

    private static boolean isPositiveNumber(String input) {
        int inputNumber = Integer.parseInt(input);
        if (inputNumber < 0) {
            return false;
        }
        return true;
    }

    private static class EnergyUtils {
        public static int calculateTotalEnergies(int solarPower, int windEnergy, int geothermalEnergy) {
            return solarPower + windEnergy + geothermalEnergy;
        }

        public static double calculateRateEnergy(int totalEnergy, int targetEnergy) {
            return ((double) targetEnergy / totalEnergy) * 100;
        }
    }
}
