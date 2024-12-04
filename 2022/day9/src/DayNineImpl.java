import Utils.HeadsAndTails;

import java.util.ArrayList;
import java.util.List;

public class DayNineImpl {
    public static Integer getTailUniquePositions(List<String> moves, boolean verbose) {
        HeadsAndTails head = new HeadsAndTails("H", 0, 0);
        HeadsAndTails tail = new HeadsAndTails("T", 0, 0);

        List<List<Integer>> uniquePositions = new ArrayList<>();
        // Adding the starting position
        uniquePositions.add(List.of(0, 0));

        Integer amountOfMoves = moves.size();
        Integer currentMove = 1;

        for (String move : moves) {
            String[] splitMove = move.split(" ");

            if (verbose) System.out.printf("Executing move %s out of %s%n", currentMove, amountOfMoves);
            switch (splitMove[0]) {
                case "L":
                    for (int i = 0; i < Integer.parseInt(splitMove[1]); i++) {
                        head.setX(head.getX() - 1);
                        updateTail(head, tail);
                        uniquePositions.add(List.of(tail.getX(), tail.getY()));
                        if (verbose) doLoggingChallengeOne(head, tail);
                    }
                    currentMove++;
                    continue;
                case "R":
                    for (int i = 0; i < Integer.parseInt(splitMove[1]); i++) {
                        head.setX(head.getX() + 1);
                        updateTail(head, tail);
                        uniquePositions.add(List.of(tail.getX(), tail.getY()));
                        if (verbose) doLoggingChallengeOne(head, tail);
                    }
                    currentMove++;
                    continue;
                case "U":
                    for (int i = 0; i < Integer.parseInt(splitMove[1]); i++) {
                        head.setY(head.getY() + 1);
                        updateTail(head, tail);
                        uniquePositions.add(List.of(tail.getX(), tail.getY()));
                        if (verbose) doLoggingChallengeOne(head, tail);
                    }
                    currentMove++;
                    continue;
                case "D":
                    for (int i = 0; i < Integer.parseInt(splitMove[1]); i++) {
                        head.setY(head.getY() - 1);
                        updateTail(head, tail);
                        uniquePositions.add(List.of(tail.getX(), tail.getY()));
                        if (verbose) doLoggingChallengeOne(head, tail);
                    }
                    currentMove++;
            }
        }
        return (int) uniquePositions.stream().distinct().count();
    }

    public static Integer getNinthTailUniquePositions(List<String> moves, boolean verbose) {
        HeadsAndTails head = new HeadsAndTails("H", 0, 0);
        HeadsAndTails tail1 = new HeadsAndTails("1", 0, 0);
        HeadsAndTails tail2 = new HeadsAndTails("2", 0, 0);
        HeadsAndTails tail3 = new HeadsAndTails("3", 0, 0);
        HeadsAndTails tail4 = new HeadsAndTails("4", 0, 0);
        HeadsAndTails tail5 = new HeadsAndTails("5", 0, 0);
        HeadsAndTails tail6 = new HeadsAndTails("6", 0, 0);
        HeadsAndTails tail7 = new HeadsAndTails("7", 0, 0);
        HeadsAndTails tail8 = new HeadsAndTails("8", 0, 0);
        HeadsAndTails tail9 = new HeadsAndTails("9", 0, 0);

        List<List<Integer>> uniquePositions = new ArrayList<>();
        // Adding the starting position
        uniquePositions.add(List.of(0, 0));

        Integer amountOfMoves = moves.size();
        Integer currentMove = 1;

        for (String move : moves) {
            String[] splitMove = move.split(" ");

            if (verbose) System.out.printf("Executing move %s out of %s%n", currentMove, amountOfMoves);
            switch (splitMove[0]) {
                case "L":
                    for (int i = 0; i < Integer.parseInt(splitMove[1]); i++) {
                        head.setX(head.getX() - 1);
                        updateTail(head, tail1);
                        updateTail(tail1, tail2);
                        updateTail(tail2, tail3);
                        updateTail(tail3, tail4);
                        updateTail(tail4, tail5);
                        updateTail(tail5, tail6);
                        updateTail(tail6, tail7);
                        updateTail(tail7, tail8);
                        updateTail(tail8, tail9);
                        uniquePositions.add(List.of(tail9.getX(), tail9.getY()));
                        if (verbose)
                            doLoggingChallengeTwo(head, tail1, tail2, tail3, tail4, tail5, tail6, tail7, tail8, tail9);
                    }
                    currentMove++;
                    continue;
                case "R":
                    for (int i = 0; i < Integer.parseInt(splitMove[1]); i++) {
                        head.setX(head.getX() + 1);
                        updateTail(head, tail1);
                        updateTail(tail1, tail2);
                        updateTail(tail2, tail3);
                        updateTail(tail3, tail4);
                        updateTail(tail4, tail5);
                        updateTail(tail5, tail6);
                        updateTail(tail6, tail7);
                        updateTail(tail7, tail8);
                        updateTail(tail8, tail9);
                        uniquePositions.add(List.of(tail9.getX(), tail9.getY()));
                        if (verbose)
                            doLoggingChallengeTwo(head, tail1, tail2, tail3, tail4, tail5, tail6, tail7, tail8, tail9);
                    }
                    currentMove++;
                    continue;
                case "U":
                    for (int i = 0; i < Integer.parseInt(splitMove[1]); i++) {
                        head.setY(head.getY() + 1);
                        updateTail(head, tail1);
                        updateTail(tail1, tail2);
                        updateTail(tail2, tail3);
                        updateTail(tail3, tail4);
                        updateTail(tail4, tail5);
                        updateTail(tail5, tail6);
                        updateTail(tail6, tail7);
                        updateTail(tail7, tail8);
                        updateTail(tail8, tail9);
                        uniquePositions.add(List.of(tail9.getX(), tail9.getY()));
                        if (verbose)
                            doLoggingChallengeTwo(head, tail1, tail2, tail3, tail4, tail5, tail6, tail7, tail8, tail9);
                    }
                    currentMove++;
                    continue;
                case "D":
                    for (int i = 0; i < Integer.parseInt(splitMove[1]); i++) {
                        head.setY(head.getY() - 1);
                        updateTail(head, tail1);
                        updateTail(tail1, tail2);
                        updateTail(tail2, tail3);
                        updateTail(tail3, tail4);
                        updateTail(tail4, tail5);
                        updateTail(tail5, tail6);
                        updateTail(tail6, tail7);
                        updateTail(tail7, tail8);
                        updateTail(tail8, tail9);
                        uniquePositions.add(List.of(tail9.getX(), tail9.getY()));
                        if (verbose)
                            doLoggingChallengeTwo(head, tail1, tail2, tail3, tail4, tail5, tail6, tail7, tail8, tail9);
                    }
                    currentMove++;
            }
        }
        return (int) uniquePositions.stream().distinct().count();
    }

    private static Integer getDifferenceInX(HeadsAndTails head, HeadsAndTails tail) {
        return head.getX() - tail.getX();
    }

    private static Integer getDifferenceInY(HeadsAndTails head, HeadsAndTails tail) {
        return head.getY() - tail.getY();
    }

    private static HeadsAndTails updateTail(HeadsAndTails head, HeadsAndTails tail) {
        // 1:
        if (getDifferenceInX(head, tail) == -1 & getDifferenceInY(head, tail) == 2) {
            tail.setX(tail.getX() - 1);
            tail.setY(tail.getY() + 1);
        }

        // 2:
        if (getDifferenceInX(head, tail) == 0 & getDifferenceInY(head, tail) == 2) {
            tail.setY(tail.getY() + 1);
        }

        // 3:
        if (getDifferenceInX(head, tail) == 1 & getDifferenceInY(head, tail) == 2) {
            tail.setX(tail.getX() + 1);
            tail.setY(tail.getY() + 1);
        }

        // 4:
        if (getDifferenceInX(head, tail) == 2 & getDifferenceInY(head, tail) == 1) {
            tail.setX(tail.getX() + 1);
            tail.setY(tail.getY() + 1);
        }

        // 5:
        if (getDifferenceInX(head, tail) == 2 & getDifferenceInY(head, tail) == 0) {
            tail.setX(tail.getX() + 1);
        }

        // 6:
        if (getDifferenceInX(head, tail) == 2 & getDifferenceInY(head, tail) == -1) {
            tail.setX(tail.getX() + 1);
            tail.setY(tail.getY() - 1);
        }

        // 7:
        if (getDifferenceInX(head, tail) == 1 & getDifferenceInY(head, tail) == -2) {
            tail.setX(tail.getX() + 1);
            tail.setY(tail.getY() - 1);
        }

        // 8:
        if (getDifferenceInX(head, tail) == 0 & getDifferenceInY(head, tail) == -2) {
            tail.setY(tail.getY() - 1);
        }

        // 9:
        if (getDifferenceInX(head, tail) == -1 & getDifferenceInY(head, tail) == -2) {
            tail.setX(tail.getX() - 1);
            tail.setY(tail.getY() - 1);
        }

        // 10:
        if (getDifferenceInX(head, tail) == -2 & getDifferenceInY(head, tail) == -1) {
            tail.setX(tail.getX() - 1);
            tail.setY(tail.getY() - 1);
        }

        // 11:
        if (getDifferenceInX(head, tail) == -2 & getDifferenceInY(head, tail) == 0) {
            tail.setX(tail.getX() - 1);
        }

        // 12:
        if (getDifferenceInX(head, tail) == -2 & getDifferenceInY(head, tail) == 1) {
            tail.setX(tail.getX() - 1);
            tail.setY(tail.getY() + 1);
        }

        // For the extra tail more moves were possible
        // 13:
        if (getDifferenceInX(head, tail) == -2 & getDifferenceInY(head, tail) == 2) {
            tail.setX(tail.getX() - 1);
            tail.setY(tail.getY() + 1);
        }

        // 14:
        if (getDifferenceInX(head, tail) == 2 & getDifferenceInY(head, tail) == 2) {
            tail.setX(tail.getX() + 1);
            tail.setY(tail.getY() + 1);
        }

        // 15:
        if (getDifferenceInX(head, tail) == 2 & getDifferenceInY(head, tail) == -2) {
            tail.setX(tail.getX() + 1);
            tail.setY(tail.getY() - 1);
        }

        // 16:
        if (getDifferenceInX(head, tail) == -2 & getDifferenceInY(head, tail) == -2) {
            tail.setX(tail.getX() - 1);
            tail.setY(tail.getY() - 1);
        }

        return tail;
    }

    private static void doLoggingChallengeOne(HeadsAndTails head, HeadsAndTails tail) {
        System.out.printf("Tail is lacking behind in X by %s%n", (head.getX() - tail.getX()));
        System.out.printf("Tail is lacking behind in Y by %s%n", (head.getY() - tail.getY()));
        System.out.printf("Head X %s, Y %s | Tail X %s, Y %s%n", head.getX(), head.getY(), tail.getX(), tail.getY());
    }

    private static void doLoggingChallengeTwo(HeadsAndTails head, HeadsAndTails tail1, HeadsAndTails tail2, HeadsAndTails tail3, HeadsAndTails tail4, HeadsAndTails tail5, HeadsAndTails tail6, HeadsAndTails tail7, HeadsAndTails tail8, HeadsAndTails tail9) {
        System.out.printf("Tail is lacking behind in X by %s%n", (head.getX() - tail9.getX()));
        System.out.printf("Tail is lacking behind in Y by %s%n", (head.getY() - tail9.getY()));
        System.out.printf("Head X %s, Y %s | Tail1 X %s, Y %s | Tail2 X %s, Y %s | Tail3 X %s, Y %s | Tail4 X %s, Y %s | Tail5 X %s, Y %s | Tail6 X %s, Y %s | Tail7 X %s, Y %s | Tail8 X %s, Y %s | Tail9 X %s, Y %s%n",
                head.getX(), head.getY(),
                tail1.getX(), tail1.getY(),
                tail2.getX(), tail2.getY(),
                tail3.getX(), tail3.getY(),
                tail4.getX(), tail4.getY(),
                tail5.getX(), tail5.getY(),
                tail6.getX(), tail6.getY(),
                tail7.getX(), tail7.getY(),
                tail8.getX(), tail8.getY(),
                tail9.getX(), tail9.getY());
    }
}
