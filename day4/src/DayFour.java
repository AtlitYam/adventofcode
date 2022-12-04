public class DayFour {
    public static void main(String[] args) {
        String filePath = "resources/DayFourChallenge.txt";
        DayFourImpl dayFourImpl = new DayFourImpl();

        // The first challenge of day four is to find all entirely overlapping number pairs
        System.out.printf("The number of entirely overlapping number pairs is %s%n", dayFourImpl.countEntirelyOverlappingNumberPairs(filePath));

        // The second challenge of day four is to find all number pairs with any overlapping numbers
        System.out.printf("The number of number pairs with any overlap is %s%n", dayFourImpl.countAnyOverlappingNumberPairs(filePath));
    }
}
