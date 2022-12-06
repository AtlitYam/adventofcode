package Utils;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public class Moves {
    final Integer amount;
    final Integer startX;
    final Integer endX;

    public Moves(Integer amount, Integer startX, Integer endX) {
        this.amount = amount;
        this.startX = startX;
        this.endX = endX;
    }

    public static Moves mapStringToMove(String s) {
        List<Integer> integers = new ArrayList<>();
        Scanner sc = new Scanner(s);
        while (sc.hasNext()) {
            boolean scanned = false;
            if (sc.hasNextInt()) {
                integers.add(sc.nextInt());
                scanned = true;
            }
            if (!scanned)
                sc.next();
        }
        return new Moves(integers.get(0), integers.get(1), integers.get(2));
    }
}
