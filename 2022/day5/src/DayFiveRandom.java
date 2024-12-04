import Utils.Boxes;
import Utils.Moves;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import static fileutils.FileLoader.loadBoxesFromFile;

public class DayFiveRandom {
    public static void main(String[] args) {
        Instant startTime = Instant.now();
        String filePath = "resources/DayFiveRandomTemplate.txt";

        // Test with a randomizer
        List<Moves> movesList3 = Moves.generateRandomMoves(10, 150, 216);
        List<Boxes> boxes3 = loadBoxesFromFile(filePath);

        DayFiveImpl.performFirstChallengeMoves(movesList3, boxes3);

        // The second challenge is to move the boxes as stacks with the given moves and figure out which letters end up on top
        System.out.printf("For the randomized challenge the letters that appeared on top are: %s%n", DayFiveImpl.getLettersOnTop(boxes3));

        System.out.printf("(Completed in %sms)%n", Duration.between(startTime, Instant.now()).toMillis());
    }
}