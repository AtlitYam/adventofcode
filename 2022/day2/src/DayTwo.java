public class DayTwo {
    public static void main(String[] args) {
        String filepath = "resources/DayTwoChallenge.txt";

        // Get answer for first challenge where the second row is what we play
        System.out.printf("The total score of all matches was %s for the player%n%n", DayTwoImpl.calculateTotalScoreFromMatchesIn(filepath, false));

        // Get answer for second challenge where the second row is the expected result
        System.out.printf("The total score of all matches with the expected results would be %s for the player%n", DayTwoImpl.calculateExpectedTotalScoreFromMatchesIn(filepath, false));
    }
}
