import Utils.Trees;
import fileutils.FileLoader;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class DayEight {
    public static void main(String[] args) {
        Instant startTime = Instant.now();
        String filePath = "resources/DayEightChallenge.txt";
        DayEightImpl dayEightImpl = new DayEightImpl();
        List<Trees> forest = FileLoader.loadFileAsListOfTrees(filePath);

        // For the first challenge we have to figure out how many trees are visible from outside the forest
        System.out.printf("The amount of trees visible from outside the forest is %s%n", dayEightImpl.getUniqueTreesVisibleFromOutsideForest(forest));

        // For the second challenge we have to figure out how many trees can be seen from every tree and find the one with the highest scenic value
        System.out.printf("The tree with the highest scenic value has a scenic value of %s%n", dayEightImpl.getHighestScenicValue(forest));

        System.out.printf("(Completed in %sms)%n", Duration.between(startTime, Instant.now()).toMillis());
    }
}
