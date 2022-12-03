import enums.Result;
import enums.RockPaperScissors;

import java.util.ArrayList;
import java.util.List;

import static enums.Result.*;
import static enums.RockPaperScissors.getShapeThatProducesExpectedResult;
import static enums.RockPaperScissors.getShapeWinsAgainst;
import static fileutils.FileLoader.loadFileAsList;

public class DayTwoImpl {
    // public functions
    public static Integer calculateTotalScoreFromMatchesIn(String filePath, boolean verbose) {
        int totalScore = 0;

        for (List<String> codes : getCodesFromFile(filePath)) {
            List<RockPaperScissors> shapes = getShapesFromCodes(codes);
            totalScore += calculateScoreForPlayer(shapes);

            if (verbose) {
                printMatchResults(isMatchResult(shapes), getOpponentShape(shapes).getName(), getPlayerShape(shapes).getName(), calculateScoreForPlayer(shapes));
            }
        }
        return totalScore;
    }

    public static Integer calculateExpectedTotalScoreFromMatchesIn(String filePath, boolean verbose) {
        int totalScore = 0;

        for (List<String> codes : getCodesFromFile(filePath)) {
            Result expectedResultForPlayer = getExpectedResultForPlayer(getPlayerCode(codes));
            RockPaperScissors opponentShape = RockPaperScissors.getShapeFromCode(getOpponentCode(codes));
            List<RockPaperScissors> shapes = List.of(opponentShape, getShapeThatProducesExpectedResult(opponentShape, expectedResultForPlayer));
            totalScore += calculateScoreForPlayer(shapes);

            if (verbose) {
                printMatchResults(isMatchResult(shapes), getOpponentShape(shapes).getName(), getPlayerShape(shapes).getName(), calculateScoreForPlayer(shapes));
            }
        }

        return totalScore;
    }

    // Private generic functions

    private static void printMatchResults(Result result, String opponentShapeName, String playerShapeName, Integer scoreForPlayer) {
        System.out.printf("The result of the match is a %s%n" +
                        "Opponent played %s while player played %s%n" +
                        "Total score for player was %s%n" +
                        "%n", result.equals(DRAW) ? result.getName() : result.getName() + " for the player",
                opponentShapeName, playerShapeName, scoreForPlayer);
    }

    private static List<List<String>> getCodesFromFile(String filePath) {
        List<String> file = loadFileAsList(filePath);
        List<List<String>> matches = new ArrayList<>();
        for (String row : file) {
            matches.add(List.of(row.split(" ")));
        }
        return matches;
    }

    private static Result isMatchResult(List<RockPaperScissors> shapes) {
        return getPlayerShape(shapes).equals(getOpponentShape(shapes)) ? DRAW :
                getShapeWinsAgainst(getPlayerShape(shapes)).equals(getOpponentShape(shapes)) ? WIN : LOSS;
    }

    private static Integer calculateScoreForPlayer(List<RockPaperScissors> shapes) {
        return isMatchResult(shapes).equals(DRAW) ? getPointsForDraw(getPlayerShape(shapes)) :
                isMatchResult(shapes).equals(WIN) ? getPointsForWin(getPlayerShape(shapes)) : getPointsForLoss(getPlayerShape(shapes));
    }

    private static Integer getPointsForWin(RockPaperScissors shape) {
        return WIN.getPoints() + shape.getPoints();
    }

    private static Integer getPointsForDraw(RockPaperScissors shape) {
        return DRAW.getPoints() + shape.getPoints();
    }

    private static Integer getPointsForLoss(RockPaperScissors shape) {
        return LOSS.getPoints() + shape.getPoints();
    }

    private static RockPaperScissors getPlayerShape(List<RockPaperScissors> shapes) {
        return shapes.get(1);
    }

    private static RockPaperScissors getOpponentShape(List<RockPaperScissors> shapes) {
        return shapes.get(0);
    }

    // Private functions for first challenge
    private static List<RockPaperScissors> getShapesFromCodes(List<String> codes) {
        return codes.stream().map(RockPaperScissors::getShapeFromCode).toList();
    }

    // Functions only for second Challenge
    private static Result getExpectedResultForPlayer(String code) {
        return Result.getExpectedResultFromCode(code);
    }

    private static String getPlayerCode(List<String> codes) {
        return codes.get(1);
    }

    private static String getOpponentCode(List<String> codes) {
        return codes.get(0);
    }
}
