public class DayOne {
    public static void main(String[] args) {
        DayOneImpl dayOneImpl = new DayOneImpl();
        String filepath = "resources/DayOneChallenge.txt";
        int mostCaloriesElf = dayOneImpl.getMostCalories(filepath);
        int topThreeMostCalories = dayOneImpl.getTotalTopThreeCalories(filepath);

        System.out.printf("The elf with the most calories has a total of %s calories, the top three has a total of %s calories%n", mostCaloriesElf, topThreeMostCalories);
    }
}
