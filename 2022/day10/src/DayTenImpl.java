import java.util.HashMap;
import java.util.List;

public class DayTenImpl {
    public static Integer getTotalSignalStrength(List<String> commands) {
        int X = 1;
        int cycles = 0;
        HashMap<Integer, Integer> signalStrengths = new HashMap<>();
        List<Integer> checkingCycles = List.of(20, 60, 100, 140, 180, 220);
        for (String command : commands) {
            String[] splitCommand = command.split(" ");
            switch (splitCommand[0]) {
                case "noop" -> {
                    if (!signalStrengths.containsKey(cycles + 1)) {
                        if (checkingCycles.contains(cycles + 1)) {
                            signalStrengths.put(cycles + 1, X * (cycles + 1));
                        }
                    }
                    cycles++;
                    continue;
                }
                case "addx" -> {
                    if (!signalStrengths.containsKey(cycles + 1)) {
                        if (checkingCycles.contains(cycles + 1)) {
                            signalStrengths.put(cycles + 1, X * (cycles + 1));
                        }
                    }

                    if (!signalStrengths.containsKey(cycles + 2)) {
                        if (checkingCycles.contains(cycles + 2)) {
                            signalStrengths.put(cycles + 2, X * (cycles + 2));
                        }
                    }

                    X += Integer.parseInt(splitCommand[1]);
                    cycles += 2;
                }
            }

            if (!signalStrengths.containsKey(cycles)) {
                if (checkingCycles.contains(cycles)) {
                    signalStrengths.put(cycles, X * cycles);
                }
            }
        }
        return signalStrengths.values().stream().mapToInt(Integer::intValue).sum();
    }

    public static String getCRTOutput(List<String> commands) {
        int X = 1;
        int cycles = 0;
        HashMap<Integer, String> crtOutput = new HashMap<>();
        for (String command : commands) {
            String[] splitCommand = command.split(" ");
            switch (splitCommand[0]) {
                case "noop":
//                    if (X - 1 == cycles || X == cycles || X + 1 == cycles) {
//                        crtOutput.put(cycles, "#");
//                    } else {
//                        crtOutput.put(cycles, ".");
//                    }
//                    if (X - 1 == cycles + 1 || X == cycles + 1 || X + 1 == cycles + 1) {
//                        crtOutput.put(cycles + 1, "#");
//                    } else {
//                        crtOutput.put(cycles + 1, ".");
//                    }
                    updateCRT(cycles, X, crtOutput);
                    cycles++;
                    continue;
                case "addx":
//                    if (X - 1 == cycles || X == cycles || X + 1 == cycles) {
//                        crtOutput.put(cycles, "#");
//                    } else {
//                        crtOutput.put(cycles, ".");
//                    }
//                    if (X - 1 == cycles + 1 || X == cycles + 1 || X + 1 == cycles + 1) {
//                        crtOutput.put(cycles + 1, "#");
//                    } else {
//                        crtOutput.put(cycles + 1, ".");
//                    }
//                    if (X - 1 == cycles + 2 || X == cycles + 2 || X + 1 == cycles + 2) {
//                        crtOutput.put(cycles + 2, "#");
//                    } else {
//                        crtOutput.put(cycles + 2, ".");
//                    }
                    updateCRT(cycles, X, crtOutput);
                    X += Integer.parseInt(splitCommand[1]);
                    cycles += 2;
            }
            updateCRT(cycles, X, crtOutput);
        }
        return String.join("", crtOutput.values());
    }

    public static void updateCRT(Integer cycles, Integer X, HashMap<Integer, String> crtOutput) {
        if (cycles < 40) {
            if (X - 1 == cycles || X == cycles || X + 1 == cycles) {
                crtOutput.put(cycles, "#");
            } else {
                crtOutput.put(cycles, ".");
            }
            if (X - 1 == cycles + 1 || X == cycles + 1 || X + 1 == cycles + 1) {
                crtOutput.put(cycles + 1, "#");
            } else {
                crtOutput.put(cycles + 1, ".");
            }
            if (X - 1 == cycles + 2 || X == cycles + 2 || X + 1 == cycles + 2) {
                crtOutput.put(cycles + 2, "#");
            } else {
                crtOutput.put(cycles + 2, ".");
            }
        }
        if (cycles >= 39 & cycles < 80) {
            if (X - 1 == cycles - 40 || X == cycles - 40 || X + 1 == cycles - 40) {
                crtOutput.put(cycles, "#");
            } else {
                crtOutput.put(cycles, ".");
            }
            if (X - 1 == cycles + 1 - 40 || X == cycles + 1 - 40 || X + 1 == cycles + 1 - 40) {
                crtOutput.put(cycles + 1, "#");
            } else {
                crtOutput.put(cycles + 1, ".");
            }
            if (X - 1 == cycles + 2 - 40 || X == cycles + 2 - 40 || X + 1 == cycles + 2 - 40) {
                crtOutput.put(cycles + 2, "#");
            } else {
                crtOutput.put(cycles + 2, ".");
            }
        }

        if (cycles >= 79 & cycles < 120) {
            if (X - 1 == cycles - 80 || X == cycles - 80 || X + 1 == cycles - 80) {
                crtOutput.put(cycles, "#");
            } else {
                crtOutput.put(cycles, ".");
            }
            if (X - 1 == cycles + 1 - 80 || X == cycles + 1 - 80 || X + 1 == cycles + 1 - 80) {
                crtOutput.put(cycles + 1, "#");
            } else {
                crtOutput.put(cycles + 1, ".");
            }
            if (X - 1 == cycles + 2 - 80 || X == cycles + 2 - 80 || X + 1 == cycles + 2 - 80) {
                crtOutput.put(cycles + 2, "#");
            } else {
                crtOutput.put(cycles + 2, ".");
            }
        }

        if (cycles >= 119 & cycles < 160) {
            if (X - 1 == cycles - 120 || X == cycles - 120 || X + 1 == cycles - 120) {
                crtOutput.put(cycles, "#");
            } else {
                crtOutput.put(cycles, ".");
            }
            if (X - 1 == cycles + 1 - 120 || X == cycles + 1 - 120 || X + 1 == cycles + 1 - 120) {
                crtOutput.put(cycles + 1, "#");
            } else {
                crtOutput.put(cycles + 1, ".");
            }
            if (X - 1 == cycles + 2 - 120 || X == cycles + 2 - 120 || X + 1 == cycles + 2 - 120) {
                crtOutput.put(cycles + 2, "#");
            } else {
                crtOutput.put(cycles + 2, ".");
            }
        }

        if (cycles >= 159 & cycles < 200) {
            if (X - 1 == cycles - 160 || X == cycles - 160 || X + 1 == cycles - 160) {
                crtOutput.put(cycles, "#");
            } else {
                crtOutput.put(cycles, ".");
            }
            if (X - 1 == cycles + 1 - 160 || X == cycles + 1 - 160 || X + 1 == cycles + 1 - 160) {
                crtOutput.put(cycles + 1, "#");
            } else {
                crtOutput.put(cycles + 1, ".");
            }
            if (X - 1 == cycles + 2 - 160 || X == cycles + 2 - 160 || X + 1 == cycles + 2 - 160) {
                crtOutput.put(cycles + 2, "#");
            } else {
                crtOutput.put(cycles + 2, ".");
            }
        }

        if (cycles >= 199 & cycles < 241) {
            if (X - 1 == cycles - 200 || X == cycles - 200 || X + 1 == cycles - 200) {
                crtOutput.put(cycles, "#");
            } else {
                crtOutput.put(cycles, ".");
            }
            if (X - 1 == cycles + (1 - 200) || X == cycles + (1 - 200) || X + 1 == cycles + (1 - 200)) {
                crtOutput.put(cycles + 1, "#");
            } else {
                crtOutput.put(cycles + 1, ".");
            }
            if (X - 1 == cycles + (2 - 200) || X == cycles + (2 - 200) || X + 1 == cycles + (2 - 200)) {
                crtOutput.put(cycles + 2, "#");
            } else {
                crtOutput.put(cycles + 2, ".");
            }
        }
    }
}