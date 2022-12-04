import listutils.ListMapper;
import utils.NumberPairs;

import java.util.HashSet;
import java.util.List;

import static fileutils.FileLoader.loadFileAsListOfLists;

public class DayFourImpl {
    ListMapper listMapper = new ListMapper();

    private static NumberPairs getFirstNumberPair(List<NumberPairs> numberPairs) {
        return numberPairs.get(0);
    }

    private static NumberPairs getSecondNumberPair(List<NumberPairs> numberPairs) {
        return numberPairs.get(1);
    }

    public Integer countEntirelyOverlappingNumberPairs(String filePath) {
        Integer overlappingNumberPairs = 0;
        List<List<NumberPairs>> listOfNumberPairs = listMapper.mapListToNumberPairs(loadFileAsListOfLists(filePath));

        for (List<NumberPairs> row : listOfNumberPairs) {
            if (isAllNumbersOverlapping(row)) {
                overlappingNumberPairs++;
            }
        }
        return overlappingNumberPairs;
    }

    public Integer countAnyOverlappingNumberPairs(String filePath) {
        Integer anyOverlapInNumberPairs = 0;
        List<List<NumberPairs>> listOfNumberPairs = listMapper.mapListToNumberPairs(loadFileAsListOfLists(filePath));

        for (List<NumberPairs> row : listOfNumberPairs) {
            if (isAnyNumberOverlapping(row)) {
                anyOverlapInNumberPairs++;
            }
        }
        return anyOverlapInNumberPairs;
    }

    private boolean isAllNumbersOverlapping(List<NumberPairs> numberPairs) {
        List<Integer> numbersInFirstPair = getFirstNumberPair(numberPairs).getAllNumbersInRangeOfNumberPair();
        List<Integer> numbersInSecondPair = getSecondNumberPair(numberPairs).getAllNumbersInRangeOfNumberPair();
        return new HashSet<>(numbersInFirstPair).containsAll(numbersInSecondPair) ||
                new HashSet<>(numbersInSecondPair).containsAll(numbersInFirstPair);
    }

    private boolean isAnyNumberOverlapping(List<NumberPairs> numberPairs) {
        List<Integer> numbersInFirstPair = getFirstNumberPair(numberPairs).getAllNumbersInRangeOfNumberPair();
        List<Integer> numbersInSecondPair = getSecondNumberPair(numberPairs).getAllNumbersInRangeOfNumberPair();
        return numbersInFirstPair.stream().anyMatch(numbersInSecondPair::contains);
    }
}
