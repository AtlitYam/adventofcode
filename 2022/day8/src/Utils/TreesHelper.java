package Utils;

import java.util.Comparator;
import java.util.List;

public class TreesHelper {
    public static Integer getHighestX(List<Trees> forest) {
        return forest.stream().max(Comparator.comparing(Trees::getX)).get().getX();
    }

    public static Integer getLowestX(List<Trees> forest) {
        return forest.stream().min(Comparator.comparing(Trees::getX)).get().getX();
    }

    public static Integer getHighestY(List<Trees> forest) {
        return forest.stream().max(Comparator.comparing(Trees::getY)).get().getY();
    }

    public static Integer getLowestY(List<Trees> forest) {
        return forest.stream().min(Comparator.comparing(Trees::getY)).get().getY();
    }
}
