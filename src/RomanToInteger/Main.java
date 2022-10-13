package RomanToInteger;

import RomanToInteger.Data.Data;
import RomanToInteger.Data.IData;

public class Main {
    public static void main(String[] args) {
        IData data = new Data();
        while (data.breaker()) {
            data.input();
            data.output();
        }
    }
}
