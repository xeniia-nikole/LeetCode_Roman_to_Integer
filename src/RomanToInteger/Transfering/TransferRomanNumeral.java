package RomanToInteger.Transfering;

import java.util.*;

public class TransferRomanNumeral implements ITransfer {
    private StringBuilder explanation;
    private final Map<String, Integer> numerals;
    private String inputNumeral;

    public void putInputNumeral(String input) {
        this.inputNumeral = input;
    }

    public TransferRomanNumeral() {
        this.numerals = new HashMap<>();
        numerals.put("I", 1);
        numerals.put("V", 5);
        numerals.put("X", 10);
        numerals.put("L", 50);
        numerals.put("C", 100);
        numerals.put("D", 500);
        numerals.put("M", 1000);
    }

    private int transferring() {
        int result = 0;
        explanation = new StringBuilder();

        if (!inputNumeral.isEmpty()) {
            String[] splitStr = inputNumeral.split("");
            int[] integers = new int[splitStr.length];

            for (int i = 0; i < splitStr.length; i++) {
                if (numerals.containsKey(splitStr[i])) {
                    integers[i] = numerals.get(splitStr[i]);
                }
            }

            for (int i = 0; i < integers.length; i++) {
                if (integers[i] != 0) {
                    if (i == integers.length - 1) {
                        result += integers[i];
                        if (integers[i] != 0)
                            explanation.append(splitStr[i]).append(" = ").append(integers[i]).append("; ");
                        integers[i] = 0;
                    } else {
                        if (integers[i] > integers[i + 1]) {
                            result += integers[i];
                            explanation.append(splitStr[i]).append(" = ").append(integers[i]).append("; ");
                            integers[i] = 0;
                        } else if (integers[i] == integers[i + 1]) {
                            result += integers[i];
                            explanation.append(splitStr[i]).append(" = ").append(integers[i]).append("; ");
                            integers[i] = 0;
                        } else {
                            int difference = integers[i + 1] - integers[i];
                            result += difference;
                            explanation.append(splitStr[i]).append(splitStr[i + 1]).append(" = ").
                                    append(difference).append("; ");
                            integers[i] = 0;
                            integers[i + 1] = 0;
                        }
                    }
                }
            }
        }
        return result;
    }

    public String returnExplanation() {
        return explanation.toString();
    }

    @Override
    public int returnOutput() {
        return transferring();
    }
}
