import Utils.Monkey;

import java.util.List;

public class DayElevenImpl {

    public static Long getActivityForTwoMostActive(List<Monkey> listMonkey, Integer rounds, boolean doBoredom) {
        int modulus = listMonkey.stream().mapToInt(Monkey::getTest).reduce(1, Math::multiplyExact);
        for (int i = 1; i <= rounds; i++) {
            for (Monkey monkey : listMonkey) {
                List<Long> inventoryBefore = monkey.getInventory();
                for (Long item : monkey.getInventory()) {
                    Long worryLevel = doInspection(item, monkey);
                    monkey.setInspections(monkey.getInspections() + 1);
                    if (doBoredom) {
                        worryLevel = doMonkeyBoredom(worryLevel);
                    }
                    Long smallNumberWorry = worryLevel % modulus;
                    if (doTest(worryLevel, monkey)) {
                        addItemToReceivingMonkey(smallNumberWorry, Monkey.getMonkeyByName(monkey.getTestTrue(), listMonkey));
                    } else {
                        addItemToReceivingMonkey(smallNumberWorry, Monkey.getMonkeyByName(monkey.getTestFalse(), listMonkey));
                    }
                }
                monkey.getInventory().removeAll(inventoryBefore);
            }
        }
        int[] totalInspections = listMonkey.stream().map(Monkey::getInspections).mapToInt(Integer::intValue).sorted().toArray();
        return ((long) totalInspections[totalInspections.length - 2] * totalInspections[totalInspections.length - 1]);
    }

    private static Long doInspection(Long worryLevel, Monkey monkey) {
        String[] splitOperation = monkey.getOperation().split(" ");
        if (splitOperation[1].equals("old")) splitOperation[1] = String.valueOf(worryLevel);
        return switch (splitOperation[0]) {
            case "*" -> Math.multiplyExact(worryLevel, Long.parseLong(splitOperation[1]));
            case "+" -> Math.addExact(worryLevel, Long.parseLong(splitOperation[1]));
            default -> worryLevel;
        };
    }

    private static boolean doTest(Long worryLevel, Monkey monkey) {
        return 0 == worryLevel % monkey.getTest();
    }

    private static Long doMonkeyBoredom(Long worryLevel) {
        return worryLevel / 1;
    }

    private static void addItemToReceivingMonkey(Long worryLevel, Monkey receivingMonkey) {
        receivingMonkey.getInventory().add(worryLevel);
    }
}
