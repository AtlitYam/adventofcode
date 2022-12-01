public class DayOne {
    public static void main(String[] args) {
        String filepath = "resources/DayOneChallenge.txt";
        // Day 1A to calculate the calories of the elf with the most calories
        int mostCaloriesElf = DayOneImpl.getMostCalories(filepath);
        // Day 1B To calculate the total of the 3 elves with the most calories
        int topThreeMostCalories = DayOneImpl.getTotalTopThreeCalories(filepath);

        System.out.printf("The elf with the most calories has a total of %s calories, the top three has a total of %s calories%n", mostCaloriesElf, topThreeMostCalories);
    }
}
