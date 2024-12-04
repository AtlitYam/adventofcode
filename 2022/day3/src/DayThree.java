public class DayThree {
    public static void main(String[] args) {
        DayThreeImpl dayThreeImpl = new DayThreeImpl();
        String filepath = "resources/DayThreeChallenge.txt";

        // The first challenge is to sum the priorities of the duplicate items in the backpacks
        System.out.printf("The sum of the priorities of all duplicate items is %s%n", dayThreeImpl.getSumOfPrioritiesForDuplicates(filepath));

        // The second challenge is to sum the priorities of all the badges that appear in each group of three backpacks
        System.out.printf("The sum of the priorities of the items that appear in each group of three is %s%n", dayThreeImpl.getSumOfPrioritiesForBadges(filepath));
    }
}
