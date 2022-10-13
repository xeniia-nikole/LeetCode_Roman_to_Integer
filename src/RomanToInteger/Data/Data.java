package RomanToInteger.Data;

import RomanToInteger.Transfering.ITransfer;
import RomanToInteger.Transfering.TransferRomanNumeral;

import java.util.Scanner;

public class Data implements IData {
    private final ITransfer romanNumeral = new TransferRomanNumeral();
    private boolean breaker = true;
    public boolean breaker() {
        return breaker;
    }

    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 'O' to finish");
        System.out.print("Input: ");
        String input = scanner.nextLine().trim();
        if (input.equals("O")) breaker = false;
        romanNumeral.putInputNumeral(input);
    }

    public void output(){
        System.out.print("Output: " + romanNumeral.returnOutput() + "\nExplanations: " +
                romanNumeral.returnExplanation()+"\n");
    }

}
