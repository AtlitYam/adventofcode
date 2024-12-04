import Utils.Boxes;
import Utils.BoxesHelper;
import Utils.Moves;

import java.util.List;
import java.util.stream.Collectors;

public class DayFiveImpl {

    public static String getLettersOnTop(List<Boxes> boxes) {
        return boxes.stream().map(Boxes::getX).distinct().sorted().toList().stream().map(column -> BoxesHelper.getHighestBoxForColumn(boxes, column).getName()).collect(Collectors.joining());
    }

    public static void performFirstChallengeMoves(List<Moves> movesList, List<Boxes> boxes) {
        for (Moves move : movesList) {
            for (int i = 0; i < move.getAmount(); i++) {
                Boxes currentBox = BoxesHelper.getHighestBoxForColumn(boxes, move.getStartX());
                currentBox.setY(BoxesHelper.getHighestYForColumn(boxes, move.getEndX()) + 1);
                currentBox.setX(move.getEndX());
            }
        }
    }

    public static void performSecondChallengeMoves(List<Moves> movesList, List<Boxes> boxes) {
        for (Moves move : movesList) {
            int endOldY = BoxesHelper.getHighestYForColumn(boxes, move.getEndX());
            for (int i = 0; i < move.getAmount(); i++) {
                Boxes currentBox = BoxesHelper.getHighestBoxForColumn(boxes, move.getStartX());
                currentBox.setX(move.getEndX());
                currentBox.setY(endOldY + move.getAmount() - i);
            }
        }
    }
}
