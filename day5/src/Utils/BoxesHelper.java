package Utils;

import java.util.Comparator;
import java.util.List;

public class BoxesHelper {

    public static List<Boxes> getBoxesForColumn(List<Boxes> boxes, Integer x) {
        return boxes.stream().filter(box -> box.getX().equals(x)).toList();
    }

    public static List<String> getNamesForBoxesInColumn(List<Boxes> boxes, Integer x) {
        return getBoxesForColumn(boxes, x).stream().map(Boxes::getName).toList();
    }

    public static List<Integer> getXForBoxesInColumn(List<Boxes> boxes, Integer x) {
        return getBoxesForColumn(boxes, x).stream().map(Boxes::getX).toList();
    }

    public static List<Integer> getYForBoxesInColumn(List<Boxes> boxes, Integer x) {
        return getBoxesForColumn(boxes, x).stream().map(Boxes::getY).toList();
    }

    public static Boxes getHighestBoxForColumn(List<Boxes> boxes, Integer x) {
        return getBoxByCoordinates(boxes, x, getHighestYForColumn(boxes, x));
    }

    public static Integer getHighestYForColumn(List<Boxes> boxes, Integer x) {
        return boxes.stream().filter(box -> box.getX().equals(x)).map(Boxes::getY).max(Comparator.naturalOrder()).orElse(0);
    }

    public static Boxes getBoxByCoordinates(List<Boxes> boxes, Integer x, Integer y) {
        return boxes.stream().filter(box -> box.getX().equals(x) && box.getY().equals(y)).findFirst().orElse(new Boxes("", x, 0));
    }
}
