public class Main {
    public static void main(String[] args) {
        DayOneImplementation dayOneImplementation = new DayOneImplementation();
        String filepath = "resources/DayOneChallenge.txt";
        int mostCaloriesElf = dayOneImplementation.getMostCalories(filepath);
        int topThreeMostCalories = dayOneImplementation.getTotalTopThreeCalories(filepath);

        System.out.printf("The elf with the most calories has a total of %s calories, the top three has a total of %s calories%n", mostCaloriesElf, topThreeMostCalories);
    }
}
