package ch.zhaw.thin;


import ch.zhaw.thin.band.Band;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Prompt for input
 *
 * @author Arik, Simon
 */
public class Console {

    private final Scanner scanner = new Scanner(System.in);
    private final PrintWriter writer = new PrintWriter(System.out, true);

    public static void main(String[] args) {
        // init resources
        Console console = new Console();

        // read band content
        String input = console.readBand();
        String[] splittedInput = input.split(" ");
        if (console.isInteger(splittedInput[0]) && console.isInteger(splittedInput[1])) {
            input = console.BuildBandBasedOnNumbers(splittedInput[0], splittedInput[1]);
        }

        // set run or step mode
        boolean stepMode = console.readIsStepMode();
        if (stepMode) {
            Mode.setStepMode();
        } else {
            Mode.setRunMode(console.readIsVerboseMode());
        }

        // init turing machine
        Band band = new Band(input);
        TuringMachine tm = new TuringMachine(band, console);
        tm.run();

        // close resources
        console.close();
    }

    public void waitForInput() {
        scanner.nextLine();
    }

    private String readBand() {
        writer.printf("%s", "Enter band content: ");
        return scanner.nextLine();
    }

    private boolean readIsStepMode() {
        writer.printf("%s", "Step mode [y/n]?: ");
        return "y".equals(scanner.nextLine());
    }

    private boolean readIsVerboseMode() {
        writer.printf("%s", "Verbose mode [y/n]?: ");
        return "y".equals(scanner.nextLine());
    }

    private String BuildBandBasedOnNumbers(String one, String two) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < Integer.parseInt(one); i++) {
            builder.append("*");
        }
        builder.append(" ");
        for(int i = 0; i < Integer.parseInt(two); i++) {
            builder.append("*");
        }
        return builder.toString();
    }

    private boolean isInteger(String stringToCheck) {
        try {
            Integer.parseInt(stringToCheck);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    private void close() {
        writer.close();
        scanner.close();
    }
}
