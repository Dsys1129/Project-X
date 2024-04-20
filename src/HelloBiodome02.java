public class HelloBiodome02 {

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("입력의 개수가 올바르지 않습니다.");
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
                .append(String.format("%.9f", rateOfSolarPower))
                .append("%, ")
                .append("풍력 ")
                .append(String.format("%.9f", rateOfWindEnergy))
                .append("%, ")
                .append("지열 ")
                .append(String.format("%.9f", rateOfGeothermalEnergy))
                .append("%");

        System.out.println(sb);
    }

    private static class EnergyUtils {
        public static int calculateTotalEnergies(int solarPower, int windEnergy, int geothermalEnergy) {
            return solarPower + windEnergy + geothermalEnergy;
        }

        public static double calculateRateEnergy(int totalEnergy, int targetEnergy) {
            // double / int 는 자동으로 double로 형변환 ( 묵시적 형변환 )
            return ((double) targetEnergy / totalEnergy) * 100;
        }
    }
}
