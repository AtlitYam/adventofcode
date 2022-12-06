import Utils.Boxes;
import Utils.Moves;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import static fileutils.FileLoader.loadBoxesFromFile;
import static fileutils.FileLoader.loadMovesFromFile;

public class DayFive {
    public static void main(String[] args) {
        Instant startTime = Instant.now();
        String filePath = "resources/DayFiveRandomTemplate.txt";

        List<Moves> movesList1 = loadMovesFromFile(filePath);
        List<Boxes> boxes1 = loadBoxesFromFile(filePath);

        DayFiveImpl.performFirstChallengeMoves(movesList1, boxes1);

        // The first challenge is to move the boxes with the given moves and figure out which letters end up on top
        System.out.printf("For the first challenge the letters that appeared on top are: %s%n", DayFiveImpl.getLettersOnTop(boxes1));

        // Getting new movelist and boxes for the second challenge
        List<Moves> movesList2 = loadMovesFromFile(filePath);
        List<Boxes> boxes2 = loadBoxesFromFile(filePath);

        DayFiveImpl.performSecondChallengeMoves(movesList2, boxes2);

        // The second challenge is to move the boxes as stacks with the given moves and figure out which letters end up on top
        System.out.printf("For the second challenge the letters that appeared on top are: %s%n", DayFiveImpl.getLettersOnTop(boxes2));

        System.out.printf("(Completed in %sms)%n", Duration.between(startTime, Instant.now()).toMillis());
    }
}
