package Utils;

import lombok.Getter;

import java.util.List;
import java.util.stream.IntStream;

@Getter
public class NumberPairs {
    private final Integer firstNumber;
    private final Integer secondNumber;

    public NumberPairs(String numberPairAsString) {
        List<String> splitNumberPairAsString = List.of(numberPairAsString.split("-"));
        this.firstNumber = Integer.valueOf(splitNumberPairAsString.get(0));
        this.secondNumber = Integer.valueOf(splitNumberPairAsString.get(1));
    }

    public List<Integer> getAllNumbersInRangeOfNumberPair() {
        return IntStream.rangeClosed(firstNumber, secondNumber).boxed().toList();
    }
}
