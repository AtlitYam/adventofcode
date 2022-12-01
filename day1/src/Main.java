public class Main {
    public static void main(String[] args) {
        DayOneCalculation dayOneCalculation = new DayOneCalculation();
        String filepath = "resources/DayOneChallenge.txt";
        int mostCaloriesElf = dayOneCalculation.getMostCalories(filepath);
        int topThreeMostCalories = dayOneCalculation.getTotalTopThreeCalories(filepath);

        System.out.printf("The elf with the most calories has a total of %s calories, the top three has a total of %s calories%n", mostCaloriesElf, topThreeMostCalories);
    }
}
